package com.xmqiu.wanandroid.pages.main.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xmqiu.wanandroid.R;
import com.xmqiu.wanandroid.base.AppMvpFragment;
import com.xmqiu.wanandroid.common.GlideImageLoader;
import com.xmqiu.wanandroid.common.adapter.ArticleAdapter;
import com.xmqiu.wanandroid.model.net.ArticleBean;
import com.xmqiu.wanandroid.model.net.BannerBean;
import com.xq.lib.base.utils.LogUtil;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/26 2:16
 */
public class HomeFragment extends AppMvpFragment<IHomeContract.Presenter>
    implements IHomeContract.View {
  @BindView(R.id.recyclerView)
  RecyclerView mRecyclerView;
  @BindView(R.id.refreshLayout)
  SmartRefreshLayout mRefreshLayout;

  ArticleAdapter mAdatper;

  @Override
  public IHomeContract.Presenter createPresenter() {
    return new HomePresenter();
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_home;
  }

  //  /**
//   * 图片轮播的复杂使用【参数配置】
//   */
  @Override
  public void showBanner(List<BannerBean> mData) {
//    mBanner.setSource(mData).startScroll();
    //设置图片集合
    mBanner.setImages(mData);
    //banner设置方法全部调用完毕时最后调用
    mBanner.start();
  }

  @Override
  public void setNewData(List<ArticleBean> datas) {
    mRefreshLayout.finishRefresh();
    mAdatper.setNewData(datas);
  }

  @Override
  public void onRefreshFailed(Throwable throwable) {
    mRefreshLayout.finishRefresh();
    LogUtil.w("onRefreshFailed", throwable);
//    SnackbarUtil
//    SnackbarUtils.Short(mRecyclerView, "刷新数据失败，请稍候重试！").warning().show();
  }

  @Override
  public void onLoadMoreFailed(Throwable throwable) {
    mRefreshLayout.finishLoadMore();
    LogUtil.w("onLoadMoreFailed", throwable);
//    SnackbarUtils.Short(mRecyclerView, "加载数据失败，请稍候重试！").warning().show();
  }

  @Override
  public void addDatas(List<ArticleBean> datas) {
    mRefreshLayout.finishLoadMore();
    mAdatper.addData(datas);
  }

  Banner mBanner;

  @Override
  public void initView(Bundle saveInstanceState, View contentView) {
    initList();
    mBanner = (Banner) getLayoutInflater().inflate(R.layout.item_banner_article, mRecyclerView, false);
    //设置图片加载器
    mBanner.setImageLoader(new GlideImageLoader());
    mAdatper.addHeaderView(mBanner);
  }

  @Override
  public void doBusiness() {
    mRefreshLayout.autoRefresh();
    getPresenter().getBanner();
  }

  private void initList() {
    mAdatper = new ArticleAdapter();
    mRecyclerView.setAdapter(mAdatper);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    mRefreshLayout.setOnRefreshListener(refreshlayout -> getPresenter().doRefresh());
    mRefreshLayout.setOnLoadMoreListener(refreshlayout -> getPresenter().doLoadMore());

  }
}
