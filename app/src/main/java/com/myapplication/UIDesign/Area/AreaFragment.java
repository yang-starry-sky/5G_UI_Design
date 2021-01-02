package com.myapplication.UIDesign.Area;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AreaFragment extends Fragment {
    RecyclerView recyclerView;
    AreaActivityItemAdapter adapter;

    private List<AreaActivityItem> areaActivityItemList=new ArrayList<>();//主界面信息

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.area_fragment, container,false);  //获取area_fragment布局

        //对信息的展示
        recyclerView=(RecyclerView)view.findViewById(R.id.area_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new AreaActivityItemAdapter(areaActivityItemList);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        //信息初始化，可以拓展成接口
        InitAreaItems();
        return view;
    }

    /**
     * 简单地初始化信息
     */
    public void InitAreaItems(){
        //sendRequestWithHttpURLConnection();
        AreaActivityItem areaActivityItem1=new AreaActivityItem("南京EMBB",
                "2018-11-13 12:02:00", "admin", "南京EMBB");
        areaActivityItemList.add(areaActivityItem1);
        AreaActivityItem areaActivityItem2=new AreaActivityItem("无锡EMBB",
                "2018-11-13 12:02:00", "admin", "无锡EMBB");
        areaActivityItemList.add(areaActivityItem2);
        AreaActivityItem areaActivityItem3=new AreaActivityItem("扬州EMBB",
                "2018-11-13 12:02:00", "admin", "扬州EMBB");
        areaActivityItemList.add(areaActivityItem3);
        AreaActivityItem areaActivityItem4=new AreaActivityItem("上海EMBB",
                "2018-11-13 12:02:00", "admin", "上海EMBB");
        areaActivityItemList.add(areaActivityItem4);
        AreaActivityItem areaActivityItem5=new AreaActivityItem("北京EMBB",
                "2018-11-13 12:02:00", "admin", "北京EMBB");
        areaActivityItemList.add(areaActivityItem5);

        adapter.setmAreaActivityItemList(areaActivityItemList);

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
                    Request request=new Request.Builder().url("127.0.0.1/Area/init").build();
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
        List<AreaActivityItem> areaActivityItemList1=gson.fromJson(jsonData,new TypeToken<List<AreaActivityItem>>(){}.getType());
        areaActivityItemList=areaActivityItemList1;
        adapter.setmAreaActivityItemList(areaActivityItemList);
    }
}