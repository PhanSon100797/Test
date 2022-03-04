package com.teckja.test12;

import android.app.Application;

import androidx.room.Room;


public class App extends Application {
    private static App instance;
    private Storage storage;
    private QuestionDB questionDB;

    public QuestionDB getQuestionDB() {
        return questionDB;
    }
    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        storage = new Storage();
        questionDB = Room.databaseBuilder(this,
                QuestionDB.class, "question.db").createFromAsset("Question.db").build();
    }
    public Storage getStorage() {
        return storage;
    }

}
