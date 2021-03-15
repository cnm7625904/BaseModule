package com.example.basemodule.base.baseView;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author 王玺权
 */

public class Rxpresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;
    /**
     * 统一管理
     */
    protected CompositeDisposable compositeDisposable;
    protected void unSubscribe(){
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }
    protected void addSubscribe(Disposable subsciption){
        if(compositeDisposable==null){
            compositeDisposable=new CompositeDisposable();
        }
        compositeDisposable.add(subsciption);
    }
    @Override
    public void attachView(T view) {
        this.mView=view;
    }

    @Override
    public void detachView() {
        this.mView=null;
        unSubscribe();
    }
}
