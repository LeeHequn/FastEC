package com.tepth.latte.ui.recycler;

import java.util.LinkedHashMap;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
public class MultipleEntityBuilder {

    private static final LinkedHashMap<Object, Object> FIELDS = new LinkedHashMap<>();

    MultipleEntityBuilder() {
        //先清除之前存储的数据
        FIELDS.clear();
    }

    public final MultipleEntityBuilder setItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE, itemType);
        return this;
    }

    public final MultipleEntityBuilder setField(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }

    public final MultipleEntityBuilder setFields(LinkedHashMap<?, ?> map) {
        FIELDS.putAll(map);
        return this;
    }

    public final MultipleItemEntity builder() {
        return new MultipleItemEntity(FIELDS);
    }
}
