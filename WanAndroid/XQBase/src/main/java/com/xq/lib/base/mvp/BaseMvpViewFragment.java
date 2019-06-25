package com.xq.lib.base.mvp;

import com.xq.lib.base.BaseFragment;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 12:34
 */
public abstract class BaseMvpViewFragment<P extends IAppMVPContract.IPresenter> extends BaseFragment implements IAppMVPContract.IView {
  P mPresenter;

  public P getPresenter() {
    if (mPresenter == null) {
      mPresenter = MVPComponent.getPresenter(this);
      mPresenter.initData(getActivity().getIntent());
    }
    return mPresenter;
  }

  @Override
  public void onResume() {
    super.onResume();
    getPresenter().onResume();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    getPresenter().unSubscribe();
  }
}
