package com.production.firstapp.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.production.firstapp.GlideApp;
import com.production.firstapp.R;
import com.production.firstapp.models.Model;

public class ContentHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private TextView mTitle;

    public ContentHolder(@NonNull View itemView){
        super(itemView);
        mTitle = itemView.findViewById(R.id.textViewTitle);
        mImageView = itemView.findViewById(R.id.imageViewItem);
    }


    public void onBind(Model model){
        //Title
        if(model.getName() != null && !model.getName().isEmpty() && mTitle != null){
            mTitle.setText(model.getName());
        }

        View.OnClickListener onClickListener = v -> {

        };

        //ImageView
        if(mImageView != null){
            mImageView.setOnClickListener(onClickListener);
            GlideApp
                    .with(itemView)
                    .load(model.getImageLink())
                    .fitCenter()
                    .centerCrop()
                    .into(mImageView);
        }
    }
}
