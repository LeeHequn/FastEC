package com.tepth.latte.delegates;

/**
 * Description:供项目使用的Fragment
 *
 * @author Hequn.Lee
 * @date 2018/10/14
 */
@SuppressWarnings("ALL")
public abstract class BaseLatteDelegate extends BaseDelegate {
    /**
     * 获取Fragment的上一级Fragment
     *
     * @param <T> 上一级Fragment
     * @return 上一级Fragment
     */
    public <T extends BaseLatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
