package com.teckja.test12.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.teckja.test12.R;


public class Infor extends Dialog {
    public Infor(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_infor_dialog);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
