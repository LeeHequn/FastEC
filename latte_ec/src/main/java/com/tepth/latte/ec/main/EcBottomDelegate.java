package com.tepth.latte.ec.main;

import android.graphics.Color;

import com.tepth.latte.delegates.bottom.BaseBottomDelegate;
import com.tepth.latte.delegates.bottom.BaseBottomItemDelegate;
import com.tepth.latte.delegates.bottom.BottomTabBean;
import com.tepth.latte.delegates.bottom.ItemBuilder;
import com.tepth.latte.ec.main.cart.ShopCartDelegate;
import com.tepth.latte.ec.main.index.IndexDelegate;
import com.tepth.latte.ec.main.personal.PersonalDelegate;
import com.tepth.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BaseBottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BaseBottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
