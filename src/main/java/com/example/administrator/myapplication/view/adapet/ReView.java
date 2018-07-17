package com.example.administrator.myapplication.view.adapet;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

public class ReView extends RecyclerView.ViewHolder {

    public ImageView item_pic;
    public TextView item_tit;

    public ReView(View itemView) {
        super(itemView);
        item_pic = itemView.findViewById(R.id.item_pic);
        item_tit = itemView.findViewById(R.id.item_tit);
    }
}
