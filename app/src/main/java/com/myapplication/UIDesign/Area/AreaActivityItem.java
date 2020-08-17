package com.myapplication.UIDesign.Area;

public class AreaActivityItem {

    private String areaTitle;
    private String modificationTime;
    private String creator;
    private String description;


    public AreaActivityItem(String areaTitle, String modificationTime, String creator, String description){
        this.areaTitle=areaTitle;
        this.modificationTime=modificationTime;
        this.creator=creator;
        this.description=description;
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
}
