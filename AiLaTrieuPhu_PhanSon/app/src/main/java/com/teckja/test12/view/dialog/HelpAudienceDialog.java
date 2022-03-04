package com.teckja.test12.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.skydoves.progressview.ProgressView;
import com.teckja.test12.App;
import com.teckja.test12.MTask;
import com.teckja.test12.R;

import java.util.Random;

public class HelpAudienceDialog extends Dialog implements  MTask.OnMTaskCallBack {
    private static final String KEY_1 = "KEY_1";
    private static final String TAG = HelpAudienceDialog.class.getName();
    private static final String A_B = "A,B";
    private static final String A_C = "A,C";
    private static final String A_D = "A,D";
    private static final String B_C = "B,C";
    private static final String B_D = "B,D";
    private static final String C_D = "C,D";
    private ProgressView progressView_A, progressView_B, progressView_C, progressView_D;
    private TextView tv_progress_A, tv_progress_B, tv_progress_C, tv_progress_D,tv_close;
    private Context mContext;
    private int percentColumn1, percentColumn2, percentColumn3, percentColumn4;
    private HelpAudienceCallBack callBack;

    public void setCallBack(HelpAudienceCallBack callBack) {
        this.callBack = callBack;
    }

    public HelpAudienceDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.view_help_audience_dialog);
        mContext = context;
        initPercentColumn();
        initViews(context);
        openAudience(percentColumn1,percentColumn2,percentColumn3,percentColumn4);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @SuppressLint("SetTextI18n")
    private void openAudience(int percentColumn1, int percentColumn2, int percentColumn3, int percentColumn4) {
        tv_progress_A.setText(percentColumn1 + "%");
        tv_progress_B.setText(percentColumn2 + "%");
        tv_progress_C.setText(percentColumn3 + "%");
        tv_progress_D.setText(percentColumn4 + "%");

        progressView_A.setProgress(percentColumn1);
        progressView_B.setProgress(percentColumn2);
        progressView_C.setProgress(percentColumn3);
        progressView_D.setProgress(percentColumn4);
    }

    private void initPercentColumn() {
        boolean isUsed5050 = App.getInstance().getStorage().getIsUsed5050().getValue();
        boolean isUsedAudience = App.getInstance().getStorage().getIsUsedAudience().getValue();
        int currentAnswer5050 = App.getInstance().getStorage().getCurrentAnswerUsed5050().getValue();
        int currentAnswerAudience = App.getInstance().getStorage().getCurrentAnswerUsedAudience().getValue();
        if (isUsed5050 && isUsedAudience && (currentAnswer5050 == currentAnswerAudience)) {
            usedHelp5050();
        } else if (App.getInstance().getStorage().getIsUsedAudience().getValue()) {
            noUseHelp5050();
        }
    }

    private void usedHelp5050() {
        int trueCase = App.getInstance().getStorage().getTrueCase().getValue();
        App.getInstance().getStorage().getAnswer().observe((LifecycleOwner) mContext, new Observer<String>() {
            @Override
            public void onChanged(String rs) {
                switch (rs) {
                    case A_B:
                        percentColumn1 = 0;
                        percentColumn2 = 0;
                        if (trueCase == 3) {
                            Random rd = new Random();
                            percentColumn3 = rd.nextInt(48) + 50;
                            percentColumn4 = 100 - percentColumn3;
                        } else if (trueCase == 4) {
                            Random rd = new Random();
                            percentColumn4 = rd.nextInt(48) + 50;
                            percentColumn3 = 100 - percentColumn4;
                        }
                        break;
                    case A_C:
                        percentColumn1 = 0;
                        percentColumn3 = 0;
                        if (trueCase == 2) {
                            Random rd = new Random();
                            percentColumn2 = rd.nextInt(48) + 50;
                            percentColumn4 = 100 - percentColumn2;
                        } else if (trueCase == 4) {
                            Random rd = new Random();
                            percentColumn4 = rd.nextInt(48) + 50;
                            percentColumn2 = 100 - percentColumn4;
                        }
                        break;
                    case A_D:
                        percentColumn1 = 0;
                        percentColumn4 = 0;
                        if (trueCase == 2) {
                            Random rd = new Random();
                            percentColumn2 = rd.nextInt(48) + 50;
                            percentColumn3 = 100 - percentColumn2;
                        } else if (trueCase == 3) {
                            Random rd = new Random();
                            percentColumn3 = rd.nextInt(48) + 50;
                            percentColumn2 = 100 - percentColumn3;
                        }
                        break;
                    case B_C:
                        percentColumn3 = 0;
                        percentColumn2 = 0;
                        if (trueCase == 1) {
                            Random rd = new Random();
                            percentColumn1 = rd.nextInt(48) + 50;
                            percentColumn4 = 100 - percentColumn1;
                        } else if (trueCase == 4) {
                            Random rd = new Random();
                            percentColumn4 = rd.nextInt(48) + 50;
                            percentColumn1 = 100 - percentColumn4;
                        }
                        break;
                    case B_D:
                        percentColumn4 = 0;
                        percentColumn2 = 0;
                        if (trueCase == 1) {
                            Random rd = new Random();
                            percentColumn1 = rd.nextInt(48) + 50;
                            percentColumn3 = 100 - percentColumn1;
                        } else if (trueCase == 3) {
                            Random rd = new Random();
                            percentColumn3 = rd.nextInt(48) + 50;
                            percentColumn1 = 100 - percentColumn3;
                        }
                        break;
                    case C_D:
                        percentColumn3 = 0;
                        percentColumn4 = 0;
                        if (trueCase == 2) {
                            Random rd = new Random();
                            percentColumn2 = rd.nextInt(48) + 50;
                            percentColumn1 = 100 - percentColumn2;
                        } else if (trueCase == 1) {
                            Random rd = new Random();
                            percentColumn1 = rd.nextInt(48) + 50;
                            percentColumn2 = 100 - percentColumn1;
                        }
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void noUseHelp5050() {
        App.getInstance().getStorage().getTrueCase().observe((LifecycleOwner) mContext, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Random rd = new Random();
                if (integer == 1) {
                    percentColumn1 = rd.nextInt(48) + 50;
                    percentColumn2 = rd.nextInt(100 - percentColumn1);
                    percentColumn3 = rd.nextInt(100 - percentColumn2 - percentColumn1);
                    percentColumn4 = 100 - percentColumn1 - percentColumn2 - percentColumn3;
                } else if (integer == 2) {
                    percentColumn2 = rd.nextInt(48) + 50;
                    percentColumn1 = rd.nextInt(100 - percentColumn2);
                    percentColumn3 = rd.nextInt(100 - percentColumn2 - percentColumn1);
                    percentColumn4 = 100 - percentColumn1 - percentColumn2 - percentColumn3;
                } else if (integer == 3) {
                    percentColumn3 = rd.nextInt(48) + 50;
                    percentColumn1 = rd.nextInt(100 - percentColumn3);
                    percentColumn2 = rd.nextInt(100 - percentColumn3 - percentColumn1);
                    percentColumn4 = 100 - percentColumn1 - percentColumn2 - percentColumn3;
                } else if (integer == 4) {
                    percentColumn4 = rd.nextInt(48) + 50;
                    percentColumn1 = rd.nextInt(100 - percentColumn4);
                    percentColumn3 = rd.nextInt(100 - percentColumn4 - percentColumn1);
                    percentColumn2 = 100 - percentColumn1 - percentColumn4 - percentColumn3;
                }
            }
        });

    }

    private void initViews(Context context) {
        tv_progress_A = findViewById(R.id.tv_progress_1);
        tv_progress_B = findViewById(R.id.tv_progress_2);
        tv_progress_C = findViewById(R.id.tv_progress_3);
        tv_progress_D = findViewById(R.id.tv_progress_4);

        progressView_A = findViewById(R.id.progress_1);
        progressView_B = findViewById(R.id.progress_2);
        progressView_C = findViewById(R.id.progress_3);
        progressView_D = findViewById(R.id.progress_4);

        tv_close = findViewById(R.id.tv_close_help);
        initView();
    }


    @Override
    public Object execTask(String key, MTask task, Object data) {
        for (int i = 0; i <= 100; i++) {
            task.requestUpdate(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void completeTask(String key, Object value) {
    }

    @Override
    public void updateUI(String key, Object data) {
    }
    private void initView() {
        findViewById(R.id.tv_close_help).setOnClickListener(v -> {
            dismiss();
            callBack.onCallBackAudience();
        });
    }

    public interface HelpAudienceCallBack {
        void onCallBackAudience();
    }
}

