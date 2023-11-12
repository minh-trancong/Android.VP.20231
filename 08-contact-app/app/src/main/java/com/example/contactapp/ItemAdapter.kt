import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.ItemModel
import com.example.contactapp.R
import com.example.contactapp.SecondActivity

class ItemAdapter(val items: ArrayList<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.contact_img)
        val name = itemView.findViewById<TextView>(R.id.contact_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val firstLetter = items[position].nameAcc[0].toString()
        val image = createImageWithText(firstLetter)
        holder.img.setImageBitmap(image)
        holder.name.text = items[position].nameAcc
        holder.name.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("name", items[position].nameAcc)
            context.startActivity(intent)
        }
        holder.itemView.setOnCreateContextMenuListener { menu, v, menuInfo ->
        }
    }

    private fun createImageWithText(text: String): Bitmap {
        val bitmap = Bitmap.createBitmap(70, 70, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val bgPaint = Paint()
        bgPaint.color = Color.GRAY
        bgPaint.isAntiAlias = true
        canvas.drawCircle(bitmap.width / 2f, bitmap.height / 2f, bitmap.width / 2f, bgPaint)

        val textPaint = Paint()
        textPaint.color = Color.WHITE
        textPaint.textSize = 30f
        textPaint.isAntiAlias = true
        textPaint.typeface = Typeface.DEFAULT_BOLD

        val bounds = Rect()
        textPaint.getTextBounds(text, 0, text.length, bounds)

        val x = (bitmap.width - bounds.width()) / 2
        val y = (bitmap.height + bounds.height()) / 2

        canvas.drawText(text, x.toFloat(), y.toFloat(), textPaint)

        return bitmap
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
