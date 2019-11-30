package com.liliana.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Word.class},version = 1)
public abstract class WordRoomDataBase extends RoomDatabase {
    private static volatile WordRoomDataBase Instance;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    abstract DaoWord daoWord();
   static synchronized WordRoomDataBase GetDB(final Context context){
       if(Instance ==null){
           Instance = Room.databaseBuilder(context.getApplicationContext(),WordRoomDataBase.class,"db")
                   .fallbackToDestructiveMigration()
                     .build();
       }return Instance;
   }

}
