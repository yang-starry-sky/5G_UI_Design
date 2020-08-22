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
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class pie1 extends Fragment {

    private PieChart pie1;
    List<PieEntry> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_pie1,container,false);


        pie1 = (PieChart) view.findViewById(R.id.pie1);
        pie1.setHoleRadius(60f);//设置中间洞大小
        pie1.setCenterText("970"); //设置中间文字
        pie1.setExtraOffsets(20, 8, 75, 8);//偏移量
        list=new ArrayList<>();
        list.add(new PieEntry(97/2,""));
        list.add(new PieEntry(100-97/2,""));
        pie1.setRotationAngle(180);
        pie1.getDescription().setEnabled(false); //取消右下角描述
        PieDataSet pieDataSet=new PieDataSet(list,"Online");
        PieData pieData=new PieData(pieDataSet);
        pieData.setDrawValues(false);//是否在图上显示数值
        pieDataSet.setColors(Color.rgb(61, 204, 166),Color.WHITE);//设置各个数据的颜色
        pie1.setData(pieData);



        return view;
    }
}
