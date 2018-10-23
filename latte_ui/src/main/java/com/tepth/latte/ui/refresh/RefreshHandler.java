package com.tepth.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tepth.latte.app.Latte;
import com.tepth.latte.net.RestClient;
import com.tepth.latte.net.callback.IFailure;
import com.tepth.latte.net.callback.ISuccess;
import com.tepth.latte.ui.recycler.BaseDataConverter;
import com.tepth.latte.ui.recycler.MultipleRecyclerAdapter;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
public class RefreshHandler implements
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean BEAN;
    private final RecyclerView RECYCLERVIEW;
    private MultipleRecyclerAdapter mAdapter = null;
    private final BaseDataConverter CONVERTER;

    private RefreshHandler(SwipeRefreshLayout refreshLayout,
                           RecyclerView recyclerView,
                           BaseDataConverter converter,
                           PagingBean bean) {
        this.REFRESH_LAYOUT = refreshLayout;
        this.RECYCLERVIEW = recyclerView;
        this.CONVERTER = converter;
        this.BEAN = bean;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static RefreshHandler create(SwipeRefreshLayout refreshLayout,
                                        RecyclerView recyclerView,
                                        BaseDataConverter converter) {
        return new RefreshHandler(refreshLayout, recyclerView, converter, new PagingBean());
    }

    @Override
    public void onRefresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //这里请求一些网络操作
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    /**
     * 加载第一页方法
     *
     * @param url 加载链接
     */
    public void firstPage(String url) {
        BEAN.setDelayed(1000);
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        JSONObject object = JSONObject.parseObject(response);
                        BEAN.setTotal(object.getInteger("total"))
                                .setPageIndex(object.getInteger("page_size"));
                        mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this, RECYCLERVIEW);
                        RECYCLERVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .builder()
                .get();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
