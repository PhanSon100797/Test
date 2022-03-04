package com.teckja.test12.view.fragment;

import android.view.View;
import android.view.animation.AnimationUtils;

import com.teckja.test12.MediaManager;
import com.teckja.test12.R;
import com.teckja.test12.databinding.FrgM002MoneyBinding;
import com.teckja.test12.view.InformReadyDialog;
import com.teckja.test12.view.activity.MainActivity;
import com.teckja.test12.view.base.BaseFragment;
import com.teckja.test12.viewmodel.CommonVM;

public class M002RuleFrg extends BaseFragment<CommonVM, FrgM002MoneyBinding> {
    public static final String TAG = M002RuleFrg.class.getName();

    @Override
    protected void initView() {
        MediaManager.getInstance().playGame(R.raw.song_rule,
                mp -> {
                    MediaManager.getInstance().playGame(R.raw.song_ready, mp1-> {
                        showReadyDialog();
                    });
                });
        mBinding.lnMilestone.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.sileleft));
        mBinding.btHide.setOnClickListener(v -> {
            MediaManager.getInstance().stopPlayGame();
            showReadyDialog();
        });
    }

    private void showReadyDialog() {
        InformReadyDialog inform = new InformReadyDialog(mContext, (data, key) -> {
            if (key.equals(InformReadyDialog.KEY_READ)) {
                doRead();
            } else {
                doBack();
            }
        });
        inform.show();
    }

    private void doRead() {
        MediaManager.getInstance().playGame(R.raw.gofind,
                mp -> {
                    MediaManager.getInstance().playGame(R.raw.ques1, mp1 ->{
                        showPLay();
                    });
                });
    }

    private void showPLay() {
        MediaManager.getInstance().stopBg();
        MainActivity act = (MainActivity) mContext;
        act.showFrg(M003FrgPlay.TAG, true);
    }

    private void doBack() {
        MediaManager.getInstance().stopPlayGame();
        MainActivity act = (MainActivity) mContext;
        act.showFrg(M001MainFrg.TAG);
    }

    @Override
    protected Class<CommonVM> initViewModel() {
        return CommonVM.class;
    }

    @Override
    protected FrgM002MoneyBinding initViewBinding(View v) {
        return FrgM002MoneyBinding.bind(v);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m002_money;
    }

}
