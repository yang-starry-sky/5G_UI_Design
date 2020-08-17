package com.myapplication.UIDesign.Equipment;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

public class EquipmentItemAdapter extends RecyclerView.Adapter<com.myapplication.UIDesign.Equipment.EquipmentItemAdapter.ViewHolder>{
    private List<EquipmentItem> equipmentItems=new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView name;
        TextView onlineStatus;
        TextView operatingStatus;
        TextView time;

        public ViewHolder(@NonNull View view) {
            super(view);
            itemView=view;
            name=(TextView)view.findViewById(R.id.equipment_name);
            onlineStatus=(TextView)view.findViewById(R.id.equipment_onlineStatus);
            operatingStatus=(TextView)view.findViewById(R.id.equipment_operatingStatus);
            time=(TextView)view.findViewById(R.id.equipment_time);
        }
    }

    public EquipmentItemAdapter(List<EquipmentItem> equipmentItemsItems){
        this.equipmentItems=equipmentItems;
    }

    @NonNull
    @Override
    public com.myapplication.UIDesign.Equipment.EquipmentItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.equipment_item,parent,false);
        final com.myapplication.UIDesign.Equipment.EquipmentItemAdapter.ViewHolder viewHolder=new com.myapplication.UIDesign.Equipment.EquipmentItemAdapter.ViewHolder(view);
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                EquipmentItem equipmentItem=equipmentItems.get(position);
                Intent intent=new Intent("com.myapplication.UIDesign.Equipment.EquipmentInfoActivity");
                intent.putExtra("name",equipmentItem.getName());
                ((Activity) view.getContext()).startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.myapplication.UIDesign.Equipment.EquipmentItemAdapter.ViewHolder holder, int position) {
        EquipmentItem equipmentItem=equipmentItems.get(position);
        holder.name.setText(equipmentItem.getName());
        holder.operatingStatus.setText(equipmentItem.getOperatingStatus());
        holder.onlineStatus.setText(equipmentItem.getOnlineStatus());
        holder.time.setText(equipmentItem.getTime());

    }

    @Override
    public int getItemCount() {
        return equipmentItems.size();
    }

}
