package com.teckja.test12.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.teckja.test12.App;
import com.teckja.test12.R;


public class HelpCallDialog extends Dialog implements View.OnClickListener {
    private int mAnswer;
    private CallBackM004Frg mCallBack;
    private Context mContext;

    public void setAnswer() {
        App.getInstance().getStorage().getTrueCase().observe((LifecycleOwner) mContext, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                switch (integer){
                    case 1:
                        mAnswer = R.string.help_call_answer_a;
                        break;
                    case 2:
                        mAnswer = R.string.help_call_answer_b;
                        break;
                    case 3:
                        mAnswer = R.string.help_call_answer_c;
                        break;
                    case 4:
                        mAnswer = R.string.help_call_answer_d;
                        break;
                }
            }
        });
    }

    public HelpCallDialog(@NonNull Context context, CallBackM004Frg callBack) {
        super(context);
        mContext = context;
        setContentView(R.layout.view_help_call_dialog);
        mCallBack = callBack;
        initViews();
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private void initViews() {
        findViewById(R.id.iv_help_call1).setOnClickListener(this);
        findViewById(R.id.iv_help_call2).setOnClickListener(this);
        findViewById(R.id.iv_help_call3).setOnClickListener(this);
        findViewById(R.id.iv_help_call4).setOnClickListener(this);
        setAnswer();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_help_call1) {
            dismiss();
            showDialogAnswer(R.drawable.player_layout_help_call_01, "Bác sĩ",mAnswer);
        } else if (v.getId() == R.id.iv_help_call2) {
            dismiss();
            showDialogAnswer(R.drawable.player_layout_help_call_02, "Giáo sư",mAnswer);
        } else if (v.getId() == R.id.iv_help_call3) {
            dismiss();
            showDialogAnswer(R.drawable.player_layout_help_call_03, "Kỹ sư",mAnswer);
        } else if (v.getId() == R.id.iv_help_call4) {
            dismiss();
            showDialogAnswer(R.drawable.player_layout_help_call_04, "Phóng viên",mAnswer);
        }
    }

    private void showDialogAnswer(int idIvWho, String job,int answer) {
        MediaPlayer mediaPlayer = MediaPlayer.create(mContext,R.raw.call);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(mp -> {
            HelpCallAnswerDialog dialog = new HelpCallAnswerDialog(getContext(), () -> mCallBack.onCallBackM003());
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.upDateUI(idIvWho,job,answer);
            dialog.show();
        });
    }

    public interface CallBackM004Frg {
        void onCallBackM003();
    }
}
