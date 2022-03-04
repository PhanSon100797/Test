package com.teckja.test12.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "Manager",primaryKeys = "_id")
public class ManagerEntity {
    @NonNull
    @ColumnInfo(name = "_id")
    private int id;

    @NonNull
    @ColumnInfo(name = "Pass")
    private int pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public int getPass() {
        return pass;
    }

    public void setPass(@NonNull int pass) {
        this.pass = pass;
    }
}
