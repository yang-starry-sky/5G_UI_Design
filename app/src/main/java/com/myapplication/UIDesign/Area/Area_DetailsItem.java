package com.myapplication.UIDesign.Area;

public class Area_DetailsItem {

    private int deviceOnline;        //接入设备上线状态统计 Online
    private int deviceFailure;       //接入设备上线状态统计 Failure
    private int baseStationOnline;   //基站业务状态统计  Online
    private int baseStationFailure;  //基站业务状态统计  Failure
    private int baseStationPlanning; //基站业务状态统计  Planning
    private int resourceUtilization1;//资源池利用率
    private int resourceUtilization2;
    private int resourceUtilization3;
    private int resourceUtilization4;
    private int resourceUtilization5;

    public Area_DetailsItem(int deviceOnline, int deviceFailure,
                            int baseStationOnline, int baseStationFailure, int baseStationPlanning,
                            int resourceUtilization1, int resourceUtilization2, int resourceUtilization3,
                            int resourceUtilization4, int resourceUtilization5){
        this.deviceOnline=deviceOnline;
        this.deviceFailure=deviceFailure;
        this.baseStationOnline=baseStationOnline;
        this.baseStationFailure=baseStationFailure;
        this.baseStationPlanning=baseStationPlanning;
        this.resourceUtilization1=resourceUtilization1;
        this.resourceUtilization2=resourceUtilization2;
        this.resourceUtilization3=resourceUtilization3;
        this.resourceUtilization4=resourceUtilization4;
        this.resourceUtilization5=resourceUtilization5;
    }

    public int getDeviceOnline(){
        return deviceOnline;
    }

    public int getDeviceFailure() {
        return deviceFailure;
    }

    public int getBaseStationOnline(){
        return baseStationOnline;
    }

    public int getBaseStationFailure(){
        return baseStationFailure;
    }

    public int getBaseStationPlanning(){
        return baseStationPlanning;
    }

    public int getResourceUtilization1(){
        return resourceUtilization1;
    }

    public int getResourceUtilization2() {
        return resourceUtilization2;
    }

    public int getResourceUtilization3() {
        return resourceUtilization3;
    }

    public int getResourceUtilization4() {
        return resourceUtilization4;
    }

    public int getResourceUtilization5() {
        return resourceUtilization5;
    }


    public void setDeviceOnline(int deviceOnline){
        this.deviceOnline = deviceOnline;
    }

    public void setDeviceFailure(int deviceFailure) {
        this.deviceFailure = deviceFailure;
    }

    public void setBaseStationOnline(int baseStationOnline){
        this.baseStationOnline = baseStationOnline;
    }

    public void setBaseStationFailure(int baseStationFailure){
        this.baseStationFailure = baseStationFailure;
    }

    public void setBaseStationPlanning(int baseStationPlanning){
        this.baseStationPlanning = baseStationPlanning;
    }

    public void setResourceUtilization1(int resourceUtilization1){
        this.resourceUtilization1 = resourceUtilization1;
    }

    public void setResourceUtilization2(int resourceUtilization2) {
        this.resourceUtilization2 = resourceUtilization2;
    }

    public void setResourceUtilization3(int resourceUtilization3) {
        this.resourceUtilization3 = resourceUtilization3;
    }

    public void setResourceUtilization4(int resourceUtilization4) {
        this.resourceUtilization4 = resourceUtilization4;
    }

    public void setResourceUtilization5(int resourceUtilization5) {
        this.resourceUtilization5 = resourceUtilization5;
    }

}
