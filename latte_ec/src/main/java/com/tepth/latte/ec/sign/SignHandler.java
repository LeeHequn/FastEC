package com.tepth.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tepth.latte.app.AccountManager;
import com.tepth.latte.ec.database.DatabaseManager;
import com.tepth.latte.ec.database.UserProfile;

/**
 * Description:登陆助手
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
@SuppressWarnings("ALL")
public class SignHandler {

    /**
     * 登陆的处理方法
     *
     * @param response     用户信息
     * @param signListener 登陆回调
     */
    public static void onSignIn(String response, ISignListener signListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);
        //登陆成功，保存登录状态
        AccountManager.setSignState(true);
        signListener.onSignInSuccess();
    }

    /**
     * 注册的处理方法
     *
     * @param response     用户信息
     * @param signListener 注册回调
     */
    public static void onSignUp(String response, ISignListener signListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);
        //注册并登陆成功，保存登录状态
        AccountManager.setSignState(true);
        signListener.onSignUpSuccess();
    }
}
