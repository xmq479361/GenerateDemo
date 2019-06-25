package com.xq.lib.base;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/30 13:09
 */
public abstract class BaseLazyFragment extends BaseFragment {

  private boolean isDataLoaded = false;

  abstract void doLazyBusiness();

  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (isVisibleToUser && !isDataLoaded) {
      doLazyBusiness();
      isDataLoaded = true;
    }
  }

  @Override
  public void doBusiness() {
    if (getUserVisibleHint()) {
      doLazyBusiness();
      isDataLoaded = true;
    }
  }
}
