package com.production.firstapp.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.production.firstapp.models.Model;

public class AppHolder extends RecyclerView.ViewHolder {
    public AppHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void onBind(Model model){

    }

}
