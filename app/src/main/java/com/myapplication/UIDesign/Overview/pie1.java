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

    private PieChart pie1_Online;
    private PieChart pie1_Failure;
    List<PieEntry> list1;
    List<PieEntry> list2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_pie1,container,false);


        pie1_Online = (PieChart) view.findViewById(R.id.pie1_Online);
        pie1_Online.setHoleRadius(80f);//设置中间洞大小
        pie1_Online.setCenterText("970"+"\n"+"Online"); //设置中间文字
        pie1_Online.setExtraOffsets(5, 0, 100,0 );//偏移量
        list1=new ArrayList<>();
        list1.add(new PieEntry(97/2,""));
        list1.add(new PieEntry(100-97/2,""));
        pie1_Online.setRotationAngle(180);
        pie1_Online.getDescription().setEnabled(false); //取消右下角描述
        PieDataSet pieDataSet1=new PieDataSet(list1,"Online");
        PieData pieData1=new PieData(pieDataSet1);
        pieData1.setDrawValues(false);//是否在图上显示数值
        pieDataSet1.setColors(Color.rgb(61, 204, 166),Color.WHITE);//设置各个数据的颜色
        pie1_Online.setData(pieData1);
        pie1_Online.getLegend().setEnabled(false);//取消图例

        pie1_Failure = (PieChart) view.findViewById(R.id.pie1_Failure);
        pie1_Failure.setHoleRadius(80f);//设置中间洞大小
        pie1_Failure.setCenterText("12"+"\n"+"Failure"); //设置中间文字
        pie1_Failure.setExtraOffsets(105, 0, 5,0 );//偏移量
        list2=new ArrayList<>();
        list2.add(new PieEntry(12/2,""));
        list2.add(new PieEntry(100-12/2,""));
        pie1_Failure.setRotationAngle(180);
        pie1_Failure.getDescription().setEnabled(false); //取消右下角描述
        PieDataSet pieDataSet2=new PieDataSet(list2,"Failure");
        PieData pieData2=new PieData(pieDataSet2);
        pieData2.setDrawValues(false);//是否在图上显示数值
        pieDataSet2.setColors(Color.rgb(238, 28, 37),Color.WHITE);//设置各个数据的颜色
        pie1_Failure.setData(pieData2);
        pie1_Failure.getLegend().setEnabled(false);





        return view;
    }
}

