package com.example.basemodule.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * @author 观察Activity生命周期
 */
public class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {

    public ActivityLifecycleCallbacksImpl() {
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.i(activity.getClass().getName()+"" , " - onActivityCreated");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.i(activity.getClass().getName()+"" , " - onActivityStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.i(activity.getClass().getName()+"" , " - onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.i(activity.getClass().getName()+"" , " - onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.i(activity.getClass().getName()+"" , " - onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.i(activity.getClass().getName()+"" , " - onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.i(activity.getClass().getName()+"" , " - onActivityDestroyed");
    }
}
