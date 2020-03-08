package com.production.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.production.firstapp.adapters.AdapterRecycleView;
import com.production.firstapp.models.Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnMoreApps;
    private RecyclerView mRecycleView;
    private AdapterRecycleView mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoreApps.findViewById(R.id.btnMoreApps);
        mRecycleView.findViewById(R.id.recycleView);

        mAdapter = new AdapterRecycleView(this,new ArrayList<Model>());
        mRecycleView.setLayoutManager(new GridLayoutManager(this,2));
        mRecycleView.setAdapter(mAdapter);
    }
}
