package com.tuoren.splash.main.shanghai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuoren.splash.R;
import com.tuoren.splash.main.shanghai.dto.ShanghaiBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by JDT on 2019/11/12.
 */
public class ShanghaiAdapter extends RecyclerView.Adapter {

    private final ArrayList<ShanghaiBean> mData;
    private final Context mContext;

    public ShanghaiAdapter(Context context, ArrayList<ShanghaiBean> data) {
        mData = data;
        mContext = context;
    }


    // 创建View 然后进行缓存
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, null);
            ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(inflate);
            return viewHolder;
        } else if (viewType == ShanghaiBean.IShanghaiItemType.HORIZANTAL){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_rv, null);
            ShanghaiViewHolderRv viewHolder = new ShanghaiViewHolderRv(inflate);
            return viewHolder;
        }
        return null;
    }

    // 绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShanghaiBean shanghaiBean = mData.get(position);
        if (holder instanceof ShanghaiViewHolder) {
            ((ShanghaiViewHolder)holder).mTv.setText(shanghaiBean.getmDec());
        } else if (holder instanceof ShanghaiViewHolderRv) {
            ((ShanghaiViewHolderRv)holder).mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            ((ShanghaiViewHolderRv)holder).mRecyclerView.setAdapter(new ShanghaiAdapter(mContext, shanghaiBean.getData()));
        }

    }

    // 条目数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmItemType();
    }

    //缓存View 内存友好设计
    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {

        public TextView mTv;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder {

        public RecyclerView mRecyclerView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_shanghai_rv);
        }
    }
}
