package com.myapplication.UIDesign.Area;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.Database.Area;
import com.myapplication.UIDesign.R;
import com.myapplication.UIDesign.Utils.HttpUtil;
import com.myapplication.UIDesign.Utils.Utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class AreaFragment extends Fragment {
    RecyclerView recyclerView;
    AreaActivityItemAdapter adapter;

    private List<Area> areaActivityItemList=new ArrayList<>();//主界面信息

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.area_fragment, container,false);  //获取area_fragment布局
        //信息初始化，可以拓展成接口
        recyclerView=(RecyclerView)view.findViewById(R.id.area_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new AreaActivityItemAdapter(areaActivityItemList);
        //recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        InitAreaItems();
        //对信息的展示

        getActivity().setTitle("区域");//改变标题
        return view;
    }

    /**
     * 简单地初始化信息
     */
    private List<Area> areaList;
    public void InitAreaItems(){
        areaList = DataSupport.findAll(Area.class);
        sendRequestWithHttpURLConnection();
        if(!Utility.netWorkCheck(this.getContext())){ //没联网则用数据库数据
            areaActivityItemList.clear();
            for(Area area : areaList){
                areaActivityItemList.add(area);
            }
        }else{
            sendRequestWithHttpURLConnection();

        }
        adapter.notifyDataSetChanged();
        adapter.setmAreaActivityItemList(areaActivityItemList);
    }

    /**
     * 向服务器发送初始化请求
     */
    private void sendRequestWithHttpURLConnection(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://121.36.85.175:80/Area/init").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    parseJsonWithJsonObject(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();//注意这里
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析json格式数据
     * @param jsonData 服务器返回的json格式数据
     */
    private void parseJsonWithJsonObject(String jsonData){
        Gson gson=new Gson();
        List<Area> areaActivityItemList1=gson.fromJson(jsonData,new TypeToken<List<Area>>(){}.getType());
        areaActivityItemList=areaActivityItemList1;

        //持久化
        for(int i = 0; i < areaActivityItemList.size(); i++ ){
            Area area = new Area();
            area.setFirstchar(areaActivityItemList.get(i).getFirstchar());
            area.setAreaTitle(areaActivityItemList.get(i).getAreaTitle());
            area.setCreator(areaActivityItemList.get(i).getCreator());
            area.setModificationTime(areaActivityItemList.get(i).getModificationTime());
            area.setDescription(areaActivityItemList.get(i).getDescription());
            area.save();
        }
        adapter.setmAreaActivityItemList(areaActivityItemList);
    }









}