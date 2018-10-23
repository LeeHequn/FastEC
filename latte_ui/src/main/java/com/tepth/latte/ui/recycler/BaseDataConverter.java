package com.tepth.latte.ui.recycler;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
public abstract class BaseDataConverter {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    /**
     * 数据转换的方法
     *
     * @return 返回数据转换出来的Entity集合
     */
    public abstract ArrayList<MultipleItemEntity> convert();

    /**
     * 设置JSON数据
     *
     * @param json JSON字符串
     * @return 数据转换器基类
     */
    public BaseDataConverter setJsonData(String json) {
        mJsonData = json;
        return this;
    }

    /**
     * 获取JSON数据
     *
     * @return JSON字符串
     */
    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS NULL!");
        }
        return mJsonData;
    }

    /**
     * 清理数据
     */
    public void clearData() {
        ENTITIES.clear();
    }
}
