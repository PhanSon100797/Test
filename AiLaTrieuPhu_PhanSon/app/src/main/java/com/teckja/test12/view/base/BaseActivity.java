package com.teckja.test12.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.teckja.test12.R;
import com.teckja.test12.view.activity.OnBackPress;
import com.teckja.test12.viewmodel.BaseVM;


public abstract class BaseActivity<V extends BaseVM, B extends ViewBinding>
        extends AppCompatActivity implements View.OnClickListener, OnBackPress {
    protected V mModel;
    protected B mBinding;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = LayoutInflater.from(this).inflate(getLayoutId(), null);
        mBinding = initViewBinding(v);
        mModel = new ViewModelProvider(this).get(initViewModel());
        setContentView(v);
        initView();
    }

    protected abstract void initView();

    protected abstract Class<V> initViewModel();

    protected abstract B initViewBinding(View v);

    protected abstract int getLayoutId();

    @Override
    public final void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
        clickView(v);
    }

    private void clickView(View v) {
    }

    @Override
    public void showFrg(String tag) {
        showFrg(R.id.ln_main, tag, null, false);
    }

    public void showFrg(String tag, boolean isBacked) {
        showFrg(R.id.ln_main, tag, null, isBacked);
    }

    public void showFrg(String tag, Object data, boolean isBacked) {
        showFrg(R.id.ln_main, tag, data, isBacked);
    }

    @Override
    public void showFrg(int layoutId, String tag, Object data, boolean isBacked) {
        try {
            Class<?> clazz = Class.forName(tag);
            BaseFragment<?, ?> frg = (BaseFragment<?, ?>) clazz.newInstance();
            frg.setData(data);
            FragmentManager frgMgr = getSupportFragmentManager();

            FragmentTransaction frgTrans = frgMgr.beginTransaction();
            frgTrans.replace(layoutId, frg);
            if (isBacked) {
                frgTrans.addToBackStack(null);
            }
            frgTrans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}