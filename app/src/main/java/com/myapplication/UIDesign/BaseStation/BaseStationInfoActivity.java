package com.myapplication.UIDesign.BaseStation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.myapplication.UIDesign.R;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 展示每一个地区的基站详细信息
 */
public class BaseStationInfoActivity extends AppCompatActivity {
    private BaseStationInfoItem baseStationInfoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_station_info);

        Intent intent=getIntent();//获取地区的信息
        String address=intent.getStringExtra("address");
        getBaseStationInfoItem(address);//根据地址获取详细信息，可拓展为接口
        this.setTitle(address);
        showInfo();//展示信息
    }

    /**
     * 根据地址获取详细信息，可拓展为接口
     * @param address 基站地址
     */
    private void getBaseStationInfoItem(String address){
        baseStationInfoItem=new BaseStationInfoItem(address);
        //sendRequestWithHttpURLConnection(address);
        baseStationInfoItem.setCity("南京EMBB");
        baseStationInfoItem.setCommunity("雨花台区");
        baseStationInfoItem.setDeploymentStatus("Failure");
        baseStationInfoItem.setOperatingStatus("Normal");
        baseStationInfoItem.setRemarks("xxxxxxxxxxxxxxxx");
        baseStationInfoItem.setTime("2020-04-12 20:55:21");
        baseStationInfoItem.setUNIInterface("ETH 2/3/4");
        baseStationInfoItem.setVpnName("eMBB");
        baseStationInfoItem.setType("gNodeB");
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
                    Request request=new Request.Builder().url("127.0.0.1/BaseStation/getData").post(requestBody).build();
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
        try {
            JSONObject jsonObject=new JSONObject(jsonData);
            String city=jsonObject.getString("city");
            String community=jsonObject.getString("community");
            String operatingStatus=jsonObject.getString("operatingStatus");
            String time=jsonObject.getString("time");
            String deploymentStatus=jsonObject.getString("deploymentStatus");
            String remarks=jsonObject.getString("remarks");
            String UNIInterface=jsonObject.getString("UNIInterface");
            String vpnName=jsonObject.getString("vpnName");
            String type=jsonObject.getString("type");
            baseStationInfoItem.setCity(city);
            baseStationInfoItem.setCommunity(community);
            baseStationInfoItem.setDeploymentStatus(deploymentStatus);
            baseStationInfoItem.setOperatingStatus(operatingStatus);
            baseStationInfoItem.setRemarks(remarks);
            baseStationInfoItem.setTime(time);
            baseStationInfoItem.setUNIInterface(UNIInterface);
            baseStationInfoItem.setVpnName(vpnName);
            baseStationInfoItem.setType(type);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showInfo(){
        TextView textView=(TextView)findViewById(R.id.base_station_info_city);
        textView.setText(baseStationInfoItem.getCity());
        textView=(TextView)findViewById(R.id.base_station_info_community);
        textView.setText(baseStationInfoItem.getCommunity());
        textView=(TextView)findViewById(R.id.base_station_info_deploymentStatus);
        textView.setText(baseStationInfoItem.getDeploymentStatus());
        textView=(TextView)findViewById(R.id.base_station_info_operatingStatus);
        textView.setText(baseStationInfoItem.getOperatingStatus());
        textView=(TextView)findViewById(R.id.base_station_info_Remarks);
        textView.setText(baseStationInfoItem.getRemarks());
        textView=(TextView)findViewById(R.id.base_station_info_time);
        textView.setText(baseStationInfoItem.getTime());
        textView=(TextView)findViewById(R.id.base_station_info_type);
        textView.setText(baseStationInfoItem.getType());
        textView=(TextView)findViewById(R.id.base_station_info_UNIInterface);
        textView.setText(baseStationInfoItem.getUNIInterface());
        textView=(TextView)findViewById(R.id.base_station_info_vpnName);
        textView.setText(baseStationInfoItem.getVpnName());
    }
}