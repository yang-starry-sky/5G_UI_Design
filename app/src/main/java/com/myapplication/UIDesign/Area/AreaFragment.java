package com.myapplication.UIDesign.Area;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.Database.Area;
import com.myapplication.UIDesign.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class AreaFragment extends Fragment {
    RecyclerView recyclerView;
    AreaActivityItemAdapter adapter;

    private List<Area> AllAreaList;
    private List<AreaActivityItem> areaActivityItemList=new ArrayList<>();//主界面信息

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.area_fragment, container,false);  //获取area_fragment布局
        //信息初始化，可以拓展成接口
        recyclerView=(RecyclerView)view.findViewById(R.id.area_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new AreaActivityItemAdapter(areaActivityItemList);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        InitAreaItems();
        //对信息的展示
        

        getActivity().setTitle("区域");//改变标题
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        queryAllAreas();
    }

    private void queryAllAreas(){
        AllAreaList = DataSupport.findAll(Area.class);
        if (AllAreaList.size() > 0){

        }
    }

    /**
     * 简单地初始化信息
     */
    public void InitAreaItems(){
        sendRequestWithHttpURLConnection();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
                    Request request=new Request.Builder().url("http://121.36.85.175:80/Area/init").build();
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
        List<AreaActivityItem> areaActivityItemList1=gson.fromJson(jsonData,new TypeToken<List<AreaActivityItem>>(){}.getType());
        areaActivityItemList=areaActivityItemList1;
        adapter.setmAreaActivityItemList(areaActivityItemList);
    }
}