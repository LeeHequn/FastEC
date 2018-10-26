package com.tepth.latte.ec.main.personal.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tepth.latte.ui.recycler.BaseDataConverter;
import com.tepth.latte.ui.recycler.MultipleFields;
import com.tepth.latte.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/1/25
 */

public class OrderListDataConverter extends BaseDataConverter {
    @Override
    public ArrayList<MultipleItemEntity> convert() {

        final JSONArray array = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = array.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = array.getJSONObject(i);
            final String thumb = data.getString("thumb");
            final String title = data.getString("title");
            final int id = data.getInteger("id");
            final double price = data.getDouble("price");
            final String time = data.getString("time");

            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setItemType(OrderListItemType.ITEM_ORDER_LIST)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.IMAGE_URL, thumb)
                    .setField(MultipleFields.TITLE, title)
                    .setField(OrderItemFields.PRICE, price)
                    .setField(OrderItemFields.TIME, time)
                    .builder();
            ENTITIES.add(entity);
        }
        return ENTITIES;
    }
}
