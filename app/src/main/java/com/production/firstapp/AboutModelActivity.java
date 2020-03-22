package com.production.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.production.firstapp.models.Model;
import com.production.firstapp.models.SerializableJson;

public class AboutModelActivity extends AppCompatActivity {

    private Model model;

    private TextView labelName;
    private TextView labelShow;
    private TextView labelDownload;
    private TextView labelFavorite;

    private ImageView imagePreview;

    private Button btnSaveGallery;
    private Button btnSaveMCPE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_model);

        SerializableJson serializableJson = getIntent().getParcelableExtra("json");
        if(serializableJson == null)
            finish();
            model = new Model(serializableJson.getJsonObject());
            labelName = findViewById(R.id.labelName);
            labelShow = findViewById(R.id.labelShow);
            labelDownload = findViewById(R.id.labelDownload);
            labelFavorite = findViewById(R.id.labelFavorite);

            imagePreview = findViewById(R.id.imagePreview);

            btnSaveGallery = findViewById(R.id.btnSaveGallery);
            btnSaveMCPE = findViewById(R.id.btnSaveMinecraft);
    }
}
