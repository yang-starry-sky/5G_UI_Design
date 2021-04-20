package com.myapplication.UIDesign.Notification;

import com.myapplication.UIDesign.MainActivity;

import java.util.Timer;

/**
 * 该类用于发起轮询
 * 与绑定UpdateTask绑定
 *
 */

public class CircularRequest {
    Timer timer;
    UpdateTask task;

    public CircularRequest(MainActivity mainActivity){
        timer = new Timer();
        task = new UpdateTask(mainActivity);
    }

    public void run(){
        timer.schedule(task,5000000,5000);//10秒后开始，每60秒一次
    }

    public void onDestroy(){
        if(timer!=null){
            timer.cancel();
        }
        if(task!=null){
            task.cancel();
        }


    }

}
