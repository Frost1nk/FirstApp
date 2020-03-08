package com.production.firstapp.models;

import org.json.JSONObject;

public class Model {
    private JSONObject mJsonObject;

    public String getName() {
        return mJsonObject.optString("name");
    }

    public String getType() {
        return mJsonObject.optString("type");
    }
}
