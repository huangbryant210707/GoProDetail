package com.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.mine.R;

/**
 * Created by shibing on 18/5/5.
 * <p>
 * 邀请码
 */

public class InvitationCodeActivity extends BaseActivity {


    private TextView textView;
    private String requestCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("邀请码").rightText("邀请规则");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_invicode;
    }

    @Override
    public void initView() {
        textView = findViewById(R.id.invicode_tv);
        requestCode = getIntent().getStringExtra(Constant.REQUESTCODE);
        textView.setText(requestCode);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void onRightClick() {
        startActivity(new Intent(this, InvitaRuleActivity.class));
    }
}
