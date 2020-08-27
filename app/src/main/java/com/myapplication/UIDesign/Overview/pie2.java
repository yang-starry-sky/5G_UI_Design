package com.myapplication.UIDesign.Overview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class pie2 extends Fragment {
    private PieChart pie2;
    private PieChart pie2_failure;
    private PieChart pie2_planning;
    List<PieEntry> list_online;
    List<PieEntry> list_planning;
    List<PieEntry> list_failure;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_pie2,container,false);



        pie2 = (PieChart) view.findViewById(R.id.pie2);
        pie2_planning=(PieChart) view.findViewById(R.id.pie2_planning);
        pie2_failure=(PieChart) view.findViewById(R.id.pie2_failure);
        pie2.setExtraOffsets(0,0,100,0);
        pie2.setHoleRadius(80f);//设置中间洞大小
        pie2_planning.setExtraOffsets(0, 20, 100, 20);//偏移量
        pie2_planning.setHoleRadius(75f);//设置中间洞大小
        pie2_failure.setExtraOffsets(0, 30, 100, 30);//偏移量
        pie2_failure.setHoleRadius(70f);//设置中间洞大小
        pie2_failure.setCenterText("234"+'\n'+"Total"); //设置中间文字
        //pie2.getLegend().setEnabled(false);//取消图例
        pie2_planning.getLegend().setEnabled(false);
        pie2_failure.getLegend().setEnabled(false);


        //  外侧饼图
        list_online=new ArrayList<>();
        list_online.add(new PieEntry(180,""));
        list_online.add(new PieEntry(234-180,""));
        PieDataSet pieDataSet1=new PieDataSet(list_online,"Online");
        PieData pieData1=new PieData(pieDataSet1);
        pie2.setData(pieData1);
        pieDataSet1.setColors(Color.rgb(61, 204, 166),Color.WHITE);//设置各个数据的颜色
        pie2.getDescription().setEnabled(false);
        pieDataSet1.setDrawValues(false);
        //中间饼图
        list_planning=new ArrayList<>();
        list_planning.add(new PieEntry(50,""));
        list_planning.add(new PieEntry(234-50,""));
        PieDataSet pieDataSet2=new PieDataSet(list_planning,"Planning");
        PieData pieData2=new PieData(pieDataSet2);
        pie2_planning.setData(pieData2);
        pieDataSet2.setColors(Color.rgb(78, 175, 245),Color.WHITE);//设置各个数据的颜色
        pie2_planning.getDescription().setEnabled(false);
        pieDataSet2.setDrawValues(false);
        //内侧饼图
        list_failure=new ArrayList<>();
        list_failure.add(new PieEntry(4,""));
        list_failure.add(new PieEntry(234-4,""));
        PieDataSet pieDataSet3=new PieDataSet(list_failure,"Failure");
        PieData pieData3=new PieData(pieDataSet3);
        pie2_failure.setData(pieData3);
        pieDataSet3.setColors(Color.rgb(238, 28, 37),Color.WHITE);//设置各个数据的颜色
        pie2_failure.getDescription().setEnabled(false);
        pieDataSet3.setDrawValues(false);
        //pieDataSet.setColors(Color.RED,Color.BLUE,Color.GREEN);//设置各个数据的颜色

        Legend legend1=pie2.getLegend();
        List<LegendEntry> entries = new ArrayList<>();
        entries.add(new LegendEntry(

                "Online",
                Legend.LegendForm.SQUARE,
                16f,
                0f,
                null,
                Color.rgb(61, 204, 166))
        );

        entries.add(new LegendEntry(

                "Failure",

                Legend.LegendForm.SQUARE,

                16f,

                0f,

                null,

                Color.rgb(238, 28, 37)));

        entries.add(new LegendEntry(

                "Planning",

                Legend.LegendForm.SQUARE,

                16f,

                0f,

                null,

                Color.rgb(78, 175, 245))

        );
        legend1.setCustom(entries);

        legend1.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend1.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend1.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend1.setXEntrySpace(12f);
        legend1.setYEntrySpace(25f);
        legend1.setTextSize(16f);












        return view;
    }
}
