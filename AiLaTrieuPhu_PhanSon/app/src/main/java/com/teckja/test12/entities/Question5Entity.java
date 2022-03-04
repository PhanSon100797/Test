package com.teckja.test12.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "Question5", primaryKeys = "_id")
public class Question5Entity {
    @NonNull
    @ColumnInfo(name = "Question")
    private String question;

    @NonNull
    @ColumnInfo(name = "_id")
    private int id;

    @NonNull
    @ColumnInfo(name = "TrueCase")
    private int trueCase;

    @NonNull
    @ColumnInfo(name = "CaseA")
    private String caseA;

    @NonNull
    @ColumnInfo(name = "CaseB")
    private String caseB;

    @NonNull
    @ColumnInfo(name = "CaseC")
    private String caseC;

    @NonNull
    @ColumnInfo(name = "CaseD")
    private String caseD;

    @NonNull
    public String getQuestion() {
        return question;
    }

    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrueCase() {
        return trueCase;
    }

    public void setTrueCase(int trueCase) {
        this.trueCase = trueCase;
    }

    @NonNull
    public String getCaseA() {
        return caseA;
    }

    public void setCaseA(@NonNull String caseA) {
        this.caseA = caseA;
    }

    @NonNull
    public String getCaseB() {
        return caseB;
    }

    public void setCaseB(@NonNull String caseB) {
        this.caseB = caseB;
    }

    @NonNull
    public String getCaseC() {
        return caseC;
    }

    public void setCaseC(@NonNull String caseC) {
        this.caseC = caseC;
    }

    @NonNull
    public String getCaseD() {
        return caseD;
    }

    public void setCaseD(@NonNull String caseD) {
        this.caseD = caseD;
    }
}
