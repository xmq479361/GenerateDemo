package com.xmqiu.wanandroid.pages.main.home;

import com.xmqiu.wanandroid.model.net.ArticleBean;
import com.xmqiu.wanandroid.model.net.BannerBean;
import com.xmqiu.wanandroid.model.net.PageBean;
import com.xmqiu.wanandroid.model.net.Response;
import com.xq.lib.base.mvp.IAppMVPContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/26 2:13
 */
public interface IHomeContract {

  interface View extends IAppMVPContract.IView {

    void showBanner(List<BannerBean> mData);

    void setNewData(List<ArticleBean> datas);

    void onRefreshFailed(Throwable throwable);

    void addDatas(List<ArticleBean> datas);

    void onLoadMoreFailed(Throwable throwable);
  }

  interface Presenter<V extends IAppMVPContract.IView, M extends IAppMVPContract.IModel>
      extends IAppMVPContract.IPresenter<V, M> {
    void onClickBanner(int position);

    void doRefresh();

    void doLoadMore();

    void getBanner();
  }

  interface Model extends IAppMVPContract.IModel {
    Observable<Response<List<BannerBean>>> getBanner();

    Observable<Response<PageBean<ArticleBean>>> getArticle(int pageNo);
  }
}
