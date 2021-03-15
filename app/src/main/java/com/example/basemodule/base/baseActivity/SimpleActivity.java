package com.example.basemodule.base.baseActivity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.basemodule.app.BaseApp;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * copyright (C), 2021, 运达科技有限公司
 * fileName SimpleActivity
 *
 * @author 王玺权
 * date 2021-03-09 17:40
 * description
 * history
 */
public abstract class SimpleActivity extends AppCompatActivity {
    /**
     * 沉浸式
     */
    protected ImmersionBar mImmersionBar;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        //初始化沉浸式
        if (isImmersionBarEnabled()){
            initImmersionBar();
        }
        unbinder= ButterKnife.bind(this);
        onViewCreat();
        BaseApp.getInstance().addActivity(this);
        initEventAndData();
        clicks();
    }
    protected void onViewCreat(){

    }


    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar
                .barAlpha(0f)
                .init();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    /**
     * 展示对话框
     * @param msg
     */
    protected void showLoading(String msg){

    }

    /**
     * 隐藏对话框
     */
    protected void hidenLoading(){

    }
    /** 设置布局ID */
    public abstract  int layoutId();
    /** 初始化View与控件 */
    public abstract void initEventAndData();
    /** 需要出发的事件 */
    public abstract void clicks();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApp.getInstance().removeActivity(this);
        unbinder.unbind();
    }
}
