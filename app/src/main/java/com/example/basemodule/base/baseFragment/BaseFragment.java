//package com.example.basemodule.base.baseFragment;
//
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.annotation.Nullable;
//
//
//import com.example.basemodule.base.baseView.BasePresenter;
//import com.example.basemodule.base.baseView.BaseView;
//
//import es.dmoral.toasty.Toasty;
//
///**
// * copyright (C), 2021, 运达科技有限公司
// * fileName BaseFragment
// *
// * @author 王玺权
// * date 2021-03-11 15:30
// * description
// * history
// */
//public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {
//    protected T mPresenter;
//    public static String TAG="";
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        initInject();
//        mPresenter.attachView(this);
//        TAG=getClass().getSimpleName();
//        super.onViewCreated(view, savedInstanceState);
//    }
//
//    @Override
//    public void showNormalMsg(String msg) {
//        Toasty.normal(mContext,msg).show();
//    }
//
//    @Override
//    public void showSucessMsg(String msg) {
//
//        Toasty.success(mContext,msg).show();
//    }
//
//    @Override
//    public void showErrorMsg(String msg) {
//        Toasty.error(mContext,msg).show();
//    }
//
//    @Override
//    public void onDestroyView() {
//        if (mPresenter != null){
//            mPresenter.detachView();
//        }
//        super.onDestroyView();
//    }
//
//    /**
//     * 注入
//     */
//    protected abstract void initInject();
//
//    @Override
//    public void finishWithMsg(String msg) {
//
//    }
//
//    @Override
//    public void finishRecycleView() {
//
//    }
//
//    @Override
//    public void hidePro() {
//
//    }
//
//    @Override
//    public void showPro(String msg) {
//
//    }
//
//    @Override
//    public void showPro() {
//
//    }
//}
