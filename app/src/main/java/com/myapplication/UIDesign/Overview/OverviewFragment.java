package com.myapplication.UIDesign.Overview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.myapplication.UIDesign.R;

public class OverviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_overview,container,false);
        Button button1 = (Button) view.findViewById(R.id.button_1);
        Button button2 = (Button) view.findViewById(R.id.button_2);
        Button button3 = (Button) view.findViewById(R.id.button_3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.myapplication.UIDesign.Overview.pie1");
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.myapplication.UIDesign.Overview.pie2");
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.myapplication.UIDesign.Overview.zhutu");
                startActivity(intent);
            }
        });
        return view;
    }
}
