package com.myapplication.UIDesign.Equipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.UIDesign.BaseStation.BaseStationItemAdapter;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class EquipmentFragment extends Fragment {
    private List<EquipmentItem> equipmentItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipment,container,false);

        InitEquipmentItems();
        //对信息的展示
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.equipment_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        EquipmentItemAdapter equipmentItemAdapter=new EquipmentItemAdapter(equipmentItems);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(equipmentItemAdapter);
        return view;
    }

    /**
     * 信息初始化，可以拓展成接口
     */
    public void InitEquipmentItems(){
        EquipmentItem equipmentItem1=new EquipmentItem("ConcertHall-Ring1-CSG1",
                "上线状态   Failure","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem1);
        EquipmentItem equipmentItem2=new EquipmentItem("ConcertHall-Ring1-CSG2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem2);
        EquipmentItem equipmentItem3=new EquipmentItem("ConcertHall-Ring1-CSG3",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem3);
        EquipmentItem equipmentItem4=new EquipmentItem("ConcertHall-Ring1-CSG4",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem4);
        EquipmentItem equipmentItem5=new EquipmentItem("ConcertHall-Ring1-CSG5",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem5);
        EquipmentItem equipmentItem6=new EquipmentItem("ConcertHall-Ring1-CSG6",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem6);
    }

}
