package com.teckja.test12.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "Question",primaryKeys = "_id")
public class QuestionEntity {
    @ColumnInfo(name = "question")
    private String question;

    @NonNull
    @ColumnInfo(name = "_id")
    private int id;

    @NonNull
    @ColumnInfo(name = "level")
    private int level;

    @NonNull
    @ColumnInfo(name = "truecase")
    private int trueCase;

    @ColumnInfo(name = "casea")
    private String caseA;

    @ColumnInfo(name = "caseb")
    private String caseB;

    @ColumnInfo(name = "casec")
    private String caseC;

    @ColumnInfo(name = "cased")
    private String caseD;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public int getLevel() {
        return level;
    }

    public void setLevel(@NonNull int level) {
        this.level = level;
    }

    @NonNull
    public int getTrueCase() {
        return trueCase;
    }

    public void setTrueCase(@NonNull int trueCase) {
        this.trueCase = trueCase;
    }

    public String getCaseA() {
        return caseA;
    }

    public void setCaseA(String caseA) {
        this.caseA = caseA;
    }

    public String getCaseB() {
        return caseB;
    }

    public void setCaseB(String caseB) {
        this.caseB = caseB;
    }

    public String getCaseC() {
        return caseC;
    }

    public void setCaseC(String caseC) {
        this.caseC = caseC;
    }

    public String getCaseD() {
        return caseD;
    }

    public void setCaseD(String caseD) {
        this.caseD = caseD;
    }
}
