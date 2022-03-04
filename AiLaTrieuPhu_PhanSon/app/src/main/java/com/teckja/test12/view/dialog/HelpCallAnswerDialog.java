package com.teckja.test12.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.teckja.test12.R;

public class HelpCallAnswerDialog extends Dialog {
    private ImageView ivWhoHelp;
    private TextView tvWhoHelp,tvAnswerHelp;
    private CallBackDialogHelpCall mCallBack;

    public HelpCallAnswerDialog(@NonNull Context context, CallBackDialogHelpCall callBack) {
        super(context);
        setContentView(R.layout.view_help_call_answer_dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        mCallBack = callBack;
        initViews();
    }

    private void initViews() {
        ivWhoHelp = findViewById(R.id.iv_help_call_answer);
        tvWhoHelp = findViewById(R.id.tv_help_call_who);
        tvAnswerHelp = findViewById(R.id.tv_answer_help_call);
        findViewById(R.id.tv_answer_help_call_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.tv_answer_help_call_close) {
                    dismiss();
                    mCallBack.onCallBackHelpCall();
                }
            }
        });
    }
    public void upDateUI(int idIvWho,String job,int answer){
        ivWhoHelp.setImageResource(idIvWho);
        tvWhoHelp.setText(job);
        Log.i("TAG", "upDateUI: "+answer);
        tvAnswerHelp.setText(answer);
    }

    public interface CallBackDialogHelpCall{
        void onCallBackHelpCall();
    }
}
