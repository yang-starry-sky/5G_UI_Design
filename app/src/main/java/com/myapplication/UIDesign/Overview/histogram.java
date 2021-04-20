package com.myapplication.UIDesign.Overview;


import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.myapplication.UIDesign.Database.Graph;
import com.myapplication.UIDesign.R;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.github.mikephil.charting.formatter.IValueFormatter;
import java.util.ArrayList;
import java.util.List;
import com.github.mikephil.charting.data.Entry;

import org.litepal.crud.DataSupport;

import static android.content.ContentValues.TAG;

import static com.myapplication.UIDesign.MainActivity.graphicdata;


class myValueFormatter implements IValueFormatter {

    @Override
    public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
        if(Math.abs(v - 100.001) <0.0001) return "";
        return (int)v + "%";
    }
}

public class histogram extends Fragment {

//    Graph graphicdata = DataSupport.findAll(Graph.class).get(0);


    private HorizontalBarChart barHor;
    private View view;
    private List<BarEntry> list;
    private List<BarEntry> listBack;
    private ArrayList<Integer> colors;
    private BarData barData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.e(TAG, "onCreateView: !!!" + graphicdata );
        view = inflater.inflate(R.layout.histogram_layout,container,false);
        initView();
        barData = getbarData();
        showChart(barHor, barData);
        return view;
    }
    private void initView() {
        barHor = (HorizontalBarChart) view.findViewById(R.id.bar_hor);
    }
    private void initData() {
        colors = new ArrayList<Integer>();
        colors.add(Color.rgb(255, 187, 51));
        colors.add(Color.rgb(61, 204, 166));
        colors.add(Color.rgb(61, 204, 166));
        colors.add(Color.rgb(61, 204, 166));
        colors.add(Color.rgb(61, 204, 166));
        /*背景,不需更改*/
        listBack=new ArrayList<BarEntry>();
        listBack.add(new BarEntry(5f,100.001f));
        listBack.add(new BarEntry(4f,100.001f));
        listBack.add(new BarEntry(3f,100.001f));
        listBack.add(new BarEntry(2f,100.001f));
        listBack.add(new BarEntry(1f,100.001f));



        list=new ArrayList<BarEntry>();
        list.add(new BarEntry(5,graphicdata.getPercent1()));
        list.add(new BarEntry(4,graphicdata.getPercent2()));
        list.add(new BarEntry(3,graphicdata.getPercent3()));
        list.add(new BarEntry(2,graphicdata.getPercent4()));
        list.add(new BarEntry(1,graphicdata.getPercent5()));


        ///////////////////////

    }

  protected BarData getbarData(){
      initData();
      BarDataSet barDataSetBack=new BarDataSet(listBack,"");
      barDataSetBack.setColor(Color.rgb(240,242,245));


      BarDataSet barDataSet=new BarDataSet(list,"资源池利用率统计");
      barDataSet.setColors(colors);
      barData=new BarData(barDataSetBack);
      barData.addDataSet(barDataSet);

      barData.setBarWidth(0.5f); //设置宽度
      barData.setValueFormatter(new myValueFormatter());
      barDataSet.setDrawValues(true);
      barDataSet.setValueTextSize(20f);
      barDataSet.setValueTypeface(Typeface.SANS_SERIF);


      return barData;
  }

    private void showChart(HorizontalBarChart barHor, BarData barData) {
        barHor.setExtraOffsets(0, 0, 0, 0);//柱条长度（横向）
        barHor.setData(barData);
        barHor.setDrawValueAboveBar(true);


        barHor.getAxisLeft().setAxisMinimum(0);//必须要设置这个才会显示
        barHor.getXAxis().setDrawGridLines(false);//隐藏X轴
        barHor.getXAxis().setDrawAxisLine(false);
        barHor.getXAxis().setDrawLabels(false);//隐藏上X轴文字
        barHor.getAxisLeft().setDrawGridLines(false);//隐藏上侧Y轴   默认是上下两侧都有Y轴
        barHor.getAxisLeft().setDrawLabels(false);//隐藏上Y轴文字
        barHor.getAxisLeft().setDrawAxisLine(false);
        barHor.getAxisRight().setDrawGridLines(false);//隐藏Y格线
        barHor.getAxisRight().setDrawAxisLine(false);;//隐藏下y轴
        barHor.getAxisRight().setDrawLabels(false);//隐藏下Y轴文字
        barHor.setTouchEnabled(false);// 禁用与图表的所有可能的触摸交互
        barHor.getDescription().setEnabled(false);//隐藏右下角英文
        barHor.getLegend().setEnabled(false);
        barHor.animateXY(800,800);
    }
}
