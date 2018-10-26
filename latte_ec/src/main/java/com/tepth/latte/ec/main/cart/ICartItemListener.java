package com.tepth.latte.ec.main.cart;

/**
 * Description:用来计算购物车总价的接口
 *
 * @author Hequn.Lee
 * @date 2018/1/10
 */

public interface ICartItemListener {
    /**
     * 更新Item的总价
     *
     * @param itemTotalPrice item的总价
     */
    void onItemClick(double itemTotalPrice);
}
