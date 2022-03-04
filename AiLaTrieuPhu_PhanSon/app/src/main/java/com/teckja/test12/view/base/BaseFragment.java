package com.teckja.test12.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.teckja.test12.App;
import com.teckja.test12.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;


import com.teckja.test12.OnActionCallBack;
import com.teckja.test12.Storage;
import com.teckja.test12.manager.OnDataCallBack;
import com.teckja.test12.view.activity.OnBackPress;
import com.teckja.test12.viewmodel.BaseVM;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment<V extends BaseVM, B extends ViewBinding>
        extends Fragment implements View.OnClickListener {
    protected V mModel;
    protected B mBinding;
    protected View mRootView;
    protected OnBackPress mCallBack;
    protected Context mContext;
    protected Object mData;
    public final void setCallBack(OnBackPress callBack) {
        this.mCallBack = callBack;
    }
    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public final <T extends View> T findViewById(int id) {
         return mRootView.findViewById(id);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        mBinding = initViewBinding(mRootView);
        mModel = new ViewModelProvider(this).get(initViewModel());
        initView();
        return mRootView;
    }

    protected abstract void initView();

    protected abstract Class<V> initViewModel();

    protected abstract B initViewBinding(View v);

    protected abstract int getLayoutId();

    @Override
    public final void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext, androidx.appcompat.R.anim.abc_fade_in));
        clickView(v);
    }

    protected void clickView(View v) {

    }  public final <T extends View> T findViewById(int id, View.OnClickListener event) {
        T v = findViewById(id);
        if (v != null && event != null) {
            v.setOnClickListener(event);
        }
        return v;
    }

    public interface OnAlertCallBack {
        void callBack(int key, Object data);
    }
    public void setData(Object data) {
        mData = data;
    }
    public Storage getStorage(){
        return App.getInstance().getStorage();
    }
}