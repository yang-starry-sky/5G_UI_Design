package com.myapplication.UIDesign.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.myapplication.UIDesign.Database.Area;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    public static boolean handleAreaResponse(String response) {
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allArea = new JSONArray(response);
                for(int i = 0; i < allArea.length(); i++){
                    JSONObject areaObject = allArea.getJSONObject(i);
                    Area area = new Area();
                    area.setFirstchar(areaObject.getString("firstchar"));
                    area.setAreaTitle(areaObject.getString("areaTitle"));
                    area.setModificationTime(areaObject.getString("modificationTime"));
                    area.setCreator(areaObject.getString("creator"));
                    area.setDescription(areaObject.getString("description"));
                    area.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }


    public static boolean netWorkCheck(Context context){
        ConnectivityManager cm =  (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if( info != null ){
            return info.isConnected();
        } else {
            return false;
        }
    }
}
