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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myapplication.UIDesign.Database.Area;
import com.myapplication.UIDesign.Database.BaseStation;
import com.myapplication.UIDesign.Database.Equipment;
//import com.myapplication.UIDesign.Equipment.EquipmentItem;
import com.myapplication.UIDesign.Divider.RecycleViewDivider;
import com.myapplication.UIDesign.R;
import com.myapplication.UIDesign.Utils.Utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

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
    private List<BaseStation> baseStationItems=new ArrayList<>();//主界面信息
    BaseStationItemAdapter baseStationItemAdapter=new BaseStationItemAdapter(baseStationItems);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_base_station,container,false);

        InitBaseStationItems();//信息初始化，可以拓展成接口
        //对信息的展示
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.base_station_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        //recyclerView.addItemDecoration(new RecycleViewDivider(view.getContext(),LinearLayoutManager.HORIZONTAL,
                //10,getResources().getColor(R.color.lavender)));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(baseStationItemAdapter);
        getActivity().setTitle("基站");//改变标题
        return view;
    }

    /**
     * 简单地初始化信息
     */
    private List<BaseStation> baseStationList;
    public void InitBaseStationItems() {

        baseStationList = DataSupport.findAll(BaseStation.class);
        sendRequestWithHttpURLConnection();
        if(!Utility.netWorkCheck(this.getContext())){ //没联网则用数据库数据
            baseStationItems.clear();
            for(BaseStation baseStation : baseStationList){
                baseStationItems.add(baseStation);
            }

        }else{
            sendRequestWithHttpURLConnection();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        baseStationItemAdapter.notifyDataSetChanged();
        baseStationItemAdapter.setmBaseStationItemList(baseStationItems);
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
        Gson gson=new Gson();
        List<BaseStation> baseStationItems1=gson.fromJson(jsonData, new TypeToken<List<BaseStation>>(){}.getType());
        baseStationItems=baseStationItems1;

        //持久化
        for(int i = 0; i < baseStationItems.size(); i++ ){
            BaseStation baseStation = new BaseStation();
            baseStation.setAddress(baseStationItems.get(i).getAddress());
            baseStation.setDeploymentStatus(baseStationItems.get(i).getDeploymentStatus());
            baseStation.setOperatingStatus(baseStationItems.get(i).getOperatingStatus());
            baseStation.setTime(baseStationItems.get(i).getTime());
            baseStation.save();
        }
        baseStationItemAdapter.setmBaseStationItemList(baseStationItems);

    }
}
