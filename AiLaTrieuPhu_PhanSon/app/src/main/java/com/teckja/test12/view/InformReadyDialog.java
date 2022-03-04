package com.teckja.test12.view;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;


import com.teckja.test12.OnActionCallBack;
import com.teckja.test12.R;

public class InformReadyDialog extends Dialog {
    public static final String KEY_BACK = "KEY_BACK";
    public static final String KEY_READ = "KEY_READ";
    public final OnActionCallBack callBack;

    public InformReadyDialog(@NonNull Context context, OnActionCallBack callBack) {
        super(context);
        setContentView(R.layout.view_ready);
        initView();
        this.callBack = callBack;
    }

    private void initView() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        findViewById(R.id.bt_ready).setOnClickListener(v -> doReady());
        findViewById(R.id.bt_back).setOnClickListener(v -> doBack());
    }

    public void doBack() {
        callBack.callBack(null, KEY_BACK);
        dismiss();
    }

    public void doReady() {
        callBack.callBack(null, KEY_READ);
        dismiss();
    }
}
