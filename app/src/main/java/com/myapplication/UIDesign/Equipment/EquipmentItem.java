package com.myapplication.UIDesign.Equipment;


/**
*此类存储单个设备的简略信息
 * 用于设备主界面的展示
 */
public class EquipmentItem {

    private String name;
    private String onlineStatus;
    private String operatingStatus;
    private String time;

    public EquipmentItem(){}
    public EquipmentItem(String name, String onlineStatusStatus, String operatingStatus, String time){
        this.name=name;
        this.onlineStatus = onlineStatusStatus;
        this.operatingStatus=operatingStatus;
        this.time=time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public String getTime() {
        return time;
    }
}
