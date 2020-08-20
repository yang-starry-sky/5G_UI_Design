package com.myapplication.UIDesign.Area;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class AreaFragment extends Fragment {
    private List<AreaActivityItem> areaActivityItemList=new ArrayList<>();//主界面信息

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.area_fragment, container,false);  //获取area_fragment布局

        InitAreaItems();//信息初始化，可以拓展成接口
        //对信息的展示
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.area_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        AreaActivityItemAdapter areaActivityItemAdapter=new AreaActivityItemAdapter(areaActivityItemList);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(areaActivityItemAdapter);

        return view;
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