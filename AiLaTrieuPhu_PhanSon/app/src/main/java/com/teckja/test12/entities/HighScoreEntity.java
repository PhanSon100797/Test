package com.teckja.test12.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "HighScore",primaryKeys = "ID")
public class HighScoreEntity {
    @NonNull
    @ColumnInfo(name = "Name")
    private String name;

    @NonNull
    @ColumnInfo(name = "Score")
    private int score;

    @NonNull
    @ColumnInfo(name = "ID")
    private int id;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public int getScore() {
        return score;
    }

    public void setScore(@NonNull int score) {
        this.score = score;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HighScoreEntity{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }
}
