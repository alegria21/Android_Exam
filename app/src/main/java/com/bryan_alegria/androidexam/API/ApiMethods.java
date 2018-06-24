package com.bryan_alegria.androidexam.API;

import android.content.Context;

import com.bryan_alegria.androidexam.R;

import org.json.JSONObject;

import java.util.HashMap;

public class ApiMethods {
    Context mContext;
    public ApiMethods(Context context) {
        this.mContext = context;
    }
    public JSONObject GetPersons() {
        String result = (new HttpConnection()).httpGetResponse(mContext.getString(R.string.api_url));
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
}
