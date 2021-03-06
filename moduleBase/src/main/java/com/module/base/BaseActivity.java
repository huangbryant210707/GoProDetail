package com.module.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.utils.StatusUtil;


/**
 * @author huangshuang
 * @date 2018/3/8 0008
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends FragmentActivity implements View.OnClickListener {
    public BasePresenter<V> presenter;
    protected FrameLayout titleBarContainer;
    private ImageView ivLeft;
    private TextView tvTitle, tvRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isUseStatusBarColor()) {
            StatusUtil.setStatusBar(this, false, false);
            StatusUtil.setStatusTextColor(isUseDart(), this);
        }
        setContentView(getLayoutId());

        initView();
        initTitleBar();
        setListener();

        presenter = createPresenter();
        if (presenter != null) {
            presenter.onCreate();
            presenter.attachView((V) this);
        }
    }

    /**
     * 是否使用沉浸式状态栏
     */
    public boolean isUseStatusBarColor() {
        return true;
    }

    /**
     * 是否使用沉浸式状态栏
     */
    public boolean isUseDart() {
        return true;
    }

    /**
     * 用于实现类返回视图
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 用于实现类初始化控件
     */
    public abstract void initView();

    /**
     * 初始化titleBar
     */
    private void initTitleBar() {
        tvTitle = findViewById(R.id.titleBar_title);
        ivLeft = findViewById(R.id.titleBar_left_img);
        tvRight = findViewById(R.id.titleBar_right_text);
        titleBarContainer = findViewById(R.id.titleBar_container);
    }

    /**
     * 用于实现类设置监听
     */
    @CallSuper
    public void setListener() {
        if (ivLeft != null) {
            ivLeft.setOnClickListener(this);
        }
        if (tvRight != null) {
            tvRight.setOnClickListener(this);
        }
    }

    /**
     * 用于实现类创建presenter
     *
     * @return
     */
    public abstract BasePresenter<V> createPresenter();

    public BaseActivity background(int resColor) {
        int color = ContextCompat.getColor(this, resColor);
        titleBarContainer.setBackgroundColor(color);
        return this;
    }

    public BaseActivity leftImageRes(int drawableRes) {
        ivLeft.setImageResource(drawableRes);
        return this;
    }

    public BaseActivity rightImageRes(int drawableRes) {
        tvRight.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableRes, 0);
        return this;
    }

    public BaseActivity title(String title) {
        tvTitle.setText(title);
        return this;
    }

    public BaseActivity rightText(String text) {
        tvRight.setText(text);
        return this;
    }

    public BaseActivity titleColor(int resColor) {
        int color = ContextCompat.getColor(this, resColor);
        tvTitle.setTextColor(color);
        return this;
    }

    /**
     * 弹出软键盘
     *
     * @param view
     */
    public void showInPutKeybord(final View view) {
        view.requestFocus();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(view, 0);
                }
            }
        }, 100);
    }


    public void initImagePicker() {

    }


    @CallSuper
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.titleBar_left_img) {
            finish();

        } else if (i == R.id.titleBar_right_text) {
            onRightClick();
        } else {
        }
    }

    /**
     * 右侧图片的点击事件
     */
    public void onRightClick() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter == null) {
            return;
        }
        presenter.detachView();
    }
}
