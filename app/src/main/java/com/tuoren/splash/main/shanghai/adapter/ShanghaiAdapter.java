package com.tuoren.splash.main.shanghai.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private final boolean mIsHor;
    private final RecyclerView.RecycledViewPool recycledViewPool;

    public ShanghaiAdapter(Context context, ArrayList<ShanghaiBean> data,boolean isHor) {
        recycledViewPool = new RecyclerView.RecycledViewPool();
        mData = data;
        mContext = context;
        mIsHor = isHor;
    }


    // 创建View 然后进行缓存
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL) {
            if (mIsHor) {
                Log.e("onCreateViewHolder", "VERTICAL" );
            }
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, parent,false);
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
            ((ShanghaiViewHolder)holder).mIv.setVisibility(shanghaiBean.isShowImg()?View.VISIBLE:View.GONE);
            ((ShanghaiViewHolder)holder).itemView.setTag(position);
        } else if (holder instanceof ShanghaiViewHolderRv) {
            ((ShanghaiViewHolderRv)holder).mRecyclerView.setAdapter(new ShanghaiAdapter(mContext, shanghaiBean.getData(), true));
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
        public ImageView mIv;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
            mIv = itemView.findViewById(R.id.item_shanghai_iv);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    Toast.makeText(mContext, "我被点击了 + position = " + position, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder {

        public RecyclerView mRecyclerView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_shanghai_rv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setRecycledViewPool(recycledViewPool);
        }
    }
}
