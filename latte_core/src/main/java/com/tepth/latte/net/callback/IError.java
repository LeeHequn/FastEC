package com.tepth.latte.net.callback;

/**
 * Description:网络请求错误回调
 *
 * @author Hequn.Lee
 * @date 2018/10/15
 */
public interface IError {
    /**
     * 网络请求错误回调
     *
     * @param code 错误码
     * @param msg  错误信息
     */
    void onError(int code, String msg);
}
