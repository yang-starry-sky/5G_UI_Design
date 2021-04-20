package com.myapplication.UIDesign.Equipment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.Database.Area;
import com.myapplication.UIDesign.Database.Equipment;
//import com.myapplication.UIDesign.Equipment.EquipmentItem;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备主界面的Adapter，
 * 使用recyclerview实现设备界面显示数量的动态改变
 * 可进行拓展
 */
public class EquipmentItemAdapter extends RecyclerView.Adapter<EquipmentItemAdapter.ViewHolder>{
    private List<Equipment> equipmentItems;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView address;
        TextView onlineStatus;
        TextView operatingStatus;
        TextView time;

        public ViewHolder(@NonNull View view) {
            super(view);
            itemView=view;
            address=(TextView)view.findViewById(R.id.equipment_name);
            onlineStatus=(TextView)view.findViewById(R.id.equipment_onlineStatus);
            operatingStatus=(TextView)view.findViewById(R.id.equipment_operatingStatus);
            time=(TextView)view.findViewById(R.id.equipment_time);
        }
    }

    public EquipmentItemAdapter(List<Equipment> equipmentItems){
        this.equipmentItems=equipmentItems;
    }
    public void setmEquipmentItemList(List<Equipment> mEquipmentItemList){
        this.equipmentItems= mEquipmentItemList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.equipment_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                Equipment equipmentItem=equipmentItems.get(position);
                Intent intent=new Intent("com.myapplication.UIDesign.BaseStation.BaseStationInfoActivity");//
                intent.putExtra("address",equipmentItem.getName());
                ((Activity) view.getContext()).startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Equipment equipmentItem;
//                equipmentItem=equipmentItems.get(position);
        holder.address.setText(equipmentItems.get(position).getName());
        holder.address.setTextColor(Color.BLACK);
        holder.operatingStatus.setText(equipmentItems.get(position).getOperatingStatus());
        holder.operatingStatus.setTextColor(Color.BLACK);
        holder.onlineStatus.setText(equipmentItems.get(position).getOnlineStatus());
        holder.onlineStatus.setTextColor(Color.BLACK);
        holder.time.setText(equipmentItems.get(position).getTime());
        holder.time.setTextColor(Color.BLACK);

    }

    @Override
    public int getItemCount() {
        return equipmentItems.size();
    }

}
