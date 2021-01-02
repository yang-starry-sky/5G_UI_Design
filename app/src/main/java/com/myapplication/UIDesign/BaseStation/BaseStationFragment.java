package com.myapplication.UIDesign.BaseStation;


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

import com.myapplication.UIDesign.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BaseStationFragment extends Fragment {
    private List<BaseStationItem> baseStationItems=new ArrayList<>();//主界面信息

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_base_station,container,false);

        InitBaseStationItems();//信息初始化，可以拓展成接口
        //对信息的展示
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.base_station_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        BaseStationItemAdapter baseStationItemAdapter=new BaseStationItemAdapter(baseStationItems);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(baseStationItemAdapter);
        return view;
    }

    /**
     * 简单地初始化信息
     */
    public void InitBaseStationItems() {
        //sendRequestWithHttpURLConnection();
        BaseStationItem baseStationItem1=new BaseStationItem("CentralPark-Ring1-gNodeB1",
                "上线状态   Failure","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        baseStationItems.add(baseStationItem1);
        BaseStationItem baseStationItem2=new BaseStationItem("CentralPark-Ring1-gNodeB2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        baseStationItems.add(baseStationItem2);
        BaseStationItem baseStationItem3=new BaseStationItem("CentralPark-Ring1-gNodeB3",
                "上线状态   Planning","运行状态   Unknown",
                "上线时间   2020-04-12 20:55:21");
        baseStationItems.add(baseStationItem3);
        BaseStationItem baseStationItem4=new BaseStationItem("CentralPark-Ring1-gNodeB4",
                "上线状态   Planning","运行状态   Unknown",
                "上线时间   2020-04-12 20:55:21");
        baseStationItems.add(baseStationItem4);
        BaseStationItem baseStationItem5=new BaseStationItem("CentralPark-Ring1-gNodeB5",
                "上线状态   Planning","运行状态   Unknown",
                "上线时间   2020-04-12 20:55:21");
        baseStationItems.add(baseStationItem5);
        BaseStationItem baseStationItem6=new BaseStationItem("CentralPark-Ring1-gNodeB6",
                "上线状态   Planning","运行状态   Unknown",
                "上线时间   2020-04-12 20:55:21");
        baseStationItems.add(baseStationItem6);
    }
    /**
     * 向服务器发送初始化请求
     */
    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("127.0.0.1/BaseStation/init").build();
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
            JSONArray jsonArray=new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String address=jsonObject.getString("address");
                String deploymentStatus=jsonObject.getString("deploymentStatus");
                String operatingStatus=jsonObject.getString("operatingStatus");
                String time=jsonObject.getString("time");
                BaseStationItem baseStationItem=new BaseStationItem(address,deploymentStatus,operatingStatus,time);
                baseStationItems.add(baseStationItem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
