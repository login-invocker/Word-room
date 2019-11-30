package com.liliana.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoWord {
    @Query("update tword set word_info=:udateword ")
    void updateAWord(String udateword);

    @Query("select COUNT(*) from tword")
    LiveData<Integer> coutWord();

    @Query("select * from tword")
    LiveData<List<Word>> GetAllWord();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void Insert(Word word);

    @Query("delete from tword")
    void DeleteAllWord();

    @Delete
    void delete(Word words);

    @Update
    void updateWord(Word word);

}
