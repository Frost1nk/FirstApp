package com.production.firstapp.models;

import org.json.JSONObject;

class Model {
    private JSONObject mJsonObject;

    public String getName(){
        return mJsonObject.optString("name");
    }
}
