package com.myapplication.UIDesign.Equipment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myapplication.UIDesign.BaseStation.BaseStationInfoItem;
import com.myapplication.UIDesign.R;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.myapplication.UIDesign.R;

/**
 * 展示每一个地区的基站详细信息
 */
public class EquipmentInfoActivity extends AppCompatActivity {
    private EquipmentInfoItem equipmentInfoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_info);

        Intent intent=getIntent();//获取地区的信息
        String address=intent.getStringExtra("address");
        getEquipmentInfoItem(address);//根据地址获取详细信息，可拓展为接口
        this.setTitle(address);
        showInfo();//展示信息
    }

    /**
     * 根据地址获取详细信息，可拓展为接口
     * @param address 基站地址
     */
    private void getEquipmentInfoItem(String address){
        equipmentInfoItem=new EquipmentInfoItem(address);
        equipmentInfoItem.setCity("南京EMBB");
        equipmentInfoItem.setCommunity("雨花台区");
        equipmentInfoItem.setDeploymentStatus("Failure");
        equipmentInfoItem.setOperatingStatus("Normal");
        equipmentInfoItem.setRemarks("xxxxxxxxxxxxxxxx");
        equipmentInfoItem.setTime("2020-04-12 20:55:21");
        equipmentInfoItem.setUNIInterface("ETH 2/3/4");
        equipmentInfoItem.setVpnName("eMBB");
        equipmentInfoItem.setType("gNodeB");
    }

    private void showInfo(){
        TextView textView=(TextView)findViewById(R.id.base_station_info_city);
        textView.setText(equipmentInfoItem.getCity());
        textView=(TextView)findViewById(R.id.base_station_info_community);
        textView.setText(equipmentInfoItem.getCommunity());
        textView=(TextView)findViewById(R.id.base_station_info_deploymentStatus);
        textView.setText(equipmentInfoItem.getDeploymentStatus());
        textView=(TextView)findViewById(R.id.base_station_info_operatingStatus);
        textView.setText(equipmentInfoItem.getOperatingStatus());
        textView=(TextView)findViewById(R.id.base_station_info_Remarks);
        textView.setText(equipmentInfoItem.getRemarks());
        textView=(TextView)findViewById(R.id.base_station_info_time);
        textView.setText(equipmentInfoItem.getTime());
        textView=(TextView)findViewById(R.id.base_station_info_type);
        textView.setText(equipmentInfoItem.getType());
        textView=(TextView)findViewById(R.id.base_station_info_UNIInterface);
        textView.setText(equipmentInfoItem.getUNIInterface());
        textView=(TextView)findViewById(R.id.base_station_info_vpnName);
        textView.setText(equipmentInfoItem.getVpnName());
    }
}