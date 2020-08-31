package com.myapplication.UIDesign.Area;

public class AreaActivityItem {

    private char firstchar;              //地区首字
    private String areaTitle;            //地区大字标题
    private String modificationTime;     //最近修改时间
    private String creator;              //创建者
    private String description;          //描述


    public AreaActivityItem(String areaTitle, String modificationTime, String creator, String description){
        //用于初始化
        this.areaTitle=areaTitle;
        this.modificationTime=modificationTime;
        this.creator=creator;
        this.description=description;
        this.firstchar = areaTitle.charAt(0);  //从areaTitle中获取首字

    }

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

    public void setFirstchar(char firstchar) {
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
}
