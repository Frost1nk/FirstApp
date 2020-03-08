package com.production.firstapp.models;

import org.json.JSONObject;

public class Model {

    private JSONObject mJsonObject;

    public Model(JSONObject jsonObject) {
        this.mJsonObject = jsonObject;
    }

    public String getName() {
        return mJsonObject.optString("name");
    }

    public String getType() {
        return mJsonObject.optString("type");
    }

    public String getImageLink(){
        return mJsonObject.optString("imageLink");
    }
}
