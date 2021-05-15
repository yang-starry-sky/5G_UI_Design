package com.myapplication.UIDesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myapplication.UIDesign.Area.AreaFragment;
import com.myapplication.UIDesign.BaseStation.BaseStationFragment;
//import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.Database.Area;
import com.myapplication.UIDesign.Database.BaseStation;
import com.myapplication.UIDesign.Database.Equipment;
import com.myapplication.UIDesign.Database.Graph;
import com.myapplication.UIDesign.Equipment.EquipmentFragment;

import com.myapplication.UIDesign.Equipment.EquipmentInfoItem;

import com.myapplication.UIDesign.Notification.CircularRequest;

import com.myapplication.UIDesign.Notification.NotificationHelper;
import com.myapplication.UIDesign.Notification.UpdateItem;
import com.myapplication.UIDesign.Overview.OverviewFragment;
import com.myapplication.UIDesign.Overview.GraphicInfoItem;
//import com.myapplication.UIDesign.Utils.DataUtility;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static Graph graphicdata;
    public List<Area> areaList = new ArrayList<>();
    public List<BaseStation> baseStationList= new ArrayList<>();
    public List<Equipment> equipmentList = new ArrayList<>();

    private TextView overview,area,equipment,baseStation;
    private TextView overviewPoint,areaPoint,equipmentPoint,baseStationPoint;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setgraphicData();//图形化数据传入接口

        //发请求
        sendUpdateRequest();
        sendAreaRequest();
        sendBaseStationRequest();
        sendEquipmentRequest();


        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LitePal.getDatabase();  //创建数据库
//        DataUtility.addAreaData();//填入数据
//        DataUtility.addBaseStationData();
//        DataUtility.addEquipmentData();


        bindView();
        //setPoint();//可拓展消息提示
        initTabMenu();
        overview.setSelected(true);
        replaceFragment(new OverviewFragment());
        CircularRequest circularRequest = new CircularRequest(this);
        circularRequest.run();

        /**
         * 主函数句柄,用于处理轮询消息
         */
        this.mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                refreshPointAndNotification((UpdateItem) msg.obj);
            }
        };


    }

    /**
     * 点击事件，用来切换fragment
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tab_menu_overview:
                clearOverviewPoint();
                setSelected();
                overview.setSelected(true);
                replaceFragment(new OverviewFragment());
                break;
            case R.id.tab_menu_area:
                clearAreaPoint();
                setSelected();
                area.setSelected(true);
                replaceFragment(new AreaFragment());
                break;
            case R.id.tab_menu_equipment:
                clearEquipmentPoint();
                setSelected();
                equipment.setSelected(true);
                replaceFragment(new EquipmentFragment());
                break;
            case R.id.tab_menu_base_station:
                clearBaseStationPoint();
                setSelected();
                baseStation.setSelected(true);
                replaceFragment(new BaseStationFragment());
                break;
            default:
                break;
        }
    }

    /**
     * 切换fragment
     * @param fragment 需要切换的fragment
     */
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }

    /**
     * 将控件关联，并设置点击事件
     */
    private void bindView(){
        overview=(TextView)findViewById(R.id.tab_menu_overview);
        area=(TextView)findViewById(R.id.tab_menu_area);
        equipment=(TextView)findViewById(R.id.tab_menu_equipment);
        baseStation=(TextView)findViewById(R.id.tab_menu_base_station);

        overviewPoint=(TextView)findViewById(R.id.tab_menu_overview_point);
        areaPoint=(TextView)findViewById(R.id.tab_menu_area_point);
        equipmentPoint=(TextView)findViewById(R.id.tab_menu_equipment_point);
        baseStationPoint=(TextView)findViewById(R.id.tab_menu_base_station_point);

        overview.setOnClickListener(this);
        area.setOnClickListener(this);
        equipment.setOnClickListener(this);
        baseStation.setOnClickListener(this);
    }

    /**
     * 初始化图片格式
     */
    private void initTabMenu(){
        Drawable drawable=getResources().getDrawable(R.drawable.tab_menu_overview);
        drawable.setBounds(0,0,65,65);
        overview.setCompoundDrawables(null,drawable,null,null);

        drawable=getResources().getDrawable(R.drawable.tab_menu_area);
        drawable.setBounds(0,0,65,65);
        area.setCompoundDrawables(null,drawable,null,null);

        drawable=getResources().getDrawable(R.drawable.tab_menu_equipment);
        drawable.setBounds(0,0,65,65);
        equipment.setCompoundDrawables(null,drawable,null,null);

        drawable=getResources().getDrawable(R.drawable.tab_menu_base_station);
        drawable.setBounds(0,0,65,65);
        baseStation.setCompoundDrawables(null,drawable,null,null);

        drawable=getResources().getDrawable(R.drawable.tab_menu_base_station);
        drawable.setBounds(0,0,65,65);
        baseStation.setCompoundDrawables(null,drawable,null,null);
    }

    /**
     * 全部设置为未选择状态
     */
    private void setSelected(){
        overview.setSelected(false);
        area.setSelected(false);
        equipment.setSelected(false);
        baseStation.setSelected(false);
    }

    /**
     * 设置消息提示点是否可见
     */
    private void setPoint(){
        overviewPoint.setVisibility(View.VISIBLE);
        areaPoint.setVisibility(View.VISIBLE);
        equipmentPoint.setVisibility(View.VISIBLE);
        baseStationPoint.setVisibility(View.VISIBLE);
    }

    private void setOverviewPoint(){
        overviewPoint.setVisibility(View.VISIBLE);
    }

    private void setAreaPoint(){
        areaPoint.setVisibility(View.VISIBLE);
    }

    private void setEquipmentPoint(){
        equipmentPoint.setVisibility(View.VISIBLE);
    }

    private void setBaseStationPoint(){
        baseStationPoint.setVisibility(View.VISIBLE);
    }

    private void clearPoint(){
        overviewPoint.setVisibility(View.INVISIBLE);
        areaPoint.setVisibility(View.INVISIBLE);
        equipmentPoint.setVisibility(View.INVISIBLE);
        baseStationPoint.setVisibility(View.INVISIBLE);
    }

    private void clearOverviewPoint(){
        overviewPoint.setVisibility(View.INVISIBLE);
    }

    private void clearAreaPoint(){
        areaPoint.setVisibility(View.INVISIBLE);
    }

    private void clearEquipmentPoint(){
        equipmentPoint.setVisibility(View.INVISIBLE);
    }

    private void clearBaseStationPoint(){
        baseStationPoint.setVisibility(View.INVISIBLE);
    }


    private void setgraphicData()
    {
        sendRequestWithHttpURLConnection();
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
                    Request request=new Request.Builder().url("http://121.36.85.175:80/Overview/init").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    parseGraphJsonWithJsonObject(responseData);
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
    private void parseGraphJsonWithJsonObject(String jsonData){
        Gson gson=new Gson();
        Graph graphicdata1=gson.fromJson(jsonData,Graph.class);
        graphicdata=graphicdata1;

        //持久化
        Graph graph = new Graph();
        graph.setEquipmentonline(graphicdata.getEquipmentonline());
        graph.setEquipmentfailure(graphicdata.getEquipmentfailure());
        graph.setStationonline(graphicdata.getStationonline());
        graph.setStationfailure(graphicdata.getStationfailure());
        graph.setStationplanning(graphicdata.getStationplanning());
        graph.setPercent1(graphicdata.getPercent1());
        graph.setPercent2(graphicdata.getPercent2());
        graph.setPercent3(graphicdata.getPercent3());
        graph.setPercent4(graphicdata.getPercent4());
        graph.setPercent5(graphicdata.getPercent5());
        graph.save();
    }

    private void sendAreaRequest(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://121.36.85.175:80/Area/init").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    parseAreaJsonWithJsonObject(responseData);
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

    private void parseAreaJsonWithJsonObject(String jsonData){
        Gson gson=new Gson();
        areaList=gson.fromJson(jsonData,new TypeToken<List<Area>>(){}.getType());

        //持久化
        for(int i = 0; i < areaList.size(); i++ ){
            Area area = new Area();
            area.setFirstchar(areaList.get(i).getFirstchar());
            area.setAreaTitle(areaList.get(i).getAreaTitle());
            area.setCreator(areaList.get(i).getCreator());
            area.setModificationTime(areaList.get(i).getModificationTime());
            area.setDescription(areaList.get(i).getDescription());
            area.save();
        }
    }

    private void sendBaseStationRequest(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://121.36.85.175:80/BaseStation/init").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    parseBaseStationJsonWithJsonObject(responseData);
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
    private void parseBaseStationJsonWithJsonObject(String jsonData){
        Gson gson=new Gson();
        baseStationList=gson.fromJson(jsonData, new TypeToken<List<BaseStation>>(){}.getType());


        //持久化
        for(int i = 0; i < baseStationList.size(); i++ ){
            BaseStation baseStation = new BaseStation();
            baseStation.setAddress(baseStationList.get(i).getAddress());
            baseStation.setDeploymentStatus(baseStationList.get(i).getDeploymentStatus());
            baseStation.setOperatingStatus(baseStationList.get(i).getOperatingStatus());
            baseStation.setTime(baseStationList.get(i).getTime());
            baseStation.save();
        }
    }

    private void sendEquipmentRequest(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://121.36.85.175:80/Equipment/init").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    parseEquipmentJsonWithJsonObject(responseData);
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
    private void parseEquipmentJsonWithJsonObject(String jsonData){
        Gson gson=new Gson();
         equipmentList=gson.fromJson(jsonData,new TypeToken<List<Equipment>>(){}.getType());


        //持久化
        for(int i = 0; i < equipmentList.size(); i++){
            Equipment equipment = new Equipment();
            equipment.setName(equipmentList.get(i).getName());
            equipment.setOnlineStatus(equipmentList.get(i).getOnlineStatus());
            equipment.setOperatingStatus(equipmentList.get(i).getOperatingStatus());
            equipment.setTime(equipmentList.get(i).getTime());
            equipment.save();
            //目前页面只有这四个数据
        }
    }

    public void sendUpdateRequest(){                        //请求JSON更新数据
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {                        //子线程
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://121.36.85.175:80/update").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    System.out.println(responseData);
                    parseUpdateJsonWithJsonObject(responseData);
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

    private void parseUpdateJsonWithJsonObject(String jsonData){//用于解析更新的JSON数据
        Gson gson=new Gson();
        UpdateItem updateItem;
        updateItem=gson.fromJson(jsonData,UpdateItem.class);
        Message message=new Message();
        message.obj = updateItem;
        mHandler.sendMessage(message);                          //利用Handler将更新信息发回主线程
        }

    private void refreshPointAndNotification(UpdateItem updateItem){//该函数用于处理更新信息，必须在主线程中被调用，否则无效
        List<Integer> list;
        String content = "";
        if(updateItem.getStatus()==false){//没有更新，直接返回
            return;
        }
        list= updateItem.getList();
        for(int i=0;i<list.size();i++){//根据信息设置红点，并拼接通知内容字符串
            switch (list.get(i)){
                case 1:
                    content = content + ",概览";
                    setOverviewPoint();
                    break;
                case 2:
                    content = content + ",区域";
                    setAreaPoint();
                    break;
                case 3:
                    content = content + ",设备";
                    setEquipmentPoint();
                    break;
                case 4:
                    content = content + ",基站";
                    setBaseStationPoint();
                    break;
                default:break;
            }
        }
        content =content+" 界面有数据更新";
        content=content.substring(1);   //去掉第一个逗号
        NotificationHelper helper;      //创建
        helper = new NotificationHelper(MainActivity.this);  //实例化
        helper.setTitle("通知");         //设置通知标题
        helper.setContent(content);     //设置通知文本内容
        helper.sendNotification();      //发送通知


    }

}