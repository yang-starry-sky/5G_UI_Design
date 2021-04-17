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
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.base_station_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //System.out.println(baseStationItems.get(0).getAddress());
        BaseStationItemAdapter baseStationItemAdapter=new BaseStationItemAdapter(baseStationItems);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(baseStationItemAdapter);
        getActivity().setTitle("基站");//改变标题
        return view;
    }

    /**
     * 简单地初始化信息
     */
    public void InitBaseStationItems() {
        sendRequestWithHttpURLConnection();
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
                    Request request=new Request.Builder().url("http://121.36.85.175:80/BaseStation/init").build();
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
            JSONArray jsonArray=new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String address=jsonObject.getString("address");
                String deploymentStatus=jsonObject.getString("deploymentStatus");
                String operatingStatus=jsonObject.getString("operatingStatus");
                String time=jsonObject.getString("time");
                BaseStationItem baseStationItem=new BaseStationItem(address,deploymentStatus,operatingStatus,time);
                baseStationItems.add(baseStationItem);
                //System.out.println(i+" "+baseStationItem.getAddress());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
