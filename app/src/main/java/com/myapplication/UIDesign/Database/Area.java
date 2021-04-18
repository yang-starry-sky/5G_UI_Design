package com.myapplication.UIDesign.Database;


import org.litepal.crud.DataSupport;

//利用LitePal创建关系数据库，把数据写入数据库，然后写接口，方便数据被调用
public class Area extends DataSupport {
    private String firstchar;              //地区首字
    private String areaTitle;            //地区大字标题
    private String modificationTime;     //最近修改时间
    private String creator;              //创建者
    private String description;          //描述


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





    public String getFirstchar() {
        return String.valueOf(firstchar);
    }

    public String getAreaTitle() {
        return areaTitle;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public String getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public void setFirstchar(String firstchar) {
        this.firstchar = firstchar;
    }

    public void setAreaTitle(String areaTitle) {
        this.areaTitle = areaTitle;
    }

    public void setModificationTime(String modificationTime) {
        this.modificationTime = modificationTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setDescription(String description) {
        this.description = description;
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
