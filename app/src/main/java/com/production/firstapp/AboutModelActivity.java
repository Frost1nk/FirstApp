package com.production.firstapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.production.firstapp.models.Model;
import com.production.firstapp.models.SerializableJson;

public class AboutModelActivity extends AppCompatActivity {

    private Model model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_about_model);

        SerializableJson serializableJson = getIntent().getParcelableExtra("file");
        if(serializableJson == null){
            finish();
            model = new Model(serializableJson.getJsonObject());
        }
    }
}
