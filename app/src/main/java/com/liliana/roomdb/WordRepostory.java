package com.liliana.roomdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepostory {
    private DaoWord mdaoWord;
    private LiveData<List<Word>> mAllWord;

    public WordRepostory(Application application) {
        WordRoomDataBase db = WordRoomDataBase.GetDB(application);
        mdaoWord = db.daoWord();
        mAllWord = mdaoWord.GetAllWord();
    }

    LiveData<List<Word>> GetAllWord() {
        return mAllWord;
    }

    void Insert(Word word) {
        WordRoomDataBase.databaseWriteExecutor.execute(() -> {
            mdaoWord.Insert(word);
        });
    }
    void deleteAll() {
        WordRoomDataBase.databaseWriteExecutor.execute(() -> {
            mdaoWord.DeleteAllWord();
        });
    }
    public LiveData<Integer> getCount() {
        return mdaoWord.coutWord();
    }
    void udWord(String word){ WordRoomDataBase.databaseWriteExecutor.execute(() -> {
        mdaoWord.updateAWord(word);
    });}

    void updateWord(Word word){
        WordRoomDataBase.databaseWriteExecutor.execute(() -> {
            mdaoWord.updateWord(word);
        });
    }
    void Delete(Word word) {
        new deleteWordAsyncTask(mdaoWord).execute(word);
    }

    private static class deleteWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private DaoWord mAsyncTaskDao;

        deleteWordAsyncTask(DaoWord dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}