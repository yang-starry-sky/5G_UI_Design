package com.myapplication.UIDesign.Equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.myapplication.UIDesign.R;

/**
 * 类名：EquipmentActivity
 * 功能：用于处理"接入设备"的Activity,主要实现接入设备信息的展示
 * 备注：此版本只能实现三个设备的展示
 */


public class EquipmentActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        Equipment equip1, equip2, equip3;
        Button equip1_button, equip2_button, equip3_button;
        TextView equip1_text, equip2_text, equip3_text;

        //以下三个Equipment类对应要显示的三个设备，使用构造函数初始化
        equip1 = new Equipment("ConcertHall-Ring_CSG1", "Failure", "Normal", "2020-04-12 20:55:21");
        equip2 = new Equipment("ConcertHall-Ring_CSG3", "Online", "Warning", "2020-04-12 20:55:21");
        equip3 = new Equipment("ConcertHall-Ring_CSG4", "Planning", "Unknown", "2020-04-12 20:55:21");

        //对于每一个设备，用一个Button显示名称(以实现点击功能)，用一个TextView显示其他信息
        equip1_text = (TextView) findViewById(R.id.equipment_text1);
        equip2_text = (TextView) findViewById(R.id.equipment_text2);
        equip3_text = (TextView) findViewById(R.id.equipment_text3);
        equip1_button = (Button) findViewById(R.id.equipment_button1);
        equip2_button = (Button) findViewById(R.id.equipment_button2);
        equip3_button = (Button) findViewById(R.id.equipment_button3);

        //设置每个组件的文本,其余设置见布局文件
        equip1_button.setText(equip1.getName());
        equip1_text.setText(equip1.toString());

        equip2_button.setText(equip2.getName());
        equip2_text.setText(equip2.toString());

        equip3_button.setText(equip3.getName());
        equip3_text.setText(equip3.toString());

        this.setTitle(getClass().getSimpleName());
    }
}
