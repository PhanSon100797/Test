package com.teckja.test12.view.activity;

public interface OnBackPress {
    void setBackTag(String key, String preTag);
    void showFrg(String tag);
    void showFrg(int layoutId, String tag, Object data, boolean isBacked);
}
