package com.example.basemodule.base.baseView;

/**
 * copyright (C), 2021, 运达科技有限公司
 * fileName BasePresenter
 *
 * @author 王玺权
 * date 2021-03-09 17:47
 * description
 * history
 */
public interface BasePresenter<T extends BaseView> {
    /**
     *  加载View
     */
    void attachView(T view);

    /**
     * 分离View
     */
    void detachView();
}
