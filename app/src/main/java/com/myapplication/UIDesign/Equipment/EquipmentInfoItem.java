package com.myapplication.UIDesign.Equipment;

public class EquipmentInfoItem {
    private String name;
    private String onlineStatus;
    private String operatingStatus;
    private String onlineTime;
    private String ESN;
    private String AccessRingName;
    private String LookbackIP;
    private String NNIInterface;
    private String address;

    public EquipmentInfoItem() {
    }

    public EquipmentInfoItem(String name) {
        this.name = name;
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

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public void setESN(String ESN) {
        this.ESN = ESN;
    }

    public void setAccessRingName(String accessRingName) {
        AccessRingName = accessRingName;
    }

    public void setLookbackIP(String lookbackIP) {
        LookbackIP = lookbackIP;
    }

    public void setNNIInterface(String NNIInterface) {
        this.NNIInterface = NNIInterface;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getOnlineTime() {
        return onlineTime;
    }

    public String getESN() {
        return ESN;
    }

    public String getAccessRingName() {
        return AccessRingName;
    }

    public String getLookbackIP() {
        return LookbackIP;
    }

    public String getNNIInterface() {
        return NNIInterface;
    }

    public String getAddress() {
        return address;
    }
}

