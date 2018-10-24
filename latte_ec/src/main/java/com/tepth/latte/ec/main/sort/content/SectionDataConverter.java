package com.tepth.latte.ec.main.sort.content;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/24
 */
public class SectionDataConverter {

    final List<SectionBean> convert(String json) {
        final List<SectionBean> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON.parseObject(json).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final int id = data.getInteger("id");
            final String title = data.getString("section");
            //添加标题Title
            final SectionBean sectionTitleBean = new SectionBean(true, title);
            sectionTitleBean.setId(id);
            sectionTitleBean.setMore(true);
            dataList.add(sectionTitleBean);
            //商品集合
            final JSONArray goods = data.getJSONArray("goods");
            final int goodSize = goods.size();
            for (int j = 0; j < goodSize; j++) {
                final JSONObject contentItem = goods.getJSONObject(j);
                final int goodsId = contentItem.getInteger("goods_id");
                final String goodsName = contentItem.getString("goods_name");
                final String goodsThumb = contentItem.getString("goods_thumb");
                //包装商品对象
                final SectionContentItemEntity itemEntity = new SectionContentItemEntity();
                itemEntity.setGoodsId(goodsId);
                itemEntity.setGoodsName(goodsName);
                itemEntity.setGoodsThumb(goodsThumb);
                //添加商品对象
                dataList.add(new SectionBean(itemEntity));
            }
        }
        return dataList;
    }
}
