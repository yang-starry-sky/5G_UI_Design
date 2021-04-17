package com.myapplication.UIDesign.Overview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Typeface;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.myapplication.UIDesign.R;

import static com.myapplication.UIDesign.MainActivity.graphicdata;
import java.util.ArrayList;
import java.util.List;

public class pie1_Online extends Fragment {

    private PieChart pie1_Online;
    private List<PieEntry> list;
    private PieData pieData;
    private View view;
    private ArrayList<Integer> colors;
    private int centerNum;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.pie1_online_layout,container,false);
        initView();
        pieData = getPieData();
        showChart(pie1_Online, pieData,centerNum);
        return view;
    }
    /*初始化图形*/
    protected void initView() {
        pie1_Online = (PieChart) view.findViewById(R.id.pie1_Online);
    }
    /*初始化数据*/
    protected void initData() {
        colors = new ArrayList<Integer>();
        colors.add(Color.rgb(61, 204, 166));
        colors.add(Color.rgb(240,242,245));
        colors.add(Color.WHITE);


        int num1 = graphicdata.getEquipmentonline();
        int num2 = graphicdata.getEquipmentfailure();
        int neernum1 = num1;
        int neernum2 = num2;
        int neertotal = num1+num2;
        if(49*num1<num2) {
            neernum1 = 1;
            neernum2 = 49;
        }
        if(49*num2<num1)
        {
            neernum1 = 49;
            neernum2 = 1;
        }
        if(num1==0)
        {
            neernum1 = 0;
        }
        if(num2==0)
        {
            neernum2 = 0;
        }

        if(neernum1+neernum2==0)
            neertotal = 1;
        else
            neertotal = neernum1+neernum2;

        list=new ArrayList<PieEntry>();

        list.add(new PieEntry(50*neernum1/neertotal,""));//弧长，因半圆，设置为Failure数值
        list.add(new PieEntry(50*neernum2/neertotal,""));
        list.add(new PieEntry(50,""));
        centerNum = num1; //中心数字也要赋值
        ///////////////////////

    }

    protected PieData getPieData(){
        initData();
        PieDataSet pieDataSet=new PieDataSet(list,"Online");  //通过list1输入数据
        pieDataSet.setColors(colors);
        pieData = new PieData(pieDataSet);
        pieData.setDrawValues(false);//是否在图上显示数值
        return pieData;
    }
    /*绘制图形*/
    protected void showChart(PieChart pieChart, PieData pieData,int centerNum) {

        pieChart.setHoleRadius(87f);//设置中间洞大小

        pieChart.setCenterText(String.valueOf(centerNum)); //设置中间文字，online数值

        pieChart.setCenterTextSize(34f);//设置中间文字大小
        pieChart.setCenterTextTypeface(Typeface.SANS_SERIF);
        pieChart.setCenterTextOffset(0,0);//设置文字偏移量
        pieChart.getLegend().setEnabled(false);//取消图例
        pieChart.setExtraOffsets(0, 0, 0,0 );//偏移量
        pieChart.setTouchEnabled(false);// 禁用与图表的所有可能的触摸交互
        /*启用动画*/
        pieChart.animateXY(800, 800);

        pieChart.setRotationAngle(180);
        pieChart.getDescription().setEnabled(false); //取消右下角描述

        pieChart.setData(pieData);
    }

}

