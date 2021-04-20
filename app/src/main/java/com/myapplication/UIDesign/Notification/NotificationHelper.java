package com.myapplication.UIDesign.Notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.myapplication.UIDesign.R;


/**
 * 用于发送一个带有标题与文本的简单通知
 *
 * 用例：
 *         NotificationHelper helper;    //创建
 *         helper = new NotificationHelper(MainActivity.this);  //实例化
 *         helper.setTitle("hello");     //设置通知标题
 *         helper.setContent("try");     //设置通知文本内容
 *         helper.sendNotification();    //发送通知
 *
 *
 */

public class NotificationHelper {
    String title;
    String content;
    NotificationManager manager;
    NotificationChannel notificationChannel;
    Notification notification;
    Context context;

    public NotificationHelper(Context context) {
        this.context = context;
        manager = (NotificationManager) context.getSystemService("notification");
                                //高版本需要渠道

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //只在Android O之上需要渠道，这里的第一个参数要和下面的channelId一样
            notificationChannel = new NotificationChannel("1", "name", NotificationManager.IMPORTANCE_HIGH);
            //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，通知才能正常弹出
            manager.createNotificationChannel(notificationChannel);
        }
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void sendNotification(){
        //这里的第二个参数要和上面的第一个参数一样
        notification = new NotificationCompat.Builder(context, "1")
                .setContentTitle(title)//设置标题
                .setContentText(content)//设置内容
                .setAutoCancel(true)//自动消失
                .setWhen(System.currentTimeMillis())//马上发送
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .build();
        manager.notify(1, notification);
    }

}
