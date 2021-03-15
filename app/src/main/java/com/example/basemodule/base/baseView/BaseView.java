package com.example.basemodule.base.baseView;

/**
 * copyright (C), 2021, 运达科技有限公司
 * fileName BaseView
 *
 * @author 王玺权
 * date 2021-03-09 17:39
 * description
 * history
 */
public interface BaseView {
    /**
     * 展示消息
     * @param msg
     */
    void showErrorMsg(String msg);
    void showSucessMsg(String msg);
    void showNormalMsg(String msg);
    void showPro();
    void finishWithMsg(String msg);
    /**
     *  隐藏显示加载框
     */
    void hidePro();
    void showPro(String msg);

    /**
     * 结束刷新
     */
    void finishRecycleView();
}
