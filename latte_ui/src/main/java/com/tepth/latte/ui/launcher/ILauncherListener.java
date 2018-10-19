package com.tepth.latte.ui.launcher;

/**
 * Description:启动图结束回调
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */

public interface ILauncherListener {

    /**
     * 启动图结束后的回调
     *
     * @param tag 判断是否登陆
     */
    void onLauncherFinish(OnLauncherFinishTag tag);
}
