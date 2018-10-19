package com.tepth.latte.net.callback;

/**
 * Description:网络请求回调，包含开始和结束
 *
 * @author Hequn.Lee
 * @date 2018/10/15
 */
public interface IRequest {

    /**
     * 网络请求开始回调
     */
    void onRequestStart();

    /**
     * 网络请求结束回调
     */
    void onRequestEnd();
}
