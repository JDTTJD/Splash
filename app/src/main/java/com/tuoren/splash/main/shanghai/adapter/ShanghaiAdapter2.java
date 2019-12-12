package com.tuoren.splash.main.shanghai.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuoren.splash.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by JDT on 2019/11/12.
 */
public class ShanghaiAdapter2 extends RecyclerView.Adapter {

    public ShanghaiAdapter2() {

    }


    // 创建View 然后进行缓存
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_cardview, null);
        ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(inflate);
        return viewHolder;
    }

    // 绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    }

    // 条目数量
    @Override
    public int getItemCount() {
        return 15;
    }


    //缓存View 内存友好设计
    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
