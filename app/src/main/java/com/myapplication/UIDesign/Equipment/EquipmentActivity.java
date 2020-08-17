package com.myapplication.UIDesign.Equipment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.BaseStation.BaseStationItemAdapter;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class EquipmentActivity extends AppCompatActivity {
    private List<EquipmentItem> equipmentItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        this.setTitle(getClass().getSimpleName());

        InitEquipmentItems();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.equipment_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        EquipmentItemAdapter equipmentItemAdapter=new EquipmentItemAdapter(equipmentItems);
        recyclerView.setAdapter(equipmentItemAdapter);
    }

    public void InitEquipmentItems(){
        EquipmentItem equipmentItem1=new EquipmentItem("CentralPark-Ring1-gNodeB1",
                "上线状态   Failure","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem1);
        EquipmentItem equipmentItem2=new EquipmentItem("CentralPark-Ring1-gNodeB2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem2);
        EquipmentItem equipmentItem3=new EquipmentItem("CentralPark-Ring1-gNodeB2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem3);
        EquipmentItem equipmentItem4=new EquipmentItem("CentralPark-Ring1-gNodeB2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem4);
        EquipmentItem equipmentItem5=new EquipmentItem("CentralPark-Ring1-gNodeB2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem5);
        EquipmentItem equipmentItem6=new EquipmentItem("CentralPark-Ring1-gNodeB2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem6);
    }
}