package com.production.firstapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class SerializableJson implements Parcelable {

    private JSONObject mJsonObject;

    public SerializableJson(JSONObject jsonObject){
        mJsonObject = jsonObject;
    }

    public SerializableJson(Parcel in) {
        String jsonString = in.readString();
        try {
            mJsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
            mJsonObject = new JSONObject();
        }
    }


    public static final Creator<SerializableJson> CREATOR = new Creator<SerializableJson>() {
        @Override
        public SerializableJson createFromParcel(Parcel in) {
            return new SerializableJson(in);
        }

        @Override
        public SerializableJson[] newArray(int size) {
            return new SerializableJson[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mJsonObject.toString());
    }

    public JSONObject getJsonObject(){
        return mJsonObject;
    }
}
