package com.teckja.test12.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.teckja.test12.App;
import com.teckja.test12.MediaManager;
import com.teckja.test12.R;
import com.teckja.test12.entities.HighScoreEntity;
import com.teckja.test12.manager.QuestionManager;
import com.teckja.test12.view.activity.MainActivity;
import com.teckja.test12.view.fragment.M001MainFrg;

import java.util.Random;

public class StopPlayDialog extends Dialog implements View.OnClickListener {
    private EditText edtName;
    private final Context mContext;

    public StopPlayDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        setContentView(R.layout.view_stop_play_dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_cancel).setOnClickListener(this);
        findViewById(R.id.tv_accept).setOnClickListener(this);
        edtName = findViewById(R.id.edt_name_user);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_cancel){
            dismiss();
        }else if (v.getId() == R.id.tv_accept){
            dismiss();
            saveScore();
            MainActivity act = (MainActivity) mContext;
            MediaManager.getInstance().playBG(R.raw.lose_a);
            act.showFrg(M001MainFrg.TAG);
        }
    }

    private void saveScore() {

        String name = edtName.getText().toString();
        int score = App.getInstance().getStorage().getCurrentAnswer();
        HighScoreEntity highScoreEntity = new HighScoreEntity();
        highScoreEntity.setName(name);
        highScoreEntity.setScore(score);
        highScoreEntity.setId(new Random().nextInt(10000)+1000);
        QuestionManager.getInstance().addScore(highScoreEntity, (key, data) -> {
            String mng = (boolean)data?"Added Data Success":"Error";
            Toast.makeText(mContext, mng, Toast.LENGTH_SHORT).show();
        });
    }
}
