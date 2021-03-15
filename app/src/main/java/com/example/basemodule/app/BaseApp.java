package com.example.basemodule.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.example.basemodule.R;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;

import java.util.HashSet;
import java.util.Set;

/**
 * copyright (C), 2021, 运达科技有限公司
 * fileName BaseApp
 *
 * @author 王玺权
 * date 2021-03-15 14:12
 * description
 * history
 */
public class BaseApp extends Application {
    private Set<Activity> allActivities;
    private static volatile BaseApp instance;
    public static synchronized BaseApp getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksImpl());
        /** 工具类 */
        Utils.init(this);
        /** 初始化数据库 */
//        RealmInit.initRealmDb(this);
//        动态 设置  IP 与  不使用接口请求而获取数据的 必须先填写baseUrl
//        if(TextUtils.isEmpty(SPUtils.getInstance().getString(HttpConstant.SP_TAG_BASE_URL))){
//            SPUtils.getInstance().put(HttpConstant.SP_TAG_BASE_URL, HttpConstant.BASE_URL);
//        }

    }

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new MaterialHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    /**
     * 结束掉所有的Activity
     */
    public  void finishAll() {
        //循环集合,  将所有的activity finish
        for (Activity activity : allActivities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
    public void addActivity(Activity act){
        if(allActivities==null){
            allActivities=new HashSet<>();
        }
        allActivities.add(act);
    }
    public void removeActivity(Activity act){
        if(allActivities!=null){
            allActivities.remove(act);
        }
    }
}
