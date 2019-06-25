package com.xmqiu.wanandroid.base;

import com.xmqiu.wanandroid.model.net.PageBean;
import com.xmqiu.wanandroid.model.net.Response;
import com.xq.lib.base.mvp.BasePresenter;
import com.xq.lib.base.mvp.IAppMVPContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/29 12:42
 */
public class AppPresenter<V extends IAppMVPContract.IView, M extends IAppMVPContract.IModel> extends BasePresenter<V, M> {


  protected <T> Observable<List<T>> handleEmtyObservable(Observable<Response<PageBean<T>>> observable) {
    return observable.map(response -> {
      if (null == response.getData()) {
        throw new UnknownError();
      }
//          List<ArticleBean> articles = response.getData().getDatas();
//          pageNo = response.getData().getCurPage();
//          return articles;
      return response.getData().getDatas();
    });
  }
}