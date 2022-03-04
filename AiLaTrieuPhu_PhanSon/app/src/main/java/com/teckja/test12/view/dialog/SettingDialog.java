package com.teckja.test12.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.teckja.test12.App;
import com.teckja.test12.CommonUtils;
import com.teckja.test12.MediaManager;
import com.teckja.test12.R;


public class SettingDialog extends Dialog implements View.OnClickListener {
    public static final String KEY_MUSIC_ON = "KEY_MUSIC_ON";
    private ImageView ivMusicSet;

    public SettingDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.view_setting_dialog);
        initView();
    }

    private void initView() {
        ivMusicSet = findViewById(R.id.iv_music_set);
        ivMusicSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_music_set) {
            if (ivMusicSet.getDrawable().getLevel() == 1) {
                ivMusicSet.setImageLevel(0);
                MediaManager.getInstance().playSong();
            } else {
                ivMusicSet.setImageLevel(1);
                MediaManager.getInstance().pauseSong();
            }
        }
    }
}
