package com.tepth.latte.delegates.bottom;

import java.util.LinkedHashMap;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public final class ItemBuilder {
    /**
     * 存储底部按钮和对应页面的集合
     */
    private final LinkedHashMap<BottomTabBean, BaseBottomItemDelegate> ITEMS = new LinkedHashMap<>();

    /**
     * 构造方法
     *
     * @return 懒汉模式返回
     */
    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    /**
     * 添加单个页面和按钮
     *
     * @param bean     底部按钮
     * @param delegate 对应页面
     * @return 构造者
     */
    public final ItemBuilder addItem(BottomTabBean bean, BaseBottomItemDelegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    /**
     * 添加页面和按钮的集合
     *
     * @param items 页面和按钮的集合
     * @return 构造者
     */
    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BaseBottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    /**
     * 构造集合
     *
     * @return 页面和按钮的集合
     */
    public final LinkedHashMap<BottomTabBean, BaseBottomItemDelegate> build() {
        return ITEMS;
    }
}
