package com.tepth.latte.ec.main.sort.content;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/24
 */
class SectionContentItemEntity {

    private int mGoodsId = 0;
    private String mGoodsName = null;
    private String mGoodsThumb = null;

    int getGoodsId() {
        return mGoodsId;
    }

    void setGoodsId(int goodsId) {
        this.mGoodsId = goodsId;
    }

    String getGoodsName() {
        return mGoodsName;
    }

    void setGoodsName(String goodsName) {
        this.mGoodsName = goodsName;
    }

    String getGoodsThumb() {
        return mGoodsThumb;
    }

    void setGoodsThumb(String goodsThumb) {
        this.mGoodsThumb = goodsThumb;
    }
}
