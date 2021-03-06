package com.module.mall.adpter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.manager.GlideManager;
import com.module.base.pouduct.ProductBean;
import com.module.mall.R;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class MallListAdpter extends RecyclerView.Adapter {

    private Context context;
    private List<ProductBean.DataBean> list;
    private OnItemClickListener listener;

    public MallListAdpter(Context context, List<ProductBean.DataBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mall_list, null);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;


        GlideManager.loadImage(context
                , Constant.IMAGE_HOST + list.get(position).getImgurl()
                , viewHolder.ivPro);


        viewHolder.tvPirce.setText(list.get(position).getTuanAmount() + "元购");
        viewHolder.tvPirce.setVisibility(View.VISIBLE);

        viewHolder.tvName.setVisibility(View.VISIBLE);
        viewHolder.tvName.setText(list.get(position).getTitle());

        viewHolder.tvOldPirce.setText(list.get(position).getAmount());
        viewHolder.tvOldPirce.setVisibility(View.VISIBLE);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPro;
        TextView tvName, tvPirce, tvOldPirce;

        ViewHolder(View view, final int viewType) {
            super(view);
            ivPro = view.findViewById(R.id.item_img_pro);
            tvName = view.findViewById(R.id.item_tv_name);
            tvPirce = view.findViewById(R.id.item_tv_pirce);
            tvOldPirce = view.findViewById(R.id.item_tv_old_pirce);

            tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(viewType, -1);
                }
            });
        }
    }
}
