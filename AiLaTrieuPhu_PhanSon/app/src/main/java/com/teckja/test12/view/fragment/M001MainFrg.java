package com.teckja.test12.view.fragment;

import android.media.MediaPlayer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.teckja.test12.App;
import com.teckja.test12.CommonUtils;
import com.teckja.test12.MediaManager;
import com.teckja.test12.R;
import com.teckja.test12.databinding.FrgM001MenuBinding;
import com.teckja.test12.manager.OnDataCallBack;
import com.teckja.test12.manager.QuestionManager;
import com.teckja.test12.view.activity.MainActivity;
import com.teckja.test12.view.base.BaseFragment;
import com.teckja.test12.view.dialog.HighScoreDialog;
import com.teckja.test12.view.dialog.Infor;
import com.teckja.test12.view.dialog.SettingDialog;
import com.teckja.test12.viewmodel.M001MainViewModel;


public class M001MainFrg extends BaseFragment<M001MainViewModel, FrgM001MenuBinding> {
    public static final String TAG = M001MainFrg.class.getName();
    private MediaPlayer mediaPlayer;

    @Override
    protected void initView() {

        MediaManager.getInstance().playBG(R.raw.song_info);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.bg_circle_rotate);
        mBinding.ivRoteMenu.setAnimation(animation);
        mBinding.ivPlay.setOnClickListener(this);
        mBinding.ivCup.setOnClickListener(this);
        mBinding.ivSetting.setOnClickListener(this);
        mBinding.ivInfor.setOnClickListener(this);

    }
    @Override
    protected Class<M001MainViewModel> initViewModel() {
        return M001MainViewModel.class;
    }

    @Override
    protected FrgM001MenuBinding initViewBinding(View v) {
        return FrgM001MenuBinding.bind(v);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m001_menu;
    }
    @Override
    protected void clickView(View v) {
        if (v.getId() == R.id.iv_play) {
            MediaManager.getInstance().stopBg();
            MainActivity act = (MainActivity) mContext;
            act.showFrg(M002RuleFrg.TAG, true);
        } else if (v.getId() == R.id.iv_cup) {
            HighScoreDialog highScoreDialog = new HighScoreDialog(mContext);
            highScoreDialog.show();
            Window window = highScoreDialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        } else if (v.getId() == R.id.iv_infor) {
            Infor aboutDialog = new Infor(getContext());
            aboutDialog.show();
        } else {
            SettingDialog dialog = new SettingDialog(mContext);
            dialog.show();
            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        }
    }

}
