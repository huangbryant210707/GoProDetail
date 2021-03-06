package com.module.mine.ui.tuancoupon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.SPUtil;
import com.module.mine.R;
import com.module.mine.adapter.OpenCoilAdapter;
import com.module.mine.bean.TuanCouponBean;

import java.util.List;

/**
 * Created by shibing on 18/5/6.
 */


@Route(path = Constant.OPENCOIL_PATH)
public class MyOpenCoilActivity extends BaseActivity implements
        AdapterView.OnItemClickListener
        , TuanCouponView {

    private ListView listView;
    private LinearLayout layNodata;

    private List<TuanCouponBean.DataBean> list;
    private OpenCoilAdapter openCoilAdapter;
    private OpenCoilPresenter presenter;
    private SPUtil spUtil;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("我的开团卷").rightText("帮助说明");
        presenter.getTuanCouponList(spUtil.getString(Constant.USERID));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_opencoil;
    }

    @Override
    public void initView() {
        spUtil = SPUtil.getInstance(this);

        layNodata = findViewById(R.id.nadata_lay);
        listView = findViewById(R.id.opencoil_list);
    }

    @Override
    public void setListener() {
        super.setListener();
        listView.setOnItemClickListener(this);
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new OpenCoilPresenter();
        return presenter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra(Constant.OPEN_TUAN_NUMER, list.get(position).getTuanNum());
        intent.putExtra(Constant.OPEN_TUAN_NAME, list.get(position).getTitle());
        intent.putExtra(Constant.OPEN_TUAN_ID, list.get(position).getId());
        setResult(100, intent);
        finish();
    }


    /**
     * 数据处理
     *
     * @param tuanCouponBean
     */
    @Override
    public void showTuanCouponList(TuanCouponBean tuanCouponBean) {
        list = tuanCouponBean.getData();
        if (list.size() == 0) {
            layNodata.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            return;
        }

        listView.setVisibility(View.VISIBLE);
        openCoilAdapter = new OpenCoilAdapter(this, list);
        listView.setAdapter(openCoilAdapter);
    }

    @Override
    public void onFindErr() {

    }
}
