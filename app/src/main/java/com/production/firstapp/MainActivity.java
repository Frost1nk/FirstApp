package com.production.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.production.firstapp.adapters.AdapterRecycleView;
import com.production.firstapp.models.Model;
import com.production.firstapp.viewModels.ContentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnMoreApps;
    private RecyclerView mRecycleView;

    private AdapterRecycleView mAdapter;
    private ContentViewModel mContentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoreApps.findViewById(R.id.btnMoreApps);
        mRecycleView.findViewById(R.id.recycleView);

        mAdapter = new AdapterRecycleView(this, new ArrayList<Model>());
        mRecycleView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecycleView.setAdapter(mAdapter);

        mContentViewModel = new ViewModelProvider(getViewModelStore(),
                new ContentViewModel.ContentViewModelFactory(getApplication(),
                        "")).get(ContentViewModel.class);
        mContentViewModel.getItems().observe(this, this::updateItems);
    }

    public void updateItems(List<Model> models) {
        if (models != null && !models.isEmpty()) {
            mAdapter.setModels(models);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mContentViewModel.getItems().removeObservers(this);
    }
}
