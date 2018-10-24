package com.tepth.latte.ec.main.sort.content;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/24
 */
public class SectionBean extends SectionEntity<SectionContentItemEntity> {

    private boolean mIsMore = false;
    private int mId = -1;

    public boolean isMore() {
        return mIsMore;
    }

    public void setMore(boolean more) {
        mIsMore = more;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    SectionBean(SectionContentItemEntity sectionContentItemEntity) {
        super(sectionContentItemEntity);
    }
}
