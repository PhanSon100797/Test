package com.teckja.test12;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public final class Storage {
    private boolean isFistTime = false;
    private MutableLiveData<String> stateMusic = new
            MutableLiveData<>();
    private MutableLiveData<Integer> currentQuestion = new MutableLiveData<>(0);
    private MutableLiveData<Integer> trueCase = new MutableLiveData<>();
    private MutableLiveData<Boolean> isUsed5050 = new MutableLiveData<>(false);


    private MutableLiveData<Boolean> isStop = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isUsedSwap = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isUsedCall = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isUsedAudience = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isClickAvatar = new MutableLiveData<>(false);
    private MutableLiveData<Integer> currentAnswerUsed5050 = new MutableLiveData<>(0);
    private MutableLiveData<Integer> currentAnswerUsedAudience = new MutableLiveData<>(-1);

    public MutableLiveData<Integer> getCurrentAnswerUsed5050() {
        return currentAnswerUsed5050;
    }

    public void setCurrentAnswerUsed5050(int currentAnswerUsed5050) {
        this.currentAnswerUsed5050.setValue(currentAnswerUsed5050);
    }

    public MutableLiveData<Integer> getCurrentAnswerUsedAudience() {
        return currentAnswerUsedAudience;
    }

    public void setCurrentAnswerUsedAudience(int currentAnswerUsedAudience) {
        this.currentAnswerUsedAudience.setValue(currentAnswerUsedAudience);
    }

    public MutableLiveData<Boolean> getIsClickAvatar() {
        return isClickAvatar;
    }

    public void setIsClickAvatar(boolean isClickAvatar) {
        this.isClickAvatar.setValue(isClickAvatar);
    }

    public MutableLiveData<Boolean> getIsClickStop() {
        return isClickStop;
    }

    public void setIsClickStop(boolean isClickStop) {
        this.isClickStop.setValue(isClickStop);
    }

    private MutableLiveData<Boolean> isClickStop = new MutableLiveData<>(false);
    public void setIsStop(MutableLiveData<Boolean> isStop) {
        this.isStop = isStop;
    }

    private MediatorLiveData<String> answer = new MediatorLiveData<>();
    private MutableLiveData<String> answerOne = new MutableLiveData<>("");
    private MutableLiveData<String> answerTwo = new MutableLiveData<>("");

    public MutableLiveData<String> getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne.setValue(answerOne);
    }

    public MutableLiveData<String> getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo.setValue(answerTwo);
    }

    public void setAnswer(String answer) {
        this.answer.setValue(answer);
    }

    private int currentAnswer = 0;

    private void addSource() {
        Observer<String> ob = new Observer<String>() {
            @Override
            public void onChanged(String rs) {
                answer.setValue(answerOne.getValue() + "," + answerTwo.getValue());
            }
        };
        answer.addSource(answerOne, ob);
        answer.addSource(answerTwo, ob);
    }

    public LiveData<String> getAnswer() {
        if (!isFistTime) {
            addSource();
            isFistTime = true;
        }
        return answer;
    }

    public MutableLiveData<Boolean> getIsUsedAudience() {
        return isUsedAudience;
    }

    public void setIsUsedAudience(boolean isUsed) {
        this.isUsedAudience.setValue(isUsed);
    }

    public MutableLiveData<Boolean> getIsUsedCall() {
        return isUsedCall;
    }

    public MutableLiveData<Boolean> getIsUsedSwap() {
        return isUsedSwap;
    }

    public MutableLiveData<Boolean> getIsStop() {
        return isStop;
    }

    public void setIsUsedSwap(boolean isUsedSwap) {
        this.isUsedSwap.setValue(isUsedSwap);
    }

    public MutableLiveData<Boolean> getIsUsed5050() {
        return isUsed5050;
    }

    public void setIsUsed5050(boolean isUsed5050) {
        this.isUsed5050.setValue(isUsed5050);
    }

    public MutableLiveData<Integer> getTrueCase() {
        return trueCase;
    }

    public void setTrueCase(int trueCase) {
        this.trueCase.setValue(trueCase);
    }


    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public MutableLiveData<Integer> getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion.setValue(currentQuestion);
    }

    public MutableLiveData<String> getStateMusic() {
        return stateMusic;
    }

    public void setStateMusic(String stateMusic) {
        this.stateMusic.setValue(stateMusic);
    }

    public void setIsUsedCall(boolean isUsed) {
        isUsedCall.setValue(isUsed);
    }

}
