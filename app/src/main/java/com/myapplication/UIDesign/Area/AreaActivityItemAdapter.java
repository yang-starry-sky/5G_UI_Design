package com.myapplication.UIDesign.Area;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.UIDesign.BaseStation.BaseStationItem;
import com.myapplication.UIDesign.BaseStation.BaseStationItemAdapter;
import com.myapplication.UIDesign.R;

import java.util.List;

public class AreaActivityItemAdapter extends RecyclerView.Adapter<AreaActivityItemAdapter.ViewHolder> {

    private List<AreaActivityItem> mAreaActivityItemList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        Button firstCharBackground;
        TextView areaTitle;
        TextView modificationTime;
        TextView creator;
        TextView description;

        public ViewHolder(View view){
            super(view);
            itemView=view;
            firstCharBackground = (Button)view.findViewById(R.id.area_firstcharbackgroud_button);
            areaTitle=(TextView)view.findViewById(R.id.area_areaTitle_value);
            modificationTime=(TextView)view.findViewById(R.id.area_modification_time_value);
            creator=(TextView)view.findViewById(R.id.area_creator_value);
            description=(TextView)view.findViewById(R.id.area_description_value);
        }
    }

    public AreaActivityItemAdapter (List<AreaActivityItem> areaActivityItemList){
        mAreaActivityItemList = areaActivityItemList;
    }

    public void setmAreaActivityItemList(List<AreaActivityItem> mAreaActivityItemList) {
        this.mAreaActivityItemList = mAreaActivityItemList;
        this.notifyDataSetChanged();
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
        holder.firstCharBackground.setText(areaActivityItem.getFirstchar());
        holder.modificationTime.setText(areaActivityItem.getModificationTime());
        holder.creator.setText(areaActivityItem.getCreator());
        holder.description.setText(areaActivityItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mAreaActivityItemList.size();
    }


}
