package com.teckja.test12;

import android.os.AsyncTask;

public final class MTask extends AsyncTask<Object, Object, Object> {
    private String key;
    private OnMTaskCallBack callBack;

    public MTask(String key, OnMTaskCallBack callBack) {
        this.key = key;
        this.callBack = callBack;
    }

    public final void requestUpdate(Object data) {
        publishProgress(data);
    }

    @Override
    protected final Object doInBackground(Object... objects) {
        return callBack.execTask(key, this, objects[0]);
    }

    @Override
    protected final void onProgressUpdate(Object... values) {
        callBack.updateUI(key, values[0]);
    }

    @Override
    protected final void onPostExecute(Object o) {
        callBack.completeTask(key, o);
    }

    public final void stop() {
        cancel(true);
    }

    public final void start(Object data) {
        execute(data);
    }

    public final void startAsync(Object data) {
        executeOnExecutor(THREAD_POOL_EXECUTOR, data);
    }

    public interface OnMTaskCallBack {
        Object execTask(String key, MTask task, Object data);

        void completeTask(String key, Object value);

        default void updateUI(String key, Object data) {
        }
    }
}
