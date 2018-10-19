package com.tepth.latte.net.callback;

/**
 * Description:网络请求成功回调
 *
 * @author Hequn.Lee
 * @date 2018/10/15
 */
public interface ISuccess {
    /**
     * 网络请求成功回调
     *
     * @param response 回调字符串
     */
    void onSuccess(String response);
}
