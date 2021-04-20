package com.myapplication.UIDesign.Notification;

import com.myapplication.UIDesign.MainActivity;

import java.util.TimerTask;

/**
 * 轮询的任务类
 * 该类被定时器唤醒，并执行轮询任务
 */
public class UpdateTask extends java.util.TimerTask {
    MainActivity mainActivity;

    public UpdateTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void run(){
        mainActivity.sendUpdateRequest();
        };
}
