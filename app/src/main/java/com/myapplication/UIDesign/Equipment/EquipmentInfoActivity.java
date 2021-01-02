package com.myapplication.UIDesign.Equipment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.myapplication.UIDesign.BaseStation.BaseStationInfoItem;
import com.myapplication.UIDesign.R;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.myapplication.UIDesign.R;

import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
        //sendRequestWithHttpURLConnection(address);
        equipmentInfoItem.setCity("南京EMBB");
        equipmentInfoItem.setCommunity("雨花台区");
        equipmentInfoItem.setDeploymentStatus("Failure");   //这行
        equipmentInfoItem.setOperatingStatus("Normal");     //还有这行，跟EquipmentInfoItem中的信息重复
        equipmentInfoItem.setRemarks("xxxxxxxxxxxxxxxx");
        equipmentInfoItem.setTime("2020-04-12 20:55:21");
        equipmentInfoItem.setUNIInterface("ETH 2/3/4");
        equipmentInfoItem.setVpnName("eMBB");
        equipmentInfoItem.setType("gNodeB");
    }

    /**
     * post方法根据address获取详细信息
     * @param address 地址
     */
    private void sendRequestWithHttpURLConnection(final String address){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    RequestBody requestBody=new FormBody.Builder().add("address",address).build();
                    Request request=new Request.Builder().url("127.0.0.1/Equipment/getData").post(requestBody).build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    //parseJsonWithJsonObject(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /**
     * 解析json格式数据
     * @param jsonData 服务器返回的json格式数据
     */
    private void parseJsonWithJsonObject(String jsonData){
        Gson gson=new Gson();
        EquipmentInfoItem equipmentInfoItem1=gson.fromJson(jsonData,EquipmentInfoItem.class);
        equipmentInfoItem=equipmentInfoItem1;
    }

    /**
     * 在设备信息展示页面上显示具体信息
     */
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