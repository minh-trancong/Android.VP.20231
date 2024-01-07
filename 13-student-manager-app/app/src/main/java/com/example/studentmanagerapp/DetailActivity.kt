package com.example.studentmanagerapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {
    private lateinit var db: StudentDB
    private lateinit var studentDao: StudentDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        db = Room.databaseBuilder(
            applicationContext,
            StudentDB::class.java, "student_db"
        ).build()

        // Lấy thực thể DAO từ cơ sở dữ liệu
        studentDao = db.studentDao()
        val student = intent.getSerializableExtra("student") as? Student
        if (student != null) {
            // Hiển thị thông tin sinh viên trong giao diện DetailActivity
            findViewById<TextView>(R.id.detail_mssv).text = student.mssv
            findViewById<EditText>(R.id.detail_name).setText(student.fullName)
            findViewById<EditText>(R.id.detail_dob).setText(student.dateOfBirth)
            findViewById<EditText>(R.id.detail_hometown).setText(student.country)

        }
        findViewById<Button>(R.id.btn_delete).setOnClickListener(){
            lifecycleScope.launch {

                val students = withContext(Dispatchers.IO) {
                    if (student != null) {
                        studentDao.deleteStudent(student)
                    }

                }
                val intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
        findViewById<Button>(R.id.btn_update).setOnClickListener(){
            lifecycleScope.launch {

                val students = withContext(Dispatchers.IO) {
                    if (student != null) {
                        student.mssv = findViewById<EditText>(R.id.detail_mssv).text.toString()
                        student.fullName = findViewById<EditText>(R.id.detail_name).text.toString()
                        student.dateOfBirth = findViewById<EditText>(R.id.detail_dob).text.toString()
                        student.country = findViewById<EditText>(R.id.detail_hometown).text.toString()


                        studentDao.updateStudent(student)
                    }

                }
                val intent = Intent()
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }
}