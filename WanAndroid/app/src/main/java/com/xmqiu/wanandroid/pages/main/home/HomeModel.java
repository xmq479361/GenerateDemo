package com.xmqiu.wanandroid.pages.main.home;

import com.xmqiu.wanandroid.base.AppModel;
import com.xmqiu.wanandroid.model.net.ArticleBean;
import com.xmqiu.wanandroid.model.net.BannerBean;
import com.xmqiu.wanandroid.model.net.PageBean;
import com.xmqiu.wanandroid.model.net.Response;
import com.xmqiu.wanandroid.network.NetWorkManager;
import com.xq.lib.base.mvp.BaseModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/26 2:15
 */
public class HomeModel extends AppModel implements IHomeContract.Model {
//  Response<List<BannerBean>> mBannerResponse;

  @Override
  public Observable<Response<List<BannerBean>>> getBanner() {
//    if (null != mBannerResponse) {
//      return Observable.create(e -> e.onNext(mBannerResponse));
//    }
    return NetWorkManager.getRequest().getBanner();
  }

  @Override
  public Observable<Response<PageBean<ArticleBean>>> getArticle(int pageNo) {
    return NetWorkManager.getRequest().getArticles(String.valueOf(pageNo));
  }
}
