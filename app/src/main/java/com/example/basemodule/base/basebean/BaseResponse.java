package com.example.basemodule.base.basebean;

/**
 * copyright (C), 2020, 运达科技有限公司
 * fileName BaseResponse
 *
 * @author 王玺权
 * date 2020-11-19 11:37
 * description 接口返回最外层包装对象
 * history
 */
public class BaseResponse<T> {

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    /**
     * msg : 用户名不存在或密码错误！
     * ticket : ticket
     * success : false
     */
    private T root;
    private String msg;
    private String ticket;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
