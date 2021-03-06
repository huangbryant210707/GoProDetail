package com.module.mine.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.module.base.listener.OnItemClickListener;
import com.module.mine.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class MineAdapter extends RecyclerView.Adapter {

    private OnItemClickListener listener;
    private Activity activity;

    private List<String> names;
    private List<Integer> resId;

    public MineAdapter(Activity activity, OnItemClickListener listener) {

        this.activity = activity;
        this.listener = listener;

        initList();
    }

    private void initList() {
        names = Arrays.asList("我的团队"
                , "拼团返现"
                , "我的开团卷"
                , "我的订单"
                , "我的押金"
                , "收货信息管理"
                , "我的收藏"
                , "新手帮助"
                , "客服电话"
                , "投诉建议"
                , "系统设置"
                , null);

        resId = Arrays.asList(
                R.drawable.ic_mine_team
                , R.drawable.ic_mine_achi
                , R.drawable.ic_mine_voucher
                , R.drawable.ic_mine_achi
                , R.drawable.ic_mine_order
                , R.drawable.ic_mine_deposit
                , R.drawable.ic_mine_logistics
                , R.drawable.ic_mine_heart
                , R.drawable.ic_mine_problem
                , R.drawable.ic_mine_telephone
                , R.drawable.ic_mine_complaint
                , R.drawable.ic_mine_set
                , 0);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_mine_grid, null);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        initView(position, (ViewHolder) holder);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    private void initView(int position, ViewHolder viewHolder) {
        if (TextUtils.isEmpty(names.get(position))) {
            return;
        }
        viewHolder.tv.setText(names.get(position));
        viewHolder.tv.setCompoundDrawablesWithIntrinsicBounds(0
                , resId.get(position)
                , 0
                , 0);

        if (position == 3 || position == 4 || position == 5) {
            viewHolder.divider.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 添加item监听
     *
     * @param listener
     */
    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        View divider;

        ViewHolder(View view, final int viewType) {
            super(view);
            tv = view.findViewById(R.id.mine_tv_item);
            divider = view.findViewById(R.id.mine_divider);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(viewType, -1);
                    }
                }
            });
        }
    }
}
