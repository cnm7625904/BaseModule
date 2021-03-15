package com.example.basemodule.base.baseConstant;


/**
 * copyright (C), 2020, 运达科技有限公司
 * fileName HttpConstant
 *
 * @author 王玺权
 * date 2020-11-30 13:55
 * description
 * history
 */
public class HttpConstant {
    public static final String CACHE_COOKIE = "cache_cookie";

    /** 业务服务器 */
    public static final String BASE_URL = true? "http://139.9.246.226:8081/DTCG/" : "http://yunda.free.qydev.com:8080/DTCG/";

    /** 网络缓存最大值 */
    public static final int CACHE_MAXSIZE = 1024 * 1024 * 30;

    /** 网络缓存保存时间 */
    public static final int TIME_CACHE = 60 * 60;

    /**
     * 业务服务器地址
     */
    public static final String SP_TAG_BASE_URL = "sp_tag_base_url";
    public static final String SP_TAG_MESSAGE_SERVER_URL = "sp_tag_message_server_url";
    public static final String SP_TAG_WS_SERVER_IP = "sp_tag_ws_server_ip";
    public static final String SP_TAG_WS_SERVER_PORT = "sp_tag_ws_server_port";
    /**
     * 聊天WEB SOCKET消息服务器 IP BuildConfig.DEBUG
     */
    public static final String BASE_WS_SERVER_IP =true ? "10.2.4.24" : "10.105.237.126";
    /**
     * 聊天WEB SOCKET消息服务器 端口号
     */
    public static final String BASE_WS_SERVER_PORT = true ? "7397" : "7398";
    /**
     * 消息业务服务器 设置界面，不允许修改"msgGroup"
     */
    public static final String BASE_MESSAGE_SERVER_URL =true ? "http://10.2.4.24:8888/msgGroup/" : "http://10.105.237.126:8081/msgGroup/";
}
