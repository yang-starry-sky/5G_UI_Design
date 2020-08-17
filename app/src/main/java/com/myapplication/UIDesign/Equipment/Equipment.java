package com.myapplication.UIDesign.Equipment;
/**
 * 类名：Equipment
 * 功能：此类用于存储每个设备的信息
 *
 *
 */
public class Equipment {
    String name;                         //设备名称
    String onlineCondition;              //上线状态
    String runCondition;                 //运行状态
    String onlineTime;                   //上线时间

                                         //若需存储更多信息，可继续添加参数

    //构造方法
    Equipment(String Name, String OnlineCondition, String RunCondition, String OnlineTime) {
        name = Name;
        onlineCondition = OnlineCondition;
        runCondition = RunCondition;
        onlineTime = OnlineTime;
    }

    Equipment() {

    }


    //set方法
    public String setName(String Name) {
        name = Name;
        return Name;
    }

    public String setOnlineCondition(String OnlineCondition) {
        onlineCondition = OnlineCondition;
        return OnlineCondition;
    }

    public String setRunCondition(String RunCondition) {
        runCondition = RunCondition;
        return RunCondition;
    }

    public String setOnlineTime(String OnlineTime) {
        onlineTime = OnlineTime;
        return OnlineTime;
    }


    //get方法
    public String getName() {
        return name;
    }

    public String getOnlineCondition() {
        return onlineCondition;
    }

    public String getRunCondition() {
        return runCondition;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    @Override
    public String toString() {
        return "上线状态  " + onlineCondition + '\n' +
                "运行状态  " + runCondition + '\n' +
                "上线时间" + onlineTime + '\n';
    }
}
