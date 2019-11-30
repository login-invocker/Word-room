package com.liliana.roomdb;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
public class WordViewModel extends AndroidViewModel {
    private WordRepostory mwordRepostory;
    private LiveData<List<Word>> mAllWord;
    public WordViewModel(Application application){
        super(application);
        mwordRepostory=new WordRepostory(application);
        mAllWord=mwordRepostory.GetAllWord();
    }
    LiveData<List<Word>> GetALlWord(){return mAllWord;}
    void Insert(Word word){mwordRepostory.Insert(word);}
    LiveData<Integer> countWord(){return mwordRepostory.getCount();}
    public void deleteWord(Word word) {mwordRepostory.Delete(word);}
    public void deleteAllWord(){mwordRepostory.deleteAll();}
   public void updateWord(String udword){mwordRepostory.udWord(udword);}
   public void udWord(Word word){mwordRepostory.updateWord(word);}
}
