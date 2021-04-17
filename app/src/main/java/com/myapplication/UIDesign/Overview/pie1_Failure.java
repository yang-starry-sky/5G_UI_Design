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

public class pie1_Failure extends pie1_Online {

    private PieChart pie1_Failure;
    private List<PieEntry> list;
    private PieData pieData;
    private View view;
    private ArrayList<Integer> colors;
    private int centerNum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pie1_failure_layout, container, false);
        initView();
        pieData = getPieData();
        super.showChart(pie1_Failure, pieData,centerNum);
        return view;
    }
    @Override
    protected void initView() {
        pie1_Failure = (PieChart) view.findViewById(R.id.pie1_Failure);
    }
    @Override
    protected PieData getPieData(){
        initData();
        PieDataSet pieDataSet=new PieDataSet(list,"Failure");  //通过list1输入数据
        pieDataSet.setColors(colors);
        pieData = new PieData(pieDataSet);
        pieData.setDrawValues(false);//是否在图上显示数值
        return pieData;
    }
    @Override
     protected void initData() {
        colors = new ArrayList<Integer>();
        colors.add(Color.rgb(238, 28, 37));
        colors.add(Color.rgb(240,242,245));
        colors.add(Color.WHITE);

        ////////

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

        list.add(new PieEntry(50*neernum2/neertotal,""));//弧长，因半圆，设置为Failure数值
          list.add(new PieEntry(50*neernum1/neertotal,""));
          list.add(new PieEntry(50,""));
          centerNum = num2;

    }






}

