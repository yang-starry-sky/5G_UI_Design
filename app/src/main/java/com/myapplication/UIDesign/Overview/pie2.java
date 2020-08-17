package com.myapplication.UIDesign.Overview;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class pie2 extends AppCompatActivity {
    private PieChart pie2;
    List<PieEntry> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie2);
        pie2 = (PieChart) findViewById(R.id.pie2);
        list=new ArrayList<>();


        list.add(new PieEntry(180,"Online"));
        list.add(new PieEntry(4,"Failure"));
        list.add(new PieEntry(50,"Planning"));

        PieDataSet pieDataSet=new PieDataSet(list,"基站业务状态统计");
        PieData pieData=new PieData(pieDataSet);
        pie2.setData(pieData);

        pieDataSet.setColors(Color.RED,Color.BLUE,Color.GREEN);//设置各个数据的颜色

    }
}