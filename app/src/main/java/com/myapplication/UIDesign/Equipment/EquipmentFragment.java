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
//import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.BaseStation.BaseStationItemAdapter;
import com.myapplication.UIDesign.Database.Equipment;
import com.myapplication.UIDesign.R;
import com.myapplication.UIDesign.Utils.Utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EquipmentFragment extends Fragment {
    private List<Equipment> equipmentItems = new ArrayList<>();;
    EquipmentItemAdapter equipmentItemAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipment,container,false);


//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //对信息的展示
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.equipment_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
//        equipmentItemAdapter=new EquipmentItemAdapter(equipmentItems);
        equipmentItemAdapter =new EquipmentItemAdapter(equipmentItems);
        //recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(equipmentItemAdapter);
        InitEquipmentItems();
        getActivity().setTitle("设备");//改变标题

        return view;
    }

    /**设备对象的初始化
     * 可改写为方法，用于动态获取设备信息
     */
    private List<Equipment> equipmentList;
    public void InitEquipmentItems(){
        equipmentList = DataSupport.findAll(Equipment.class);
        if(!Utility.netWorkCheck(this.getContext())){ //没联网则用数据库数据
            equipmentItems.clear();
            for(Equipment equipment : equipmentList){
                equipmentItems.add(equipment);
            }
        } else {
            sendRequestWithHttpURLConnection();
        }
        equipmentItemAdapter.notifyDataSetChanged();
        equipmentItemAdapter.setmEquipmentItemList(equipmentItems);
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
                    Request request=new Request.Builder().url("http://121.36.85.175:80/Equipment/init").build();
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
        List<Equipment> equipmentItems1=gson.fromJson(jsonData,new TypeToken<List<Equipment>>(){}.getType());
        equipmentItems=equipmentItems1;

        //持久化
        for(int i = 0; i < equipmentItems.size(); i++){
            Equipment equipment = new Equipment();
            equipment.setName(equipmentItems.get(i).getName());
            equipment.setOnlineStatus(equipmentItems.get(i).getOnlineStatus());
            equipment.setOperatingStatus(equipmentItems.get(i).getOperatingStatus());
            equipment.setTime(equipmentItems.get(i).getTime());
            equipment.save();
            //目前页面只有这四个数据
        }
        equipmentItemAdapter.setmEquipmentItemList(equipmentItems);
    }

}
