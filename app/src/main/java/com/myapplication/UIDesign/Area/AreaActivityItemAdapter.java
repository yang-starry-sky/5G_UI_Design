package com.myapplication.UIDesign.Area;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.BaseStation.BaseStationItemAdapter;
import com.myapplication.UIDesign.R;

import java.util.List;

public class AreaActivityItemAdapter extends RecyclerView.Adapter<AreaActivityItemAdapter.ViewHolder> {
    //配置area_fragment中的信息

    private List<AreaActivityItem> mAreaActivityItemList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView areaTitle;
        TextView modificationTime;
        TextView creator;
        TextView description;

        public ViewHolder(View view){
            super(view);
            itemView=view;
            areaTitle=(TextView)view.findViewById(R.id.area_areaTitle);
            modificationTime=(TextView)view.findViewById(R.id.area_modification_time);
            creator=(TextView)view.findViewById(R.id.area_creator);
            description=(TextView)view.findViewById(R.id.area_description);
        }
    }

    public AreaActivityItemAdapter (List<AreaActivityItem> areaActivityItemList){
        mAreaActivityItemList = areaActivityItemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.area1_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.areaTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                AreaActivityItem areaActivityItem=mAreaActivityItemList.get(position);
                Intent intent=new Intent("com.myapplication.UIDesign.Area.Area_Details");
                intent.addCategory("com.myapplication.UIDesign.Area.Area_Details.MY_CATEGORY");

                intent.putExtra("areaTitle",areaActivityItem.getAreaTitle());
                ((Activity) view.getContext()).startActivity(intent);
            }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AreaActivityItem areaActivityItem=mAreaActivityItemList.get(position);
        holder.areaTitle.setText(areaActivityItem.getAreaTitle());
        holder.modificationTime.setText(areaActivityItem.getModificationTime());
        holder.creator.setText(areaActivityItem.getCreator());
        holder.description.setText(areaActivityItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mAreaActivityItemList.size();
    }


}
