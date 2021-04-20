package com.myapplication.UIDesign.Notification;

import java.util.List;

/**
 * @author xqf
 *
 */
public class UpdateItem {
    private boolean status;
    private List<Integer> list;

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    public List<Integer> getList() {
        return list;
    }
}
