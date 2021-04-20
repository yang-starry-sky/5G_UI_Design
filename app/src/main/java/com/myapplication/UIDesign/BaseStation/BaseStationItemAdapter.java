package com.myapplication.UIDesign.BaseStation;

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

import com.myapplication.UIDesign.Database.Area;
import com.myapplication.UIDesign.Database.BaseStation;
import com.myapplication.UIDesign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 基站主界面的Adapter，用来对recyclerview进行设置
 */
public class BaseStationItemAdapter extends RecyclerView.Adapter<BaseStationItemAdapter.ViewHolder>{
    private List<BaseStation> mbaseStationItems;

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

    public BaseStationItemAdapter(List<BaseStation> baseStationItems){
        mbaseStationItems=baseStationItems;
    }

    public void setmBaseStationItemList(List<BaseStation> mBaseStationItemList) {
        this.mbaseStationItems = mBaseStationItemList;
        this.notifyDataSetChanged();
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
                BaseStation baseStationItem=mbaseStationItems.get(position);
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
        BaseStation baseStationItem=mbaseStationItems.get(position);
        holder.address.setText(baseStationItem.getAddress());
        holder.address.setTextColor(Color.BLACK);
        holder.operatingStatus.setText(baseStationItem.getOperatingStatus());
        holder.operatingStatus.setTextColor(Color.BLACK);
        holder.deploymentStatus.setText(baseStationItem.getDeploymentStatus());
        holder.deploymentStatus.setTextColor(Color.BLACK);
        holder.time.setText(baseStationItem.getTime());
        holder.time.setTextColor(Color.BLACK);
        String deploymentStatu=baseStationItem.getDeploymentStatus();
        if(deploymentStatu.equals("部署状态   Failure"))
            holder.deploymentStatus.setTextColor(Color.parseColor("#ee1c25"));
        else if(deploymentStatu.equals("部署状态   Online"))
            holder.deploymentStatus.setTextColor(Color.parseColor("#3DCCA6"));
        else if(deploymentStatu.equals("部署状态   Planning"))
            holder.deploymentStatus.setTextColor(Color.BLUE);

        String operatingStatu=baseStationItem.getOperatingStatus();
        if(operatingStatu.equals("运行状态   Failure"))
            holder.operatingStatus.setTextColor(Color.parseColor("#ee1c25"));
        else if(operatingStatu.equals("运行状态   Normal"))
            holder.operatingStatus.setTextColor(Color.parseColor("#3DCCA6"));
        else if(operatingStatu.equals("运行状态   Waiting"))
            holder.operatingStatus.setTextColor(Color.YELLOW);
        System.out.println(deploymentStatu+" "+operatingStatu);

    }

    @Override
    public int getItemCount() {
        return mbaseStationItems.size();
    }

}
