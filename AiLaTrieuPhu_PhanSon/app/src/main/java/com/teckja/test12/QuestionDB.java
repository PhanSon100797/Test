package com.teckja.test12;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.teckja.test12.db.dao.QuestionDAO;
import com.teckja.test12.entities.HighScoreEntity;
import com.teckja.test12.entities.Question10Entity;
import com.teckja.test12.entities.Question11Entity;
import com.teckja.test12.entities.Question12Entity;
import com.teckja.test12.entities.Question13Entity;
import com.teckja.test12.entities.Question14Entity;
import com.teckja.test12.entities.Question15Entity;
import com.teckja.test12.entities.Question1Entity;
import com.teckja.test12.entities.Question2Entity;
import com.teckja.test12.entities.Question3Entity;
import com.teckja.test12.entities.Question4Entity;
import com.teckja.test12.entities.Question5Entity;
import com.teckja.test12.entities.Question6Entity;
import com.teckja.test12.entities.Question7Entity;
import com.teckja.test12.entities.Question8Entity;
import com.teckja.test12.entities.Question9Entity;
import com.teckja.test12.entities.QuestionEntity;

@Database(version = 1, entities = {HighScoreEntity.class, QuestionEntity.class, Question1Entity.class, Question2Entity.class, Question3Entity.class, Question4Entity.class, Question5Entity.class,
        Question6Entity.class, Question7Entity.class, Question8Entity.class, Question9Entity.class, Question10Entity.class
        , Question11Entity.class, Question12Entity.class, Question13Entity.class, Question14Entity.class, Question15Entity.class})
public abstract class QuestionDB extends RoomDatabase {
    public abstract QuestionDAO questionDAO();
}
