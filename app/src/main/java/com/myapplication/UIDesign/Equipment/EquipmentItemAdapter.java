package com.myapplication.UIDesign.Equipment;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.Equipment.EquipmentItem;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备主界面的Adapter，用来对recyclerview进行设置
 */
public class EquipmentItemAdapter extends RecyclerView.Adapter<EquipmentItemAdapter.ViewHolder>{
    private List<EquipmentItem> equipmentItems=new ArrayList<>();

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

    public EquipmentItemAdapter(List<EquipmentItem> equipmentItems){
        this.equipmentItems=equipmentItems;
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
                EquipmentItem equipmentItem=equipmentItems.get(position);
                Intent intent=new Intent("com.myapplication.UIDesign.BaseStation.BaseStationInfoActivity");//
                intent.putExtra("address",equipmentItem.getName());
                ((Activity) view.getContext()).startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EquipmentItem equipmentItem=equipmentItems.get(position);
        holder.address.setText(equipmentItem.getName());
        holder.operatingStatus.setText(equipmentItem.getOperatingStatus());
        holder.onlineStatus.setText(equipmentItem.getOnlineStatus());
        holder.time.setText(equipmentItem.getTime());

    }

    @Override
    public int getItemCount() {
        return equipmentItems.size();
    }

}
