package com.example.basemodule.base.baseFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * copyright (C), 2021, 运达科技有限公司
 * fileName SimpleFragment
 *
 * @author 王玺权
 * date 2021-03-11 15:26
 * description
 * history
 */
public abstract class SimpleFragment extends Fragment {
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    private Unbinder unbinder;
    protected boolean isInited=false;
    /**
     * 沉浸式
     */
    protected ImmersionBar mImmersionBar;
    @Override
    public void onAttach(Context context) {
        mActivity= (Activity) context;
        mContext=context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(layoutId(),null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isImmersionBarEnabled()){
            initImmersionBar();
        }
        unbinder= ButterKnife.bind(this,view);
        isInited = true;
        initEventAndData();
        clicks();
    }
    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return false;
    }
    protected void initImmersionBar() {
        //在BaseActivity里初始化
//        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.init();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
//        if (mImmersionBar != null)
//            mImmersionBar.destroy();  //在BaseActivity里销毁
    }

    /**
     * 返回布局文件
     * @return 布局
     */
    protected abstract int layoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

    /**
     * 点击事件
     */
    protected abstract void clicks();


}