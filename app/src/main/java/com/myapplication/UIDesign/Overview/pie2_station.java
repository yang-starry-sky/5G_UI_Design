package com.myapplication.UIDesign.Overview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import static com.myapplication.UIDesign.MainActivity.graphicdata;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.myapplication.UIDesign.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pie2_station extends Fragment {
    private PieChart pie2_Online;
    private PieChart pie2_Failure;
    private PieChart pie2_Planning;
    private List<PieEntry> list_Online;
    private List<PieEntry> list_Failure;
    private List<PieEntry> list_Planning;
    private View view;
    private ArrayList<Integer> colors_Online;
    private ArrayList<Integer> colors_Failure;
    private ArrayList<Integer> colors_Planning;
    PieData pieData_Online;
    PieData pieData_Failure;
    PieData pieData_Planning;
    private int centerNum;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.pie2_station_layout,container,false);
        initView();
        getPieData();
        showChart(pie2_Online, pieData_Online,centerNum);
        showChart(pie2_Failure, pieData_Failure,centerNum);
        showChart(pie2_Planning, pieData_Planning,centerNum);
        return view;
    }
    /*初始化图形*/
    protected void initView() {
        pie2_Online = (PieChart) view.findViewById(R.id.pie2_online);
        pie2_Failure=(PieChart) view.findViewById(R.id.pie2_failure);
        pie2_Planning=(PieChart) view.findViewById(R.id.pie2_planning);
    }
    /*初始化数据*/
    protected void initData() {
        //外
        colors_Online = new ArrayList<Integer>();
        colors_Online.add(Color.rgb(61, 204, 166));
        colors_Online.add(Color.WHITE);
        //内
        colors_Failure = new ArrayList<Integer>();
        colors_Failure.add(Color.rgb(238, 28, 37));
        colors_Failure.add(Color.WHITE);
        //中
        colors_Planning = new ArrayList<Integer>();
        colors_Planning.add(Color.rgb(78, 175, 245));
        colors_Planning.add(Color.WHITE);

        /*传入数据，叶壮写, 再写一个函数*/
        int num1 = graphicdata.getStationonline();
        int num2 = graphicdata.getStationfailure();
        int num3 = graphicdata.getStationplanning();

        list_Online=new ArrayList<>();
        list_Online.add(new PieEntry(num1,""));
        list_Online.add(new PieEntry(num2+num3,""));//空缺（白色）的弧长设置为234-180，234为一周

        list_Planning=new ArrayList<>();
        list_Planning.add(new PieEntry(num3,""));
        list_Planning.add(new PieEntry(num1+num2,""));


        list_Failure=new ArrayList<>();
        list_Failure.add(new PieEntry(num2,""));
        list_Failure.add(new PieEntry(num1+num3,""));

        centerNum = num1+num2+num3; //中心数字也要赋值
        ///////////////////////

    }
    /*
       public void shujvchuanshu(){


      }

      */
    protected void getPieData(){

        initData();

        PieDataSet pieDataSet1=new PieDataSet(list_Online,"Online");
        pieData_Online=new PieData(pieDataSet1);
        pieData_Online.setDrawValues(false);//是否在图上显示数值
        pieDataSet1.setColors(colors_Online);//设置各个数据的颜色
        pieDataSet1.setDrawValues(false);

        PieDataSet pieDataSet2=new PieDataSet(list_Planning,"Planning");
        pieData_Planning=new PieData(pieDataSet2);
        pieData_Planning.setDrawValues(false);//是否在图上显示数值
        pieDataSet2.setColors(colors_Planning);//设置各个数据的颜色
        pieDataSet2.setDrawValues(false);

        PieDataSet pieDataSet3=new PieDataSet(list_Failure,"Failure");
        pieData_Failure=new PieData(pieDataSet3);
        pieData_Failure.setDrawValues(false);//是否在图上显示数值
        pieDataSet3.setColors(colors_Failure);//设置各个数据的颜色
        pieDataSet3.setDrawValues(false);

    }
    /*绘制图形*/
    protected void showChart(PieChart pieChart, PieData pieData,int centerNum) {

        pieChart.setExtraOffsets(0,0,0,0);
        pieChart.setHoleRadius(87f);//设置中间洞大小

        pieChart.setCenterText(String.valueOf(centerNum)); //设置中间文字
        pieChart.setCenterTextTypeface(Typeface.SANS_SERIF);
        pieChart.setCenterTextSize(34f);
        pieChart.setCenterTextOffset(0,-10);//偏移量

        pieChart.getLegend().setEnabled(false);
        pieChart.setTouchEnabled(false);// 禁用与图表的所有可能的触摸交互
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);

        pieChart.animateXY(800, 800);//启用动画


    }

}













