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
                                        //在此处进行请求，并根据请求更新红点、发送通知
        NotificationHelper helper;    //创建
        helper = new NotificationHelper(mainActivity);  //实例化
        helper.setTitle("hello");     //设置通知标题
        helper.setContent("try");     //设置通知文本内容
        helper.sendNotification();    //发送通知
        //mainActivity.setOverviewPoint();
        };
}
