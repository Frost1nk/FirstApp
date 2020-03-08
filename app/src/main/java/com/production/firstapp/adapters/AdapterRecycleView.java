package com.production.firstapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.production.firstapp.R;
import com.production.firstapp.holders.AppHolder;
import com.production.firstapp.holders.ContentHolder;
import com.production.firstapp.models.Model;
import com.production.firstapp.utils.ContentUtils;

import java.util.List;

public class AdapterRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int APP_VIEW_TYPE = R.layout.layout_item_app;
    public static final int CONTENT_VIEW_TYPE = R.layout.layout_item_content;

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
        switch (viewType){
            case CONTENT_VIEW_TYPE:
                return new ContentHolder(view);
            case APP_VIEW_TYPE:
                return new AppHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case CONTENT_VIEW_TYPE:
                ((ContentHolder) holder).onBind(models.get(position));
            case APP_VIEW_TYPE:
                ((AppHolder) holder).onBind(models.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int  getItemViewType(int position){
        return ContentUtils.getViewType(models.get(position).getType());
    }

    public void setModels(List<Model> models) {
        this.models = models;
        notifyDataSetChanged();
    }
}
