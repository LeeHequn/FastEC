package com.tepth.latte.utils.timer;

import java.util.TimerTask;

/**
 * Description:倒计时任务
 *
 * @author Hequn.Lee
 * @date 2017/11/7
 */

@SuppressWarnings("ALL")
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
