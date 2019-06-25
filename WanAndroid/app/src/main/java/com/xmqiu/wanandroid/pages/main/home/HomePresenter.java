package com.xmqiu.wanandroid.pages.main.home;

import android.content.Intent;

import com.blankj.utilcode.util.ToastUtils;
import com.xmqiu.wanandroid.base.AppPresenter;
import com.xq.lib.base.utils.LogUtil;
import com.xmqiu.wanandroid.model.net.BannerBean;

import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/26 2:54
 */
public class HomePresenter extends AppPresenter<HomeFragment, HomeModel>
    implements IHomeContract.Presenter<HomeFragment, HomeModel> {
  final static int PAGE_START = 0;
  List<BannerBean> mBannerBeans;
  int pageNo = PAGE_START;

  @Override
  public void getBanner() {
    if (null != mBannerBeans) {
//      List<BannerItem> banners = new ArrayList<>(mBannerBeans.size());
//      for (BannerBean bannerBean : mBannerBeans) {
//        banners.add(new BannerItem().setTitle(bannerBean.getTitle()).setImgUrl(bannerBean.getImagePath()));
//      }
//      getView().showBanner(banners);
      getView().showBanner(mBannerBeans);
      return;
    }
    addObservable(runSync(getModel().getBanner())
        .map(response -> {
          LogUtil.i("getBanner: %s", response);
//          mBannerBeans = response.getData();
//          List<BannerItem> banners = new ArrayList<>(mBannerBeans.size());
//          for (BannerBean bannerBean : mBannerBeans) {
//            banners.add(new BannerItem().setTitle(bannerBean.getTitle()).setImgUrl(bannerBean.getImagePath()));
//          }
//          return banners;
          return mBannerBeans =response.getData();
        })
        .doOnNext(banners -> getView().showBanner(banners))
        .doOnError(throwable -> LogUtil.e("getBannerFailed", throwable)));
  }

  @Override
  public void doRefresh() {
    addObservable(handleEmtyObservable(runSync(getModel().getArticle(pageNo = PAGE_START)))
        .doOnNext(articles -> getView().setNewData(articles))
        .doOnError(throwable -> getView().onRefreshFailed(throwable)));
  }

  @Override
  public void doLoadMore() {
    addObservable(handleEmtyObservable(runSync(getModel().getArticle(++pageNo)))
        .doOnNext(articles -> getView().addDatas(articles))
        .doOnError(throwable -> getView().onLoadMoreFailed(throwable)));
  }

  @Override
  public void onClickBanner(int position) {
    ToastUtils.showShort("position--->" + position);
    mBannerBeans.get(position);
  }

  @Override
  public void initData(Intent intent) {
    super.initData(intent);
    getBanner();
  }

  @Override
  public HomeModel createModel() {
    return new HomeModel();
  }

}
