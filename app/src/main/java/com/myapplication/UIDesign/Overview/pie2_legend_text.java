package com.myapplication.UIDesign.Overview;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import static com.myapplication.UIDesign.MainActivity.graphicdata;
import androidx.fragment.app.Fragment;

import com.myapplication.UIDesign.R;

public class pie2_legend_text extends Fragment {
    private TextView text_online;
    private TextView text_failure;
    private TextView text_planning;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.pie2_legend_layout,container,false);
        init();
        /*数据传入*/
        int num1 = graphicdata.getStationonline();
        int num2 = graphicdata.getStationfailure();
        int num3 = graphicdata.getStationplanning();
        setData(num1,num2,num3);
        return view;
    }
    private void init()
    {
        text_online = (TextView) view.findViewById (R.id.online_num);
        text_failure = (TextView) view.findViewById (R.id.failure_num);
        text_planning = (TextView) view.findViewById (R.id.planning_num);
    }
    /*设置数据接口*/
    private void setData(int online,int failure,int planning)
    {
        text_online.setTypeface(Typeface.SANS_SERIF);
        text_online.setText(String.valueOf(online));
        text_failure.setTypeface(Typeface.SANS_SERIF);
        text_failure.setText(String.valueOf(failure));
        text_planning.setTypeface(Typeface.SANS_SERIF);
        text_planning.setText(String.valueOf(planning));
    }
}
