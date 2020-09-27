package com.myapplication.UIDesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myapplication.UIDesign.Area.AreaFragment;
import com.myapplication.UIDesign.BaseStation.BaseStationFragment;
import com.myapplication.UIDesign.Equipment.EquipmentFragment;
import com.myapplication.UIDesign.Overview.OverviewFragment;
import com.myapplication.UIDesign.Utils.DataUtility;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView overview,area,equipment,baseStation;
    private TextView overviewPoint,areaPoint,equipmentPoint,baseStationPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LitePal.getDatabase();  //创建数据库
        DataUtility.addAreaData();//填入数据
        DataUtility.addBaseStationData();
        DataUtility.addEquipmentData();


        bindView();
        setPoint();//可拓展消息提示
        initTabMenu();
        overview.setSelected(true);
        replaceFragment(new OverviewFragment());
    }

    /**
     * 点击事件，用来切换fragment
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tab_menu_overview:
                setSelected();
                overview.setSelected(true);
                replaceFragment(new OverviewFragment());
                break;
            case R.id.tab_menu_area:
                setSelected();
                area.setSelected(true);
                replaceFragment(new AreaFragment());
                break;
            case R.id.tab_menu_equipment:
                setSelected();
                equipment.setSelected(true);
                replaceFragment(new EquipmentFragment());
                break;
            case R.id.tab_menu_base_station:
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
}