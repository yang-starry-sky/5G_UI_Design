package com.myapplication.UIDesign.BaseStation;

/**
 * 存储详细基站信息
 */
public class BaseStationInfoItem {
    private String address;
    private String deploymentStatus;
    private String operatingStatus;
    private String time;
    private String type;
    private String vpnName;
    private String city;
    private String community;
    private String UNIInterface;
    private String Remarks;

    public BaseStationInfoItem(String address){
        this.address=address;
    }

    public void setDeploymentStatus(String deploymentStatus) {
        this.deploymentStatus = deploymentStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setUNIInterface(String UNIInterface) {
        this.UNIInterface = UNIInterface;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public void setVpnName(String vpnName) {
        this.vpnName = vpnName;
    }

    public String getTime() {
        return time;
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public String getDeploymentStatus() {
        return deploymentStatus;
    }

    public String getCity() {
        return city;
    }

    public String getCommunity() {
        return community;
    }

    public String getRemarks() {
        return Remarks;
    }

    public String getType() {
        return type;
    }

    public String getUNIInterface() {
        return UNIInterface;
    }

    public String getVpnName() {
        return vpnName;
    }
}
