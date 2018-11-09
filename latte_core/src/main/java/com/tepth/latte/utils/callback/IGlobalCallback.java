package com.tepth.latte.utils.callback;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/30
 */
public interface IGlobalCallback<T> {

    /**
     * 执行回调的方法
     *
     * @param args 任意类型的参数
     */
    void executeCallback(T args);
}
