package com.example.administrator.myapplication.view.adapet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.view.Bean;
import com.example.administrator.myapplication.view.inter.JieKouHuiDiao;

import java.util.List;


public class RecyAdapet extends RecyclerView.Adapter<ReView> {
    Context context;
    List<Bean.TuijianBean.ListBean> list;
    JieKouHuiDiao jieKouHuiDiao;

    public RecyAdapet(Context context, List<Bean.TuijianBean.ListBean> list) {
this.context=context;
this.list=list;
    }

    @Override
    public ReView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zs_item,parent, false);
        ReView reView=new ReView(view);

        return reView;
    }

    @Override
    public void onBindViewHolder(ReView holder, final int position) {
        holder.item_tit.setText(list.get(position).getTitle());
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.item_pic);
        //自定义点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jieKouHuiDiao.dianzhong(position);
            }
        });
        //长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                jieKouHuiDiao.changan(position);
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  void Hui( JieKouHuiDiao jieKouHuiDiao){
        this.jieKouHuiDiao=jieKouHuiDiao;

    }

}
