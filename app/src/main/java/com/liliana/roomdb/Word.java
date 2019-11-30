package com.liliana.roomdb;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tword")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word_info")
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word(String word) {
        this.word = word;
    }
}
