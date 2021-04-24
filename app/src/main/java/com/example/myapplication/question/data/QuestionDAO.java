package com.example.myapplication.question.data;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.question.EntityClass.Question;


import java.util.List;


@Dao
public interface QuestionDAO {
    @Insert
    void insertQuestion(Question question);

    @Query("SELECT * FROM tracnghiem WHERE num_exam = :num_exam AND subject = :subject")
    List<Question> getAllQuestion(String num_exam, String subject);

//    @Query("SELECT * FROM tracnghiem")
//    List<Question> getAllQuestion();

}
