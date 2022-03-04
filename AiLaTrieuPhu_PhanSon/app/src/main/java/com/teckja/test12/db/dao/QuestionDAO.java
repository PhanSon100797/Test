package com.teckja.test12.db.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.teckja.test12.entities.HighScoreEntity;
import com.teckja.test12.entities.QuestionEntity;

import java.util.List;
@Dao
public interface QuestionDAO {
    @Query("SELECT * FROM(SELECT * FROM Question\n" +
            "ORDER BY random())\n" +
            "GROUP BY level\n" +
            "ORDER BY _id ASC ")
    List<QuestionEntity> getListQuestion();

    @Query("SELECT * FROM HighScore ORDER BY Score DESC LIMIT 3")
    List<HighScoreEntity> getTopScore();


    @Insert
    void addScore(HighScoreEntity... highScore);

    @Query("DELETE FROM HighScore")
    void delete();
}