package com.teckja.test12.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.teckja.test12.R;
import com.teckja.test12.entities.HighScoreEntity;
import com.teckja.test12.manager.OnDataCallBack;
import com.teckja.test12.manager.QuestionManager;

import java.util.List;

public class HighScoreDialog extends Dialog {
    private TextView tvName1, tvName2, tvName3, tvMoneyTop1, tvMoneyTop2, tvMoneyTop3;
    int scoreTop1 = 0;
    int scoreTop2 = 0;
    int scoreTop3 = 0;

    public HighScoreDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.view_high_score_dialog);
        initViews();
    }

    private void initViews() {
        tvName1 = findViewById(R.id.tv_user_top_1);
        tvName2 = findViewById(R.id.tv_user_top_2);
        tvName3 = findViewById(R.id.tv_user_top_3);
        tvMoneyTop1 = findViewById(R.id.tv_money_top_1);
        tvMoneyTop2 = findViewById(R.id.tv_money_top_2);
        tvMoneyTop3 = findViewById(R.id.tv_money_top_3);
        initData();
    }

    private void initData() {

        QuestionManager.getInstance().getTopScore(new OnDataCallBack() {
            @SuppressLint("SetTextI18n")
            @Override
            public void callBack(String key, Object data) {
                List<HighScoreEntity> listScore = (List<HighScoreEntity>) data;
                if (data != null) {
                    int i = 0;
                    Log.i("TAG", "size = " + listScore.size());
                    while (i < listScore.size()) {
                        if (i == 0) {
                            tvName1.setText(listScore.get(0).getName());
                            scoreTop1 = listScore.get(0).getScore();
                        } else if (i == 1) {
                            tvName2.setText(listScore.get(1).getName());
                            scoreTop2 = listScore.get(1).getScore();

                        } else if (i == 2) {
                            tvName3.setText(listScore.get(2).getName());
                            scoreTop3 = listScore.get(2).getScore();
                        }
                        i++;
                    }
                    getScore(scoreTop1, tvMoneyTop1);
                    getScore(scoreTop2, tvMoneyTop2);
                    getScore(scoreTop3, tvMoneyTop3);
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void getScore(int score, TextView tvMoney) {
        switch (score) {
            case 1:
            case 4:
            case 3:
            case 2:
                tvMoney.setText(R.string.hundred_thousand_2_score);
                break;
            case 5:
                tvMoney.setText(R.string.millon_2_score);
                break;
            case 6:
                tvMoney.setText(R.string.millon_3_score);
                break;
            case 7:
                tvMoney.setText(R.string.millon_6_score);
                break;
            case 8:
                tvMoney.setText(R.string.millon_10_score);
                break;
            case 9:
                tvMoney.setText(R.string.millon_14_score);
                break;
            case 10:
                tvMoney.setText(R.string.millon_22_score);
                break;
            case 11:
                tvMoney.setText(R.string.millon_30_score);
                break;
            case 12:
                tvMoney.setText(R.string.millon_40_score);
                break;
            case 13:
                tvMoney.setText(R.string.millon_60_score);
                break;
            case 14:
                tvMoney.setText(R.string.millon_85_score);
                break;
            case 15:
                tvMoney.setText(R.string.millon_150_score);
                break;
            default:
                tvMoney.setText(R.string.zero_vnd);
                break;
        }
    }
}
