package com.production.firstapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.production.firstapp.R;
import com.production.firstapp.models.Model;

import java.util.List;

public class AdapterRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int APP_VIEW_TYPE = R.layout.

    private List<Model> models;
    private LayoutInflater layoutInflater;

    public AdapterRecycleView(Context context,List<Model> models) {
        this.models = models;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(viewType,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int  getItemViewType(int position){
        return super.getItemViewType(position);
    }
}
