package com.myapplication.UIDesign.Overview;

public class graphicinfoitem {
    private int equipmentonline;
    private int equipmentfailure;
    private int stationonline;
    private int stationfailure;
    private int stationplanning;
    private int percent1;
    private int percent2;
    private int percent3;
    private int percent4;
    private int percent5;

    public graphicinfoitem(int equipmentonline,int equipmentfailure,int stationonline,int stationfailure,int stationplanning,int percent1,int percent2,int percent3,int percent4,int percent5){
        this.equipmentfailure = equipmentfailure;
        this.equipmentonline = equipmentonline;
        this.stationonline = stationonline;
        this.stationfailure = stationfailure;
        this.stationplanning = stationplanning;
        this.percent1 = percent1;
        this.percent2 = percent2;
        this.percent3 = percent3;
        this.percent4 = percent4;
        this.percent5 = percent5;
    }

    public void setEquipmentfailure(int equipmentfailure) {
        this.equipmentfailure = equipmentfailure;
    }

    public void setEquipmentonline(int equipmentonline) {
        this.equipmentonline = equipmentonline;
    }

    public void setStationonline(int stationonline){
        this.stationonline = stationonline;
    }

    public void setStationfailure(int stationfailure){
        this.stationfailure = stationfailure;
    }

    public void setStationplanning(int stationplanning){
        this.stationplanning = stationplanning;
    }

    public void setPercent1(int percent1){
        this.percent1 = percent1;
    }

    public void setPercent2(int percent2){
        this.percent2 = percent2;
    }

    public void setPercent3(int percent3){
        this.percent3 = percent3;
    }

    public void setPercent4(int percent4){
        this.percent4 = percent4;
    }

    public void setPercent5(int percent5){
        this.percent5 = percent5;
    }

    public int getEquipmentonline()
    {
        return equipmentonline;
    }

    public int getEquipmentfailure()
    {
        return equipmentfailure;
    }

    public int getStationonline()
    {
        return stationonline;
    }

    public int getStationfailure()
    {
        return stationfailure;
    }

    public int getStationplanning()
    {
        return stationplanning;
    }

    public int getPercent1()
    {
        return percent1;
    }

    public int getPercent2()
    {
        return percent2;
    }

    public int getPercent3()
    {
        return percent3;
    }

    public int getPercent4()
    {
        return percent4;
    }

    public int getPercent5()
    {
        return percent5;
    }
}
