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
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showInfo();//展示信息
    }

    /**
     * 根据地址获取详细信息，可拓展为接口
     * @param address 基站地址
     */
    private void getBaseStationInfoItem(String address){
        baseStationInfoItem=new BaseStationInfoItem(address);
        sendRequestWithHttpURLConnection(address);
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
                    Request request=new Request.Builder().url("http://121.36.85.175:80/BaseStation/getData").post(requestBody).build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    parseJsonWithJsonObject(responseData);
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
            String city=jsonObject.get("city").toString();
            String community=jsonObject.get("community").toString();
            String operatingStatus=jsonObject.get("operatingStatus").toString();
            String time=jsonObject.get("time").toString();
            String deploymentStatus=jsonObject.get("deploymentStatus").toString();
            String remarks=jsonObject.get("remarks").toString();
            String UNIInterface=jsonObject.get("uniinterface").toString();
            String vpnName=jsonObject.get("vpnName").toString();
            String type=jsonObject.get("type").toString();
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