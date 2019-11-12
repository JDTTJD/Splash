package com.tuoren.splash.main.shanghai.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuoren.splash.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by JDT on 2019/11/12.
 */
public class ShanghaiAdapter extends RecyclerView.Adapter {

    private final ArrayList<String> mData;

    public ShanghaiAdapter(ArrayList<String> data) {
        mData = data;
    }


    // 创建View 然后进行缓存
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, null);
        ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(inflate);
        return viewHolder;
    }

    // 绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ShanghaiViewHolder)holder).mTv.setText(mData.get(position));
    }

    // 条目数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //缓存View 内存友好设计
    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {

        public TextView mTv;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
        }
    }
}
