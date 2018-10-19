package com.tepth.latte.app;

/**
 * Description:用户是否登陆的回调
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */

public interface IUserChecker {

    /**
     * 用户已经登陆了
     */
    void onSignIn();

    /**
     * 用户没登陆
     */
    void onNotSignIn();
}
