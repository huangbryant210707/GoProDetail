package com.module.user.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BaseActivity;
import com.module.base.BasePresenter;
import com.module.base.app.Constant;
import com.module.base.utils.VerifyCodeUtil;
import com.module.user.AgreementActivity;
import com.module.user.HelpActivity;
import com.module.user.R;

/**
 * Created by shibing on 18/5/3.
 */

public class RegisterActivity extends BaseActivity implements VerifyCodeUtil.CountListener
        ,RegisterView {

    private EditText Edphone, Edpassword, Edcode, Edinvicode;
    private TextView sendcode, agreement;
    private Button register;


    private VerifyCodeUtil util;
    private String Tvphone, Tvpassword, Tvcode, Tvinvicode;

    private RegisterPresenter registerPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title("注册").rightText("帮助");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {

        Edphone = findViewById(R.id.register_phone_ed);
        Edpassword = findViewById(R.id.register_pwass_ed);
        Edcode = findViewById(R.id.registetr_code_ed);
        Edinvicode = findViewById(R.id.register_invit_ed);

        sendcode = findViewById(R.id.register_sendcode_tv);
        register = findViewById(R.id.register_but);
        agreement = findViewById(R.id.register_agre_tv);

        //
        Tvphone = Edphone.getText().toString();
        Tvpassword = Edpassword.getText().toString();
        Tvcode = Edcode.getText().toString();
        Tvinvicode = Edinvicode.getText().toString();

        util = new VerifyCodeUtil(this, this);
    }

    @Override
    public BasePresenter createPresenter() {
        registerPresenter = new RegisterPresenter();
        return registerPresenter;
    }

    @Override
    public void setListener() {
        super.setListener();
        register.setOnClickListener(this);
        agreement.setOnClickListener(this);
        sendcode.setOnClickListener(this);
    }


    /**
     * 监听事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == R.id.register_but) {
            //注册
            registerPresenter.register();
            ARouter.getInstance().build(Constant.PATH_MAINACTIVITY).navigation();
            finish();

        } else if (i == R.id.register_sendcode_tv) {
            //发送验证码
            util.startCount();

        } else if (i == R.id.register_agre_tv) {
            //协议
            startActivity(new Intent(this, AgreementActivity.class));
        }
    }


    @Override
    public void onRightClick() {
        startActivity(new Intent(this, HelpActivity.class));
    }

    @Override
    public void count(Activity activity, String count) {
        if (TextUtils.equals(count, "0")) {
            sendcode.setText("重新发送");
            sendcode.setClickable(true);
        } else {
            sendcode.setClickable(false);
            sendcode.setText(count + "s");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        util.setStop(true);
    }

    @Override
    public void onSuccess(String msg) {

    }

    @Override
    public void onError(String error) {

    }
}