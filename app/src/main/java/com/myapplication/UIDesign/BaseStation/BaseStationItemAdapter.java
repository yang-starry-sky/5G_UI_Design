package com.myapplication.UIDesign.BaseStation;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 基站主界面的Adapter，用来对recyclerview进行设置
 */
public class BaseStationItemAdapter extends RecyclerView.Adapter<BaseStationItemAdapter.ViewHolder>{
    private List<BaseStationItem> baseStationItems=new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView address;
        TextView deploymentStatus;
        TextView operatingStatus;
        TextView time;

        public ViewHolder(@NonNull View view) {
            super(view);
            itemView=view;
            address=(TextView)view.findViewById(R.id.base_station_address);
            deploymentStatus=(TextView)view.findViewById(R.id.base_station_deploymentStatus);
            operatingStatus=(TextView)view.findViewById(R.id.base_station_operatingStatus);
            time=(TextView)view.findViewById(R.id.base_station_time);
        }
    }

    public BaseStationItemAdapter(List<BaseStationItem> baseStationItems){
        this.baseStationItems=baseStationItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.base_station_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                BaseStationItem baseStationItem=baseStationItems.get(position);
                Intent intent=new Intent("com.myapplication.UIDesign.BaseStation.BaseStationInfoActivity");
                intent.putExtra("address",baseStationItem.getAddress());
                ((Activity) view.getContext()).startActivity(intent);
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView recyclerView=(RecyclerView) parent.findViewById(R.id.base_station_recycler_view);
                int position=viewHolder.getAdapterPosition();
                View itemView = recyclerView .getLayoutManager().findViewByPosition(position);
                Button button=itemView.findViewById(R.id.base_station_deploy);
                if(button.getVisibility()==View.VISIBLE)
                    button.setVisibility(View.GONE);
                else
                    button.setVisibility(View.VISIBLE);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaseStationItem baseStationItem=baseStationItems.get(position);
        holder.address.setText(baseStationItem.getAddress());
        holder.operatingStatus.setText(baseStationItem.getOperatingStatus());
        holder.deploymentStatus.setText(baseStationItem.getDeploymentStatus());
        holder.time.setText(baseStationItem.getTime());

    }

    @Override
    public int getItemCount() {
        return baseStationItems.size();
    }

}
