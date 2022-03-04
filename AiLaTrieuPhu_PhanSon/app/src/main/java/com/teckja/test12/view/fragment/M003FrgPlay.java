package com.teckja.test12.view.fragment;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teckja.test12.App;
import com.teckja.test12.MTask;
import com.teckja.test12.R;
import com.teckja.test12.databinding.FrgM003PlayerBinding;
import com.teckja.test12.entities.QuestionEntity;
import com.teckja.test12.manager.OnDataCallBack;
import com.teckja.test12.manager.QuestionManager;
import com.teckja.test12.view.activity.MainActivity;
import com.teckja.test12.view.base.BaseFragment;
import com.teckja.test12.view.dialog.HelpAudienceDialog;
import com.teckja.test12.view.dialog.HelpCallDialog;
import com.teckja.test12.view.dialog.OutTimeDialog;
import com.teckja.test12.view.dialog.QuestionDialog;
import com.teckja.test12.view.dialog.StopPlayDialog;
import com.teckja.test12.viewmodel.CommonVM;

import java.util.List;
import java.util.Random;

public class M003FrgPlay extends BaseFragment<CommonVM, FrgM003PlayerBinding> implements MTask.OnMTaskCallBack {
    public static final String TAG = M003FrgPlay.class.getName();
    private TextView tvQuestion, tvAnswerA, tvAnswerB, tvAnswerC, tvAnswerD, tvQuestionNumber, tvMoney, tvTime;
    private int trueCase;
    private MediaPlayer mediaPlayer;
    private MTask task1, stopTack, audienceTask, help5050Task, callTask, taskAvatar, taskChangeQu;
    private ImageView ivStop, ivSwapQuestion, ivHelp5050, ivHelpCall, ivHelpAudience;


    @Override
    protected void initView() {

        tvQuestion = findViewById(R.id.tv_question);
        tvQuestionNumber = findViewById(R.id.tv_questionNumber);
        tvAnswerA = findViewById(R.id.tv_answerA, this);
        tvAnswerB = findViewById(R.id.tv_answerB, this);
        tvAnswerC = findViewById(R.id.tv_answerC, this);
        tvAnswerD = findViewById(R.id.tv_answerD, this);
        tvMoney = findViewById(R.id.tv_money_play);
        tvTime = findViewById(R.id.tv_time);
        ivHelpAudience = findViewById(R.id.iv_help_audience, this);
        findViewById(R.id.iv_user, this);
        ivStop = findViewById(R.id.iv_stop, this);
        ivSwapQuestion = findViewById(R.id.iv_change_question, this);
        ivHelp5050 = findViewById(R.id.iv_help_5050, this);
        ivHelpCall = findViewById(R.id.iv_help_call, this);
        initData(App.getInstance().getStorage().getCurrentAnswer());
        updateMoney();
        updateTime();
        updateHelp();
    }

    @SuppressLint("SetTextI18n")
    private void initData(int i) {
        QuestionManager.getInstance().getListQuestion((key, data) -> {
            if (data != null) {
                List<QuestionEntity> listQuestion = (List<QuestionEntity>) data;
                tvQuestionNumber.setText("Câu " + (i + 1));
                tvQuestion.setText(listQuestion.get(i).getQuestion());
                tvAnswerA.setText("A: " + listQuestion.get(i).getCaseA());
                tvAnswerB.setText("B: " + listQuestion.get(i).getCaseB());
                tvAnswerC.setText("C: " + listQuestion.get(i).getCaseC());
                tvAnswerD.setText("D: " + listQuestion.get(i).getCaseD());
                tvTime.setText(30 + "");
                trueCase = listQuestion.get(i).getTrueCase();
                App.getInstance().getStorage().setTrueCase(trueCase);

                tvAnswerA.setBackgroundResource(R.drawable.bg_answer_background_normal);
                tvAnswerB.setBackgroundResource(R.drawable.bg_answer_background_normal);
                tvAnswerC.setBackgroundResource(R.drawable.bg_answer_background_normal);
                tvAnswerD.setBackgroundResource(R.drawable.bg_answer_background_normal);
                tvAnswerA.setEnabled(true);
                tvAnswerB.setEnabled(true);
                tvAnswerC.setEnabled(true);
                tvAnswerD.setEnabled(true);
            }
        });
    }

    private void updateTime() {
        task1 = new MTask("task1", this);
        task1.startAsync(30);
    }

    private void updateTimeHelpAudience() {
        audienceTask = new MTask("task2", this);
        audienceTask.startAsync(Integer.parseInt(tvTime.getText().toString()));
    }

    private void updateTimeHelp5050() {
        help5050Task = new MTask("task3", this);
        help5050Task.startAsync(Integer.parseInt(tvTime.getText().toString()));
    }

    private void updateTimeHelpCall() {
        callTask = new MTask("task4", this);
        callTask.startAsync(Integer.parseInt(tvTime.getText().toString()));
    }

    private void updateTimeAvatar() {
        taskAvatar = new MTask("task5", this);
        taskAvatar.startAsync(Integer.parseInt(tvTime.getText().toString()));
    }

    private void updateTimeStopGame() {
        stopTack = new MTask("task7", this);
        stopTack.startAsync(Integer.parseInt(tvTime.getText().toString()));
    }

    private void updateTimeChangeQu() {
        taskChangeQu = new MTask("task5", this);
        taskChangeQu.startAsync(30);
    }

    private void updateMoney() {
        App.getInstance().getStorage().getCurrentQuestion().observe(this, integer -> {
            switch (integer) {
                case 0:
                    tvMoney.setText(R.string.zero);
                    break;
                case 1:
                    tvMoney.setText(R.string.hundred_thousand_2);
                    break;
                case 2:
                    tvMoney.setText(R.string.hundred_thousand_4);
                    break;
                case 3:
                    tvMoney.setText(R.string.hundred_thousand_6);
                    break;
                case 4:
                    tvMoney.setText(R.string.million_1);
                    break;
                case 5:
                    tvMoney.setText(R.string.million_2);
                    break;
                case 6:
                    tvMoney.setText(R.string.million_3);
                    break;
                case 7:
                    tvMoney.setText(R.string.million_6);
                    break;
                case 8:
                    tvMoney.setText(R.string.million_10);
                    break;
                case 9:
                    tvMoney.setText(R.string.million_14);
                    break;
                case 10:
                    tvMoney.setText(R.string.million_22);
                    break;
                case 11:
                    tvMoney.setText(R.string.million_30);
                    break;
                case 12:
                    tvMoney.setText(R.string.million_40);
                    break;
                case 13:
                    tvMoney.setText(R.string.million_60);
                    break;
                case 14:
                    tvMoney.setText(R.string.million_85);
                    break;
                case 15:
                    tvMoney.setText(R.string.million_150);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    protected void clickView(View view) {
        task1.stop();
        if (view.getId() == R.id.tv_answerA) {
            checkAnswer(R.raw.ans_a, tvAnswerA, 1);
            controlTask();
        } else if (view.getId() == R.id.tv_answerB) {
            checkAnswer(R.raw.ans_b, tvAnswerB, 2);
            controlTask();
        } else if (view.getId() == R.id.tv_answerC) {
            checkAnswer(R.raw.ans_c, tvAnswerC, 3);
            controlTask();
        } else if (view.getId() == R.id.tv_answerD) {
            checkAnswer(R.raw.ans_d, tvAnswerD, 4);
            controlTask();
        } else if (view.getId() == R.id.iv_user) {
            App.getInstance().getStorage().setIsClickAvatar(true);
            showCurrentQuestionDialog();
            new Handler().postDelayed(this::updateTimeAvatar, 2000);
            controlTask();
        } else if (view.getId() == R.id.iv_stop) {
            App.getInstance().getStorage().setIsClickStop(true);
            showStopDialog();
        } else if (view.getId() == R.id.iv_help_audience) {
            App.getInstance().getStorage().setIsUsedAudience(true);
            App.getInstance().getStorage().setCurrentAnswerUsedAudience(App.getInstance().getStorage().getCurrentAnswer());
            if (ivHelpAudience.getDrawable().getLevel() == 0) {
                ivHelpAudience.setImageLevel(1);
            }
            startMedia(R.raw.khan_gia);
            showHelpAudienceDialog();
        } else if (view.getId() == R.id.iv_change_question) {
            controlTask();
            if (ivSwapQuestion.getDrawable().getLevel() == 0)
                initData(App.getInstance().getStorage().getCurrentAnswer());
            App.getInstance().getStorage().setIsUsedSwap(true);
            ivSwapQuestion.setImageLevel(1);
            ivSwapQuestion.setEnabled(false);
            updateTimeChangeQu();
        } else if (view.getId() == R.id.iv_help_5050) {
            enableClick(false);
            startMedia(R.raw.sound5050);
            App.getInstance().getStorage().setIsUsed5050(true);
            App.getInstance().getStorage().setCurrentAnswerUsed5050(App.getInstance().getStorage().getCurrentAnswer());
            if (ivHelp5050.getDrawable().getLevel() == 0) {
                ivHelp5050.setImageLevel(1);
            }
            mediaPlayer.setOnCompletionListener(mp -> {
                enableClick(true);
                ivHelp5050.setEnabled(false);
                handleHelp5050();
                updateTimeHelp5050();
            });
        } else if (view.getId() == R.id.iv_help_call) {
            App.getInstance().getStorage().setIsUsedCall(true);
            startMedia(R.raw.help_call);
            if (ivHelpCall.getDrawable().getLevel() == 0) {
                ivHelpCall.setImageLevel(1);
                ivHelpCall.setEnabled(false);
            }
            mediaPlayer.setOnCompletionListener(mp -> {
                startMedia(R.raw.help_callb);
                showHelpCallDialog();
            });
        }
    }

    private void handleHelp5050() {
        if (trueCase == 1) {
            Random rd = new Random();
            int answer = rd.nextInt(3) + 1;
            switch (answer) {
                case 2:
                    tvAnswerC.setVisibility(View.INVISIBLE);
                    tvAnswerC.setEnabled(false);
                    tvAnswerD.setVisibility(View.INVISIBLE);
                    tvAnswerD.setEnabled(false);
                    getStorage().getAnswerOne().setValue("C");
                    getStorage().getAnswerTwo().setValue("D");
                    break;
                case 3:
                    tvAnswerB.setVisibility(View.INVISIBLE);
                    tvAnswerB.setEnabled(false);
                    tvAnswerD.setVisibility(View.INVISIBLE);
                    tvAnswerD.setEnabled(false);
                    getStorage().getAnswerOne().setValue("B");
                    getStorage().getAnswerTwo().setValue("D");
                    break;
                case 4:
                    tvAnswerB.setVisibility(View.INVISIBLE);
                    tvAnswerB.setEnabled(false);
                    tvAnswerC.setVisibility(View.INVISIBLE);
                    tvAnswerC.setEnabled(false);
                    getStorage().getAnswerOne().setValue("B");
                    getStorage().getAnswerTwo().setValue("C");
                    break;
                default:
                    break;
            }
        } else if (trueCase == 2) {
            Random rd = new Random();
            int answer = rd.nextInt(3) + 1;
            switch (answer) {
                case 2:
                    tvAnswerC.setVisibility(View.INVISIBLE);
                    tvAnswerC.setEnabled(false);
                    tvAnswerD.setVisibility(View.INVISIBLE);
                    tvAnswerD.setEnabled(false);
                    getStorage().getAnswerOne().setValue("C");
                    getStorage().getAnswerTwo().setValue("D");
                    break;
                case 3:
                    tvAnswerA.setVisibility(View.INVISIBLE);
                    tvAnswerA.setEnabled(false);
                    tvAnswerD.setVisibility(View.INVISIBLE);
                    tvAnswerD.setEnabled(false);
                    getStorage().getAnswerOne().setValue("A");
                    getStorage().getAnswerTwo().setValue("D");
                    break;
                case 4:
                    tvAnswerA.setVisibility(View.INVISIBLE);
                    tvAnswerA.setEnabled(false);
                    tvAnswerC.setVisibility(View.INVISIBLE);
                    tvAnswerC.setEnabled(false);
                    getStorage().getAnswerOne().setValue("A");
                    getStorage().getAnswerTwo().setValue("C");
                    break;
                default:
                    break;
            }
        } else if (trueCase == 3) {
            Random rd = new Random();
            int answer = rd.nextInt(3) + 1;
            switch (answer) {
                case 2:
                    tvAnswerA.setVisibility(View.INVISIBLE);
                    tvAnswerA.setEnabled(false);
                    tvAnswerD.setVisibility(View.INVISIBLE);
                    tvAnswerD.setEnabled(false);
                    getStorage().getAnswerOne().setValue("A");
                    getStorage().getAnswerTwo().setValue("D");
                    break;
                case 3:
                    tvAnswerB.setVisibility(View.INVISIBLE);
                    tvAnswerB.setEnabled(false);
                    tvAnswerD.setVisibility(View.INVISIBLE);
                    tvAnswerD.setEnabled(false);
                    getStorage().getAnswerOne().setValue("B");
                    getStorage().getAnswerTwo().setValue("D");
                    break;
                case 4:
                    tvAnswerA.setVisibility(View.INVISIBLE);
                    tvAnswerA.setEnabled(false);
                    tvAnswerB.setVisibility(View.INVISIBLE);
                    tvAnswerB.setEnabled(false);
                    getStorage().getAnswerOne().setValue("A");
                    getStorage().getAnswerTwo().setValue("B");
                    break;
                default:
                    break;
            }
        } else if (trueCase == 4) {
            Random rd = new Random();
            int answer = rd.nextInt(3) + 1;
            switch (answer) {
                case 2:
                    tvAnswerC.setVisibility(View.INVISIBLE);
                    tvAnswerC.setEnabled(false);
                    tvAnswerA.setVisibility(View.INVISIBLE);
                    tvAnswerA.setEnabled(false);
                    getStorage().getAnswerOne().setValue("A");
                    getStorage().getAnswerTwo().setValue("C");
                    break;
                case 3:
                    tvAnswerB.setVisibility(View.INVISIBLE);
                    tvAnswerB.setEnabled(false);
                    tvAnswerA.setVisibility(View.INVISIBLE);
                    tvAnswerA.setEnabled(false);
                    getStorage().getAnswerOne().setValue("A");
                    getStorage().getAnswerTwo().setValue("B");
                    break;
                case 4:
                    getStorage().getAnswerOne().setValue("B");
                    getStorage().getAnswerTwo().setValue("C");
                    tvAnswerC.setVisibility(View.INVISIBLE);
                    tvAnswerC.setEnabled(false);
                    tvAnswerB.setVisibility(View.INVISIBLE);
                    tvAnswerB.setEnabled(false);
                    break;
                default:
                    break;
            }
        }
    }

    private void showStopDialog() {
        StopPlayDialog dialog = new StopPlayDialog(mContext);
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
        updateTimeStopGame();
    }

    private void showHelpAudienceDialog() {
        HelpAudienceDialog dialog = new HelpAudienceDialog(mContext);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCallBack(this::updateTimeHelpAudience);
        dialog.show();
    }

    private void checkAnswer(int rawSelected, TextView tvSelected, int idTVSelected) {
        startMedia(rawSelected);
        tvSelected.setBackgroundResource(R.drawable.bg_background_selected);
        enableClick(false);
        mediaPlayer.setOnCompletionListener(mp -> {
            switch (trueCase) {
                case 1:
                    if (idTVSelected == 1) {
                        answerTrue(R.raw.true_a, tvAnswerA);
                    } else if (idTVSelected == 2) {
                        answerWrong(R.raw.lose_a2, tvAnswerA, tvAnswerB);
                    } else if (idTVSelected == 3) {
                        answerWrong(R.raw.lose_a, tvAnswerA, tvAnswerC);
                    } else if (idTVSelected == 4) {
                        answerWrong(R.raw.lose_a2, tvAnswerA, tvAnswerD);
                    }
                    break;
                case 2:
                    if (idTVSelected == 2) {
                        answerTrue(R.raw.true_b, tvAnswerB);
                    } else if (idTVSelected == 1) {
                        answerWrong(R.raw.lose_b2, tvAnswerB, tvAnswerA);
                    } else if (idTVSelected == 3) {
                        answerWrong(R.raw.lose_b, tvAnswerB, tvAnswerC);
                    } else if (idTVSelected == 4) {
                        answerWrong(R.raw.lose_b2, tvAnswerB, tvAnswerD);
                    }
                    break;
                case 3:
                    if (idTVSelected == 3) {
                        answerTrue(R.raw.true_c, tvAnswerC);
                    } else if (idTVSelected == 1) {
                        answerWrong(R.raw.lose_c, tvAnswerC, tvAnswerA);
                    } else if (idTVSelected == 2) {
                        answerWrong(R.raw.lose_c2, tvAnswerC, tvAnswerB);
                    } else if (idTVSelected == 4) {
                        answerWrong(R.raw.lose_c, tvAnswerC, tvAnswerD);
                    }
                    break;
                case 4:
                    if (idTVSelected == 4) {
                        answerTrue(R.raw.true_d2, tvAnswerD);
                    } else if (idTVSelected == 1) {
                        answerWrong(R.raw.lose_d2, tvAnswerD, tvAnswerA);
                    } else if (idTVSelected == 3) {
                        answerWrong(R.raw.lose_d2, tvAnswerD, tvAnswerC);
                    } else if (idTVSelected == 2) {
                        answerWrong(R.raw.lose_d, tvAnswerD, tvAnswerB);
                    }
                    break;
                default:
                    break;
            }
        });
    }

    private void controlTask() {
        boolean isAudience = App.getInstance().getStorage().getIsUsedAudience().getValue();
        boolean isHelp5050 = App.getInstance().getStorage().getIsUsed5050().getValue();
        boolean isCall = App.getInstance().getStorage().getIsUsedCall().getValue();
        boolean isClickAvatar = App.getInstance().getStorage().getIsClickAvatar().getValue();
        boolean isUsedChangQu = App.getInstance().getStorage().getIsUsedSwap().getValue();
        boolean isStop = App.getInstance().getStorage().getIsClickStop().getValue();
        if (isAudience && audienceTask != null) {
            audienceTask.stop();
        } else if (isHelp5050 && help5050Task != null) {
            help5050Task.stop();
        } else if (isCall && callTask != null) {
            callTask.stop();
        } else if (isClickAvatar && taskAvatar != null) {
            taskAvatar.stop();
        } else if (isUsedChangQu && taskChangeQu != null) {
            taskChangeQu.stop();
        } else if (isStop && stopTack != null) {
            stopTack.stop();
        }
    }

    private void answerTrue(int raw, TextView tvSelected) {
        App.getInstance().getStorage().setCurrentAnswer(App.getInstance().getStorage().getCurrentAnswer() + 1);
        App.getInstance().getStorage().setCurrentQuestion(App.getInstance().getStorage().getCurrentAnswer());
        startMedia(raw);
        tvSelected.setBackgroundResource(R.drawable.bg_answer_background_true);
        tvSelected.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.blink));
        mediaPlayer.setOnCompletionListener(mp -> {
            showCurrentQuestionDialog();
            new Handler().postDelayed(() -> {
                if (App.getInstance().getStorage().getCurrentAnswer() == 5) {
                    startMedia(R.raw.chuc_mung_vuot_moc_01_0);
                    mediaPlayer.setOnCompletionListener(mp1 -> {
                        startMedia(R.raw.ques6);
                        MainActivity act = (MainActivity) mContext;
                        act.showFrg(M003FrgPlay.TAG);
                    });
                } else if (App.getInstance().getStorage().getCurrentAnswer() == 10) {
                    startMedia(R.raw.chuc_mung_vuot_moc_02_0);
                    mediaPlayer.setOnCompletionListener(mp1 -> {
                        startMedia(R.raw.ques11);
                        MainActivity act = (MainActivity) mContext;
                        act.showFrg(M003FrgPlay.TAG);
                    });
                } else {
                    MainActivity act = (MainActivity) mContext;
                    act.showFrg(M003FrgPlay.TAG);
                }
            }, 1500);
            startMediaQuestion();
        });
    }

    private void startMediaQuestion() {
        switch (App.getInstance().getStorage().getCurrentAnswer()) {
            case 1:
                startMedia(R.raw.ques2);
                break;
            case 2:
                startMedia(R.raw.ques3);
                break;
            case 3:
                startMedia(R.raw.ques4);
                break;
            case 4:
                startMedia(R.raw.ques5);
                mediaPlayer.setOnCompletionListener(mp -> startMedia(R.raw.important));
                break;
            case 6:
                startMedia(R.raw.ques7);
                break;
            case 7:
                startMedia(R.raw.ques8);
                break;
            case 8:
                startMedia(R.raw.ques9);
                break;
            case 9:
                startMedia(R.raw.ques10);
                mediaPlayer.setOnCompletionListener(mp -> startMedia(R.raw.important));
                break;
            case 11:
                startMedia(R.raw.ques12);
                break;
            case 12:
                startMedia(R.raw.ques13);
                break;
            case 13:
                startMedia(R.raw.ques14);
                break;
            case 14:
                startMedia(R.raw.ques15);
                break;
            default:
                break;
        }
    }

    private void answerWrong(int rawLose, TextView tvSelected, TextView tvTrue) {
        startMedia(rawLose);
        tvSelected.setBackgroundResource(R.drawable.bg_answer_background_true);
        tvTrue.setBackgroundResource(R.drawable.bg_answer_background_wrong);
        tvTrue.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.blink));
        mediaPlayer.setOnCompletionListener(mp -> {
            startMedia(R.raw.lose2);
            mediaPlayer.setOnCompletionListener(mp1 -> {
                MainActivity act = (MainActivity) mContext;
                act.showFrg(M001MainFrg.TAG);
            });
        });
    }

    private void enableClick(boolean isEnable) {
        ivHelpCall.setEnabled(isEnable);
        ivSwapQuestion.setEnabled(isEnable);
        ivHelp5050.setEnabled(isEnable);
        ivHelpAudience.setEnabled(isEnable);
        ivHelpAudience.setEnabled(isEnable);
        ivStop.setEnabled(isEnable);
        tvAnswerA.setEnabled(isEnable);
        tvAnswerB.setEnabled(isEnable);
        tvAnswerC.setEnabled(isEnable);
        tvAnswerD.setEnabled(isEnable);
    }

    private void updateHelp() {
        App.getInstance().getStorage().getIsUsed5050().observe(this, isUsed -> {
            if (isUsed) {
                ivHelp5050.setImageLevel(1);
                ivHelp5050.setEnabled(false);
            } else {
                ivHelp5050.setEnabled(true);
            }
        });
        App.getInstance().getStorage().getIsUsedSwap().observe(this, isUsed -> {
            if (isUsed) {
                ivSwapQuestion.setImageLevel(1);
                ivSwapQuestion.setEnabled(false);
            } else {
                ivSwapQuestion.setEnabled(true);
            }
        });
        App.getInstance().getStorage().getIsUsedCall().observe(this, isUsed -> {
            if (isUsed) {
                ivHelpCall.setImageLevel(1);
                ivHelpCall.setEnabled(false);
            } else {
                ivHelpCall.setEnabled(true);
            }
        });
        App.getInstance().getStorage().getIsUsedAudience().observe(this, isUsed -> {
            if (isUsed) {
                ivHelpAudience.setImageLevel(1);
                ivHelpAudience.setEnabled(false);
            } else {
                ivHelpAudience.setEnabled(true);
            }
        });
    }

    private void showHelpCallDialog() {
        HelpCallDialog dialog = new HelpCallDialog(mContext, this::updateTimeHelpCall);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
    }

    private void showCurrentQuestionDialog() {
        QuestionDialog dialog = new QuestionDialog(mContext);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
    }

    @Override
    protected Class<CommonVM> initViewModel() {
        return CommonVM.class;
    }

    @Override
    protected FrgM003PlayerBinding initViewBinding(View v) {
        return FrgM003PlayerBinding.bind(v);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_m003_player;
    }

    @Override
    public Object execTask(String key, MTask task, Object data) {
        try {
            for (int i = (int) data; i >= 0; i--) {
                Thread.sleep(1000);
                task.requestUpdate(i + "");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void outTime() {
        OutTimeDialog dialog = new OutTimeDialog(mContext, () -> {
            startMedia(R.raw.lose);
            mediaPlayer.setOnCompletionListener(mp -> {
                MainActivity act = (MainActivity) mContext;
                act.showFrg(M001MainFrg.TAG);
            });
        });
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
        startMedia(R.raw.out_of_time);
    }

    private void startMedia(int raw) {
        mediaPlayer = MediaPlayer.create(mContext, raw);
        mediaPlayer.start();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void updateUI(String key, Object data) {
        tvTime.setText(data + "");
    }

    @Override
    public void completeTask(String key, Object value) {
        outTime();
    }
}
