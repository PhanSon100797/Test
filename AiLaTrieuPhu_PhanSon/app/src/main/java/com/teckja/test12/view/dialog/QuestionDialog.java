package com.teckja.test12.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.teckja.test12.App;
import com.teckja.test12.R;

public class QuestionDialog extends Dialog {
    public static final String TAG = QuestionDialog.class.getName();
    private TextView tv2thousand, tv4thousand, tv6thousand, tv1million, tv10million, tv60million, tv22million,
            tv2million, tv3million, tv6million, tv14million, tv30million, tv40million, tv85million, tv150million;
    private Context mContext;

    public QuestionDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        setContentView(R.layout.view_current_question_dialog);
        initViews();
    }

    protected void initViews() {
        tv2thousand = findViewById(R.id.tv_2_hundred_thousand);
        tv4thousand = findViewById(R.id.tv_4_hundred_thousand);
        tv6thousand = findViewById(R.id.tv_6_hundred_thousand);
        tv1million = findViewById(R.id.tv_1_million);
        tv2million = findViewById(R.id.tv_2_million);
        tv3million = findViewById(R.id.tv_3_million);
        tv6million = findViewById(R.id.tv_6_million);
        tv10million = findViewById(R.id.tv_10_million);
        tv14million = findViewById(R.id.tv_14_million);
        tv22million = findViewById(R.id.tv_22_million);
        tv30million = findViewById(R.id.tv_30_million);
        tv40million = findViewById(R.id.tv_40_million);
        tv60million = findViewById(R.id.tv_60_million);
        tv85million = findViewById(R.id.tv_85_million);
        tv150million = findViewById(R.id.tv_150_million);
        findViewById(R.id.tv_hide_dialog).setOnClickListener(v -> dismiss());
        initData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        },2000);
    }

    private void initData() {
        App.getInstance().getStorage().getCurrentQuestion().observe((LifecycleOwner) mContext, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.i(TAG, "onChanged: " + integer);
                switch (integer) {
                    case 0:
                        tv2thousand.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 1:
                        tv2thousand.setBackgroundResource(0);
                        tv4thousand.setBackgroundResource(R.drawable.bg_money_curent);

                        break;
                    case 2:
                        tv4thousand.setBackgroundResource(0);
                        tv6thousand.setBackgroundResource(R.drawable.bg_money_curent);

                        break;
                    case 3:
                        tv6thousand.setBackgroundResource(0);
                        tv1million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 4:
                        tv1million.setBackgroundResource(0);
                        tv2million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 5:
                        tv2million.setBackgroundResource(R.drawable.bg_money_curent);
                        tv3million.setBackgroundResource(0);
                        break;
                    case 6:
                        tv3million.setBackgroundResource(0);
                        tv6million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 7:
                        tv6million.setBackgroundResource(0);
                        tv10million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 8:
                        tv10million.setBackgroundResource(0);
                        tv14million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 9:
                        tv14million.setBackgroundResource(R.drawable.bg_money_curent);
                        tv22million.setBackgroundResource(R.drawable.bg_answer_background_normal);
                        break;
                    case 10:
                        tv22million.setBackgroundResource(R.drawable.bg_money_curent);
                        tv30million.setBackgroundResource(0);
                        break;
                    case 11:
                        tv30million.setBackgroundResource(0);
                        tv40million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 12:
                        tv40million.setBackgroundResource(0);
                        tv60million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 13:
                        tv60million.setBackgroundResource(0);
                        tv85million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    case 14:
                        tv85million.setBackgroundResource(0);
                        tv150million.setBackgroundResource(R.drawable.bg_money_curent);
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
