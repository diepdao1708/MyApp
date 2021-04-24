package com.example.myapplication.question;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.question.EntityClass.Question;
import com.example.myapplication.question.data.QuestionDAO;

@Database(entities = {Question.class}, version = 1)
public abstract class QuestionDatabase extends RoomDatabase{
    public static final String DATABASE_NAME = "tracnghiem.db";
    public static QuestionDatabase instance;

    public static synchronized QuestionDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), QuestionDatabase.class, DATABASE_NAME)
                    .createFromAsset("tracnghiem.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract QuestionDAO questionDAO();
}


