package com.myapplication.UIDesign.Equipment;

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
import com.myapplication.UIDesign.Area.AreaActivityItem;
import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.BaseStation.BaseStationItemAdapter;
import com.myapplication.UIDesign.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EquipmentFragment extends Fragment {
    private List<EquipmentItem> equipmentItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipment,container,false);

        InitEquipmentItems();
        //对信息的展示
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.equipment_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        EquipmentItemAdapter equipmentItemAdapter=new EquipmentItemAdapter(equipmentItems);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(equipmentItemAdapter);
        return view;
    }

    /**设备对象的初始化
     * 可改写为方法，用于动态获取设备信息
     */
    public void InitEquipmentItems(){
        //sendRequestWithHttpURLConnection();
        EquipmentItem equipmentItem1=new EquipmentItem("ConcertHall-Ring1-CSG1",
                "上线状态   Failure","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem1);
        EquipmentItem equipmentItem2=new EquipmentItem("ConcertHall-Ring1-CSG2",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem2);
        EquipmentItem equipmentItem3=new EquipmentItem("ConcertHall-Ring1-CSG3",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem3);
        EquipmentItem equipmentItem4=new EquipmentItem("ConcertHall-Ring1-CSG4",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem4);
        EquipmentItem equipmentItem5=new EquipmentItem("ConcertHall-Ring1-CSG5",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem5);
        EquipmentItem equipmentItem6=new EquipmentItem("ConcertHall-Ring1-CSG6",
                "上线状态   Online","运行状态   Normal",
                "上线时间   2020-04-12 20:55:21");
        equipmentItems.add(equipmentItem6);
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
                    Request request=new Request.Builder().url("127.0.0.1/Equipment/init").build();
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
        List<EquipmentItem> equipmentItems1=gson.fromJson(jsonData,new TypeToken<List<EquipmentItem>>(){}.getType());
        equipmentItems=equipmentItems1;
    }

}
