package com.xq.lib.base.mvp;

import com.xq.lib.base.BaseActivity;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 12:34
 */
public abstract class BaseMvpViewActivity<P extends IAppMVPContract.IPresenter> extends BaseActivity implements IAppMVPContract.IView{
  P mPresenter;

  public final P getPresenter() {
    if (mPresenter == null) {
      mPresenter = MVPComponent.getPresenter(this);
      mPresenter.initData(getIntent());
    }
    return mPresenter;
  }

  @Override
  protected void onResume() {
    super.onResume();
    getPresenter().onResume();
  }

  //  protected abstract P createModel();
  @Override
  protected void onDestroy() {
    super.onDestroy();
    getPresenter().unSubscribe();
  }
}
