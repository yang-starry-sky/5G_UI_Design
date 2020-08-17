package com.myapplication.UIDesign.Equipment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myapplication.UIDesign.BaseStation.BaseStationInfoItem;
import com.myapplication.UIDesign.R;

public class EquipmentInfoActivity extends AppCompatActivity {
    private EquipmentInfoItem equipmentInfoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_info);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        getEquipmentInfoItem(name);
        this.setTitle(name);
        showInfo();
    }

    private void getEquipmentInfoItem(String name){
        equipmentInfoItem=new EquipmentInfoItem(name);
        equipmentInfoItem.setOnlineStatus("Failure");
        equipmentInfoItem.setOperatingStatus("Normal");
        equipmentInfoItem.setOnlineTime("2020-04-12 20:55:21");
        equipmentInfoItem.setESN("A1B39123592");
        equipmentInfoItem.setAccessRingName("ConcertHall-Ring");
        equipmentInfoItem.setLookbackIP("10.102.10.1");
        equipmentInfoItem.setNNIInterface("ETH 2/3/4");
        equipmentInfoItem.setAddress("南京EMBB");
    }

    private void showInfo(){
        TextView textView=(TextView)findViewById(R.id.equipment_info_onlineStatus);
        textView.setText("上线状态             "+equipmentInfoItem.getOnlineStatus());
        textView=(TextView)findViewById(R.id.equipment_info_operatingStatus);
        textView.setText("运行状态             "+equipmentInfoItem.getOperatingStatus());
        textView=(TextView)findViewById(R.id.equipment_info_onlineTime);
        textView.setText("上线时间             "+equipmentInfoItem.getOnlineTime());
        textView=(TextView)findViewById(R.id.equipment_info_esn);
        textView.setText("ESN                 "+equipmentInfoItem.getESN());
        textView=(TextView)findViewById(R.id.equipment_info_accessRingName);
        textView.setText("Access Ring Name    "+equipmentInfoItem.getAccessRingName());
        textView=(TextView)findViewById(R.id.equipment_info_lookbackIP);
        textView.setText("Lookback IP         "+equipmentInfoItem.getLookbackIP());
        textView=(TextView)findViewById(R.id.equipment_info_NNIInterface);
        textView.setText("NNI Interface       "+equipmentInfoItem.getNNIInterface());
        textView=(TextView)findViewById(R.id.equipment_info_address);
        textView.setText("所属区域             "+equipmentInfoItem.getAddress());
    }
}