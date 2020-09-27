package com.myapplication.UIDesign.Overview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.text.DecimalFormat;
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
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.github.mikephil.charting.formatter.IValueFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MyValueFormatter implements IValueFormatter {
    private DecimalFormat mFormat;

    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,##0.0"); // 使用一个小数
    }
    @Override
    public String getFormattedValue(float v, com.github.mikephil.charting.data.Entry entry, int i, ViewPortHandler viewPortHandler) {
        return mFormat.format(i) + "%";
    }
}

public class zhutu extends Fragment {

    private HorizontalBarChart barHor;
    List<BarEntry> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_zhutu,container,false);

        barHor = (HorizontalBarChart) view.findViewById(R.id.bar_hor);
        barHor.setExtraOffsets(5, 20, 20, 20);
        list.add(new BarEntry(5f,85f));   //柱条长度（横向）
        list.add(new BarEntry(4f,72f));
        list.add(new BarEntry(3f,65f));
        list.add(new BarEntry(2f,42f));
        list.add(new BarEntry(1f,15f));
        BarDataSet barDataSet=new BarDataSet(list,"资源池利用率统计");
        barDataSet.setColors(Color.rgb(255, 187, 51),Color.rgb(61, 204, 166),Color.rgb(61, 204, 166),Color.rgb(61, 204, 166),Color.rgb(61, 204, 166));
        //设置颜色

        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.6f); //设置宽度

        barDataSet.setDrawValues(true);
        barDataSet.setValueTextColor(Color.RED);
        barDataSet.setValueTextSize(14f);
        //barDataSet.setValueFormatter(new MyValueFormatter());

        barHor.setData(barData);
        barHor.getDescription().setEnabled(false);//隐藏右下角英文
        barHor.getXAxis().setDrawGridLines(false);//隐藏X轴
        barHor.getXAxis().setAxisLineColor(Color.WHITE);
        barHor.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//设置位置
        barHor.getXAxis().setDrawLabels(false);//隐藏上X轴文字
        barHor.getAxisLeft().setDrawGridLines(false);//隐藏上侧Y轴   默认是上下两侧都有Y轴
        barHor.getAxisLeft().setDrawLabels(false);//隐藏上Y轴文字
        barHor.getAxisLeft().setAxisLineColor(Color.WHITE);
        barHor.getAxisRight().setDrawGridLines(false);//隐藏Y格线
        barHor.getAxisRight().setAxisLineColor(Color.WHITE);//隐藏下y轴
        barHor.getAxisRight().setDrawLabels(false);//隐藏下Y轴文字
        //自定义图例
        Legend legend1=barHor.getLegend();
        List<LegendEntry> entries = new ArrayList<>();
        entries.add(new LegendEntry(
                "南京EMBB",  //地区标签
                Legend.LegendForm.NONE,
                16f,
                0f,
                null,
                Color.rgb(61, 204, 166))
        );
        entries.add(new LegendEntry(
                "常州EMBB",
                Legend.LegendForm.NONE,
                16f,
                0f,
                null,
                Color.rgb(238, 28, 37)));
        entries.add(new LegendEntry(
                "无锡EMBB",
                Legend.LegendForm.NONE,
                16f,
                0f,
                null,
                Color.rgb(78, 175, 245)));
        entries.add(new LegendEntry(
                "南京IPTV",
                Legend.LegendForm.NONE,
                16f,
                0f,
                null,
                Color.rgb(78, 175, 245)));
        entries.add(new LegendEntry(
                "常州IPTV",
                Legend.LegendForm.NONE,
                16f,
                0f,
                null,
                Color.rgb(78, 175, 245)));


        legend1.setCustom(entries);
        legend1.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend1.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend1.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend1.setXEntrySpace(10f);
        legend1.setYEntrySpace(18f);
        legend1.setTextSize(10f);


        return view;
    }
}
