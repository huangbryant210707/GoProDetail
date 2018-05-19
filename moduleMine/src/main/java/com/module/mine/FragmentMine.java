package com.module.mine;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.module.base.BaseFragment;
import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.widgets.XItemDecoration;
import com.module.mine.adapter.MineAdapter;
import com.module.mine.ui.AdderAddressActivity;
import com.module.mine.ui.BalanceActivity;
import com.module.mine.ui.CardActivity;
import com.module.mine.ui.CollageReturnsActivity;
import com.module.mine.ui.ComplaintActivity;
import com.module.mine.ui.DepositActivity;
import com.module.mine.ui.InvitationCodeActivity;
import com.module.mine.ui.KePhoneActivity;
import com.module.mine.ui.MyOpenCoilActivity;
import com.module.mine.ui.MyTeamActivity;
import com.module.mine.ui.NoviceActivity;
import com.module.mine.ui.OrderActivity;
import com.module.mine.ui.SeetingActivity;
import com.module.mine.ui.SystemMessActivity;
import com.module.mine.ui.UserInfoActivity;

/**
 * @author Huangshuang  2018/5/4 0004
 */

public class FragmentMine extends BaseFragment implements OnItemClickListener {

    private ImageView head,inCodeTv;
    private FrameLayout messFra;
    private RecyclerView recyclerView;
    private LinearLayout inCodeLay, banLanceLay, cardLay;
    private TextView phoneTv, mesTv, banlanceTv;

    private MineAdapter mineAdapter;


    public static FragmentMine newInstance(String msg) {
        return new FragmentMine();
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        head = f(R.id.mine_hede_img);
        phoneTv = f(R.id.mine_phone_tv);
        mesTv = f(R.id.mine_mes_tv);
        banlanceTv = f(R.id.mine_banlance_tv);
        inCodeTv = f(R.id.mine_incode_tv);
        messFra = f(R.id.mine_mes_fra);
        inCodeLay = f(R.id.mine_incode_lay);
        banLanceLay = f(R.id.mine_banlance_lay);
        cardLay = f(R.id.mine_card_lay);
        recyclerView = f(R.id.mine_recycler);

        initRecycle();
    }

    private void initRecycle() {
        GridLayoutManager manager = new GridLayoutManager(activity, 3);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.addItemDecoration(new XItemDecoration(activity));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(manager);

        mineAdapter = new MineAdapter(activity, this);
        mineAdapter.addOnItemClickListener(this);
        recyclerView.setAdapter(mineAdapter);
    }

    @Override
    public void setListener() {
        super.setListener();
        head.setOnClickListener(this);
        messFra.setOnClickListener(this);
        inCodeLay.setOnClickListener(this);
        banLanceLay.setOnClickListener(this);
        cardLay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        //头像
        if (i == R.id.mine_hede_img) {
            startActivity(new Intent(activity, UserInfoActivity.class));
        }
        //消息
        else if (i == R.id.mine_mes_fra) {
            startActivity(new Intent(activity, SystemMessActivity.class));
        }
        //邀请码
        else if (i == R.id.mine_incode_lay) {
            startActivity(new Intent(activity, InvitationCodeActivity.class));
        }
        //余额
        else if (i == R.id.mine_banlance_lay) {
            startActivity(new Intent(activity, BalanceActivity.class));
        }
        //银行卡
        else if (i == R.id.mine_card_lay) {
            startActivity(new Intent(activity, CardActivity.class));
        }
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = null;
        switch (position) {
            //我的团队
            case 0:
                startActivity(new Intent(activity, MyTeamActivity.class));
                break;
            //拼团返现
            case 1:
                startActivity(new Intent(activity, CollageReturnsActivity.class));
                break;

            //我的开团卷
            case 2:
                startActivity(new Intent(activity, MyOpenCoilActivity.class));
                break;
            //我的订单
            case 3:
                intent = new Intent(activity, OrderActivity.class);
                intent.putExtra(Constant.TITLE, "我的订单");
                startActivity(intent);

                break;
            //我的押金
            case 4:
                startActivity(new Intent(activity, DepositActivity.class));
                break;
            //收货信息管理
            case 5:
                startActivity(new Intent(activity, AdderAddressActivity.class));
                break;
            //我的收藏
            case 6:
                intent = new Intent(activity, OrderActivity.class);
                intent.putExtra(Constant.TITLE, "我的收藏");
                startActivity(intent);
                break;
            //新手帮助
            case 7:
                startActivity(new Intent(activity, NoviceActivity.class));
                break;
            //客服电话
            case 8:
                startActivity(new Intent(activity, KePhoneActivity.class));
                break;
            //投诉建议
            case 9:
                startActivity(new Intent(activity,ComplaintActivity.class));
                break;
            //系统设置
            case 10:
                startActivity(new Intent(activity,SeetingActivity.class));
                break;

        }
    }
}
