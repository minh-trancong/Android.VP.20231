package com.example.android.unscramble.ui.game;

import java.lang.System;

/**
 * ViewModel containing the app data and methods to process the data
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/android/unscramble/ui/game/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_currentScrambledWord", "Landroidx/lifecycle/MutableLiveData;", "", "_currentWordCount", "", "kotlin.jvm.PlatformType", "_score", "currentScrambledWord", "Landroidx/lifecycle/LiveData;", "Landroid/text/Spannable;", "getCurrentScrambledWord", "()Landroidx/lifecycle/LiveData;", "currentWord", "currentWordCount", "getCurrentWordCount", "isGameOver", "", "score", "getScore", "wordsList", "", "getNextWord", "", "increaseScore", "isUserWordCorrect", "playerWord", "nextWord", "reinitializeData", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _score = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentWordCount = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _currentScrambledWord = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<android.text.Spannable> currentScrambledWord = null;
    private java.util.List<java.lang.String> wordsList;
    private java.lang.String currentWord;
    private boolean isGameOver = false;
    
    public GameViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getScore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getCurrentWordCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<android.text.Spannable> getCurrentScrambledWord() {
        return null;
    }
    
    private final void getNextWord() {
    }
    
    public final void reinitializeData() {
    }
    
    private final void increaseScore() {
    }
    
    public final boolean isUserWordCorrect(@org.jetbrains.annotations.NotNull
    java.lang.String playerWord) {
        return false;
    }
    
    public final boolean nextWord() {
        return false;
    }
    
    public final boolean isGameOver() {
        return false;
    }
}