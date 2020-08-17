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

public class pie1 extends AppCompatActivity {
    private PieChart pie1;
    List<PieEntry> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie1);
        pie1 = (PieChart) findViewById(R.id.pie1);
        list=new ArrayList<>();


        list.add(new PieEntry(970,"Online"));
        list.add(new PieEntry(12,"Failure"));

        PieDataSet pieDataSet=new PieDataSet(list,"接入设备上线状态统计");
        PieData pieData=new PieData(pieDataSet);
        pie1.setData(pieData);

        pieDataSet.setColors(Color.RED,Color.BLUE);//设置各个数据的颜色

    }
}
