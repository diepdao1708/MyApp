package com.example.myapplication.question.EntityClass;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tracnghiem")
public class Question implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private  int _id;

    @ColumnInfo(name = "question")
    private  String question;

    @ColumnInfo(name = "ans_a")
    private  String ans_a;

    @ColumnInfo(name = "ans_b")
    private  String ans_b;

    @ColumnInfo(name = "ans_c")
    private  String ans_c;

    @ColumnInfo(name = "ans_d")
    private  String ans_d;

    @ColumnInfo(name = "result")
    private  String result;

    @ColumnInfo(name = "num_exam")
    private String num_exam;

    @ColumnInfo(name = "subject")
    private  String subject;

    @ColumnInfo(name = "traloi")
    private String traloi;

    @ColumnInfo(name = "image")
    private  String image;

    public Question(int _id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, String num_exam, String subject, String traloi, String image) {
        this._id = _id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.num_exam = num_exam;
        this.subject = subject;
        this.traloi = traloi;
        this.image = image;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNum_exam(String num_exam) {
        this.num_exam = num_exam;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int get_id() {
        return _id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public String getResult() {
        return result;
    }

    public String getNum_exam() {
        return num_exam;
    }

    public String getSubject() {
        return subject;
    }

    public String getTraloi() {
        return traloi;
    }

    public String getImage() {
        return image;
    }
}

