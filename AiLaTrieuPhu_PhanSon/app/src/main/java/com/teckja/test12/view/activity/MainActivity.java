package com.teckja.test12.view.activity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;

import androidx.lifecycle.Observer;

import com.teckja.test12.App;
import com.teckja.test12.CommonUtils;
import com.teckja.test12.MediaManager;
import com.teckja.test12.OnActionCallBack;
import com.teckja.test12.R;
import com.teckja.test12.databinding.ActivityMainBinding;
import com.teckja.test12.view.base.BaseActivity;
import com.teckja.test12.view.dialog.SettingDialog;
import com.teckja.test12.view.fragment.M001MainFrg;
import com.teckja.test12.viewmodel.MainViewModel;
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void initView() {
        App.getInstance().getStorage().setCurrentAnswer(0);
        App.getInstance().getStorage().setIsClickStop(false);
        App.getInstance().getStorage().setCurrentQuestion(0);
        App.getInstance().getStorage().setIsUsed5050(false);
        App.getInstance().getStorage().setIsClickAvatar(false);
        App.getInstance().getStorage().setIsUsedSwap(false);
        App.getInstance().getStorage().setIsUsedCall(false);
        App.getInstance().getStorage().setIsClickStop(false);
        App.getInstance().getStorage().setIsUsedAudience(false);
        gotoMainScreen();
    }

    private void gotoMainScreen() {
        new Handler().postDelayed(() -> {
            showFrg(M001MainFrg.TAG);
        },2000);
    }

    @Override
    protected Class<MainViewModel> initViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected ActivityMainBinding initViewBinding(View v) {
        return ActivityMainBinding.bind(v);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void runOnUI(OnActionCallBack callBack) {
        runOnUiThread(() -> callBack.callBack(null, null));
    }

    @Override
    public void setBackTag(String key, String preTag) {

    }

}