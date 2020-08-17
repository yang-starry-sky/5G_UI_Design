package com.myapplication.UIDesign.Overview;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class zhutu extends AppCompatActivity {

    private HorizontalBarChart barHor;

    List<BarEntry> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhutu);
        barHor = (HorizontalBarChart) findViewById(R.id.bar_hor);

        list.add(new BarEntry(1,85));
        list.add(new BarEntry(2,72));
        list.add(new BarEntry(3,65));
        list.add(new BarEntry(4,42));
        list.add(new BarEntry(5,15));

        BarDataSet barDataSet=new BarDataSet(list,"资源池利用率统计");
        BarData barData=new BarData(barDataSet);
        barHor.setData(barData);

        barHor.getDescription().setEnabled(false);//隐藏右下角英文
        barHor.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//X轴的位置 默认为右边
        barHor.getAxisLeft().setEnabled(false);//隐藏上侧Y轴   默认是上下两侧都有Y轴
    }
}
