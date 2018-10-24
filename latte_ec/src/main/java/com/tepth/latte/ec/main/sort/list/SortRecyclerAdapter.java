package com.tepth.latte.ec.main.sort.list;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.tepth.latte.delegates.BaseLatteDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.main.sort.SortDelegate;
import com.tepth.latte.ec.main.sort.content.ContentDelegate;
import com.tepth.latte.ui.recycler.ItemType;
import com.tepth.latte.ui.recycler.MultipleFields;
import com.tepth.latte.ui.recycler.MultipleItemEntity;
import com.tepth.latte.ui.recycler.MultipleRecyclerAdapter;
import com.tepth.latte.ui.recycler.MultipleViewHolder;
import com.tepth.latte.utils.resources.ResourcesUtil;

import java.util.List;

import me.yokeyword.fragmentation.SupportHelper;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/24
 */
public class SortRecyclerAdapter extends MultipleRecyclerAdapter {

    private final SortDelegate DELEGATE;
    private int mPrePosition = 0;

    SortRecyclerAdapter(List<MultipleItemEntity> data, SortDelegate delegate) {
        super(data);
        this.DELEGATE = delegate;
        //添加垂直菜单布局
        addItemType(ItemType.VERTICAL_MENU_LIST, R.layout.item_vertical_menu_list);
    }

    @Override
    protected void convert(final MultipleViewHolder holder, final MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ItemType.VERTICAL_MENU_LIST:
                final String text = entity.getField(MultipleFields.TEXT);
                final boolean isClicked = entity.getField(MultipleFields.TAG);
                final AppCompatTextView name = holder.getView(R.id.tv_vertical_item_name);
                final View line = holder.getView(R.id.view_line);
                final View itemView = holder.itemView;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final int currentPosition = holder.getAdapterPosition();
                        //当点击了新的item
                        if (mPrePosition != currentPosition) {
                            //还原之前选中的那个item
                            getData().get(mPrePosition).setField(MultipleFields.TAG, false);
                            notifyItemChanged(mPrePosition);
                            //更新选中的item状态
                            entity.setField(MultipleFields.TAG, true);
                            notifyItemChanged(currentPosition);
                            mPrePosition = currentPosition;

                            //左侧的内容ID
                            final int contentId = getData().get(currentPosition).getField(MultipleFields.ID);
                            showContent(contentId);
                        }
                    }
                });
                if (!isClicked) {
                    line.setVisibility(View.INVISIBLE);
                    name.setTextColor(ResourcesUtil.getColorFromResources(mContext, R.color.we_chat_black));
                    itemView.setBackgroundColor(ResourcesUtil.getColorFromResources(mContext, R.color.item_background));
                } else {
                    line.setVisibility(View.VISIBLE);
                    name.setTextColor(ResourcesUtil.getColorFromResources(mContext, R.color.app_main));
                    line.setBackgroundColor(ResourcesUtil.getColorFromResources(mContext, R.color.app_main));
                    itemView.setBackgroundColor(Color.WHITE);
                }
                holder.setText(R.id.tv_vertical_item_name, text);
                break;
            default:
                break;
        }
    }

    /**
     * 根据Id显示右侧Fragment
     *
     * @param contentId 要显示Fragment的Id
     */
    private void showContent(int contentId) {
        final ContentDelegate delegate = ContentDelegate.newInstance(contentId);
        switchContent(delegate);
    }

    /**
     * 切换右侧的Fragment
     *
     * @param delegate 要切换的Fragment
     */
    private void switchContent(ContentDelegate delegate) {
        final BaseLatteDelegate contentDelegate =
                SupportHelper.findFragment(DELEGATE.getChildFragmentManager(), ContentDelegate.class);
        if (contentDelegate != null) {
            contentDelegate.getSupportDelegate().replaceFragment(delegate, false);
        }
    }
}
