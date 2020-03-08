package com.production.firstapp.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.production.firstapp.models.Model;

public class ContentHolder extends RecyclerView.ViewHolder {

    public ContentHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void onBind(Model model){

    }
}
