package com.teckja.test12.manager;

import com.teckja.test12.App;
import com.teckja.test12.MTask;
import com.teckja.test12.entities.HighScoreEntity;

public class QuestionManager {
    private static QuestionManager instance;

    public QuestionManager() {
        //for singleton
    }

    public static QuestionManager getInstance() {
        if (instance == null) {
            instance = new QuestionManager();
        }
        return instance;
    }

    public void getListQuestion(OnDataCallBack callBack) {
        MTask task = new MTask(null, new MTask.OnMTaskCallBack() {
            @Override
            public Object execTask(String key, MTask task, Object data) {
                return App.getInstance().getQuestionDB().questionDAO().getListQuestion();
            }

            @Override
            public void completeTask(String key, Object value) {
                callBack.callBack(key, value);
            }
        });
        task.startAsync(null);
    }

    public void addScore(HighScoreEntity score, OnDataCallBack callBack) {
        MTask task = new MTask(null, new MTask.OnMTaskCallBack() {
            @Override
            public Object execTask(String key, MTask task, Object data) {
                try {
                    App.getInstance().getQuestionDB().questionDAO().addScore((HighScoreEntity) data);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            public void completeTask(String key, Object value) {
                callBack.callBack(key, value);
            }
        });
        task.startAsync(score);
    }

    public void getTopScore(OnDataCallBack callBack) {
        MTask task = new MTask(null, new MTask.OnMTaskCallBack() {
            @Override
            public Object execTask(String key, MTask task, Object data) {
                return App.getInstance().getQuestionDB().questionDAO().getTopScore();
            }

            @Override
            public void completeTask(String key, Object value) {
                callBack.callBack(key, value);
            }
        });
        task.startAsync(null);
    }
    public void deleteHScore(OnDataCallBack callBack) {
        MTask task = new MTask(null, new MTask.OnMTaskCallBack() {
            @Override
            public Object execTask(String key, MTask task, Object data) {
                 App.getInstance().getQuestionDB().questionDAO().delete();
                 return true;
            }

            @Override
            public void completeTask(String key, Object value) {
                callBack.callBack(key, value);
            }
        });
        task.startAsync(null);
    }
}
