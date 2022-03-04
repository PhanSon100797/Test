package com.teckja.test12.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.teckja.test12.R;

public class OutTimeDialog extends Dialog {
    private CallBackOutTime mCallBack;

    public OutTimeDialog(@NonNull Context context, CallBackOutTime callBack) {
        super(context);
        setContentView(R.layout.view_out_time_dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        mCallBack = callBack;
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_close).setOnClickListener(v -> {
            dismiss();
            mCallBack.callBackOutTime();
        });
    }

    public interface CallBackOutTime{
        void callBackOutTime();
    }
}
