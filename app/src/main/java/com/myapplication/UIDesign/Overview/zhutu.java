package com.myapplication.UIDesign.Overview;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class zhutu extends Fragment {

    private HorizontalBarChart barHor;
    List<BarEntry> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_zhutu,container,false);


        barHor = (HorizontalBarChart) view.findViewById(R.id.bar_hor);
        barHor.setDrawGridBackground(false);//不显示图表网格
        barHor.setDrawBorders(false);//不显示边框
        barHor.setExtraOffsets(20, 20, 20, 20);
        list.add(new BarEntry(5,85));
        list.add(new BarEntry(4,72));
        list.add(new BarEntry(3,65));
        list.add(new BarEntry(2,42));
        list.add(new BarEntry(1,15));
        BarDataSet barDataSet=new BarDataSet(list,"资源池利用率统计");
        barDataSet.setColors(Color.rgb(255, 187, 51),Color.rgb(61, 204, 166),Color.rgb(61, 204, 166),Color.rgb(61, 204, 166),Color.rgb(61, 204, 166));
        //设置颜色
        barDataSet.setDrawValues(true);
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.5f);
        barHor.setData(barData);
        barHor.getDescription().setEnabled(false);//隐藏右下角英文
        barHor.getXAxis().setDrawGridLines(false);//隐藏X轴
        barHor.getXAxis().setAxisLineColor(Color.WHITE);
        barHor.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//设置位置
        barHor.getXAxis().setLabelCount(5);
        // final String labelName[] = {"南京EMBB", "常州EMBB", "无锡EMBB", "南京IPTV","常州IPTV" };
        //  barHor.getXAxis().setValueFormatter();
        //barHor.getXAxis().setYOffset();
        barHor.getAxisLeft().setDrawGridLines(false);//隐藏上侧Y轴   默认是上下两侧都有Y轴
        barHor.getAxisLeft().setDrawLabels(false);//隐藏上Y轴文字
        barHor.getAxisLeft().setAxisLineColor(Color.WHITE);
        barHor.getAxisRight().setDrawGridLines(false);//隐藏Y格线
        barHor.getAxisRight().setAxisLineColor(Color.WHITE);//隐藏上下y轴
        barHor.getAxisRight().setDrawLabels(false);//隐藏下Y轴文字


        return view;
    }
}
