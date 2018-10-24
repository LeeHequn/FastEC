package com.tepth.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.joanzapata.iconify.widget.IconTextView;
import com.tepth.latte.delegates.bottom.BaseBottomItemDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.R2;
import com.tepth.latte.ec.main.EcBottomDelegate;
import com.tepth.latte.ui.refresh.RefreshHandler;
import com.tepth.latte.utils.resources.ResourcesUtil;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.BindView;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public class IndexDelegate extends BaseBottomItemDelegate {

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;

    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;

    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;

    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;

    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;

    private RefreshHandler mRefreshHandler = null;

    /**
     * 初始化下拉刷新布局
     */
    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeColors(
                ResourcesUtil.getColorFromResources(getContext(), android.R.color.holo_blue_bright),
                ResourcesUtil.getColorFromResources(getContext(), android.R.color.holo_orange_light),
                ResourcesUtil.getColorFromResources(getContext(), android.R.color.holo_red_light)
        );
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
        mRefreshHandler.firstPage("index.php");
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRecyclerView();
        initRefreshLayout();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = RefreshHandler.create(mRefreshLayout, mRecyclerView, new IndexDataConvert());
    }

    private void initRecyclerView() {
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration
                .Builder(getProxyActivity())
                .color(R.color.app_main)
                .size(3)
                .build());
        final EcBottomDelegate ecBottomDelegate = getParentDelegate();
        mRecyclerView.addOnItemTouchListener(IndexItemClickListener.create(ecBottomDelegate));
//        mRecyclerView.addOnScrollListener(new BaseHidingScrollListener() {
//
//            @Override
//            public void onHide() {
//                mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
//            }
//
//            @Override
//            public void onShow() {
//                mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
//            }
//        });
    }
}
