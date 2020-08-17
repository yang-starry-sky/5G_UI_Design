package com.myapplication.UIDesign.Area;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.BaseStation.BaseStationItemAdapter;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class AreaActivity extends AppCompatActivity {
    private List<AreaActivityItem> areaActivityItemList=new ArrayList<>();//主界面信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area1);
        this.setTitle(getClass().getSimpleName());//设置标题

        InitAreaItems();//信息初始化，可以拓展成接口
        //对信息的展示
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.area_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        AreaActivityItemAdapter areaActivityItemAdapter=new AreaActivityItemAdapter(areaActivityItemList);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(areaActivityItemAdapter);
    }

    /**
     * 简单地初始化信息
     */
    public void InitAreaItems(){
        AreaActivityItem areaActivityItem1=new AreaActivityItem("南京EMBB",
                "最近修改时间  2018-11-13 12:02:00", "admin", "南京EMBB");
        areaActivityItemList.add(areaActivityItem1);
        AreaActivityItem areaActivityItem2=new AreaActivityItem("无锡EMBB",
                "最近修改时间  2018-11-13 12:02:00", "admin", "无锡EMBB");
        areaActivityItemList.add(areaActivityItem2);
        AreaActivityItem areaActivityItem3=new AreaActivityItem("扬州EMBB",
                "最近修改时间  2018-11-13 12:02:00", "admin", "扬州EMBB");
        areaActivityItemList.add(areaActivityItem3);
        AreaActivityItem baseStationItem4=new AreaActivityItem("上海EMBB",
                "最近修改时间  2018-11-13 12:02:00", "admin", "上海EMBB");
        areaActivityItemList.add(baseStationItem4);
        AreaActivityItem baseStationItem5=new AreaActivityItem("北京EMBB",
                "最近修改时间  2018-11-13 12:02:00", "admin", "北京EMBB");
        areaActivityItemList.add(baseStationItem5);

    }
}