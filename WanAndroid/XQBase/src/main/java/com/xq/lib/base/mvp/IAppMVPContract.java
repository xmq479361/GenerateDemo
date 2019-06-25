package com.xq.lib.base.mvp;

import android.content.Intent;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 0:46
 */
public interface IAppMVPContract {
  /**
   * MVP interface IPresenter
   */
  interface IPresenter<V extends IAppMVPContract.IView, M extends IAppMVPContract.IModel> {
    void unSubscribe();

    void subscribeOn();

    void onResume();

    M createModel();

    void inject(V view, M model);

    void initData(Intent intent);
  }

  interface IView {
    boolean isFinish();

    <P extends IPresenter> P createPresenter();
  }

  interface IModel {

  }
}
