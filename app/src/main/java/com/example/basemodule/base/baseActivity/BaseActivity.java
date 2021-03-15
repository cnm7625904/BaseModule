//package com.example.basemodule.base.baseActivity;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.text.TextUtils;
//import android.view.MotionEvent;
//
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.example.basemodule.R;
//import com.example.basemodule.base.baseConstant.BaseConstant;
//import com.example.basemodule.base.baseView.BasePresenter;
//import com.example.basemodule.base.baseView.BaseView;
//import com.example.basemodule.base.baseView.LoadingDialog;
//import com.scwang.smart.refresh.layout.SmartRefreshLayout;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import es.dmoral.toasty.Toasty;
//
//
///**
// * copyright (C), 2021, 运达科技有限公司
// * fileName BaseActivity
// *
// * @author 王玺权
// * date 2021-03-09 17:47
// * description
// * history
// */
//public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {
//    public static String TAG="";
//    private ITouchEventInterceptor interceptor;
//    protected T mPresenter;
//    private Dialog mLoadingDialog;
//    @Override
//    protected void onViewCreat() {
//        super.onViewCreat();
//        TAG=getClass().getSimpleName();
//        initInject();
//        if(mPresenter!=null){
//            mPresenter.attachView(this);
//        }else {
//            throw new NullPointerException(getResources().getString(R.string.no_presenter));
//        }
//    }
//    /**
//     * 事件拦截
//     *
//     * @param ev
//     * @return
//     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        //TouchEvent 拦截器
//        if (interceptor != null) {
//            boolean consumed = interceptor.interceptTouchEventInActivity();
//            interceptor = null;
//            if (consumed) {
//                return true;
//            }
//        }
//        return super.dispatchTouchEvent(ev);
//    }
//    @Override
//    public void finishWithMsg(String msg) {
//        if(!TextUtils.isEmpty(msg)){
//            showSucessMsg(msg);
//        }
//        finish();
//    }
//
//    @Override
//    public void showErrorMsg(String msg) {
//        Toasty.error(this,msg).show();
//    }
//
//    @Override
//    public void showSucessMsg(String msg) {
//        Toasty.success(this,msg).show();
//    }
//
//    @Override
//    public void showNormalMsg(String msg) {
//        Toasty.normal(this,msg).show();
//    }
//
//    @Override
//    public void showPro(String msg) {
//        if (mLoadingDialog == null) {
//            mLoadingDialog = LoadingDialog.createLoadingDialog(this,msg);
//            mLoadingDialog.show();
//        }else {
//            mLoadingDialog = LoadingDialog.createLoadingDialog(getApplicationContext(), msg);
//            mLoadingDialog.show();
//        }
//    }
//
//    @Override
//    public void showPro() {
//        showPro(BaseConstant.LOADING);
//    }
//
//    @Override
//    public void hidePro() {
//        if (mLoadingDialog != null) {
//            mLoadingDialog.dismiss();
//            mLoadingDialog = null;
//        }
//    }
//    /** 简单测试数据 */
//    protected List<String> getDatas(){
//        List<String> datas=new ArrayList<>();
//        for(int i=0;i<10;i++){
//            datas.add("x");
//        }
//        return datas;
//    }
//    /**
//     * 添加事件拦截器
//     *
//     * @param eventInterceptor
//     */
//    public void setITouchEventInterceptor(ITouchEventInterceptor eventInterceptor) {
//        interceptor = eventInterceptor;
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(mPresenter!=null){
//            mPresenter.detachView();
//        }
//    }
//    /** 结束刷新 */
//    public void finishWithRecycleView(List<?> list, BaseQuickAdapter adapter, SmartRefreshLayout refreshLayout) {
//        //结束刷新或者加载更多
//        if(refreshLayout!=null){
//            refreshLayout.finishRefresh();
//            refreshLayout.finishLoadMore();
//        }
//        //设置空布局
//        if(list.size()==0&&adapter!=null){
//            adapter.setEmptyView(R.layout.layout_base_nodata_page);
////            adapter.setEmptyView(R.layout.layout_base_nodata_page, (ViewGroup) recyclerView.getParent());
//        }
//    }
//
//
//    /** 结束刷新 */
//    @Override
//    public void finishRecycleView() {
//
//    }
//
//    /** 实例化Presenter */
//    protected abstract void initInject();
//    /**
//     * 事件拦截器
//     */
//    public interface ITouchEventInterceptor {
//        boolean interceptTouchEventInActivity();
//    }
//
//    /**
//     * 页面跳转
//     * @param tClass 跳转类
//     */
//    public void startTo(Class<?> tClass,Boolean isFinish){
//        Intent intent=new Intent(getApplicationContext(),tClass);
//        startActivity(intent);
//        if(isFinish!=null){
//            if (isFinish){
//                finish();
//            }
//        }
//    }
//    public void startTo(Class<?> tClass){
//        Intent intent=new Intent(getApplicationContext(),tClass);
//        startActivity(intent);
//    }
//
//}