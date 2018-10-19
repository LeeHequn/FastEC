package com.tepth.latte.ec.sign;

/**
 * Description:登陆或者注册成功的回调
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public interface ISignListener {

    /**
     * 登陆成功回调
     */
    void onSignInSuccess();

    /**
     * 注册成功回调
     */
    void onSignUpSuccess();
}
