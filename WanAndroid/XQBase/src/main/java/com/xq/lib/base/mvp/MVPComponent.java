package com.xq.lib.base.mvp;

import java.util.HashMap;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/28 12:11
 */
public class MVPComponent {
  static HashMap<Class, IAppMVPContract.IPresenter> presenterProvider = new HashMap<>();
  static HashMap<Class, IAppMVPContract.IModel> modelProvider = new HashMap<>();

  public static <P extends IAppMVPContract.IPresenter, M extends IAppMVPContract.IModel> M getModel(P presenter) {
    M appModel = null;
    Class clzz = presenter.getClass();
    if (modelProvider.containsKey(clzz)) {
      appModel = (M) modelProvider.get(clzz);
    }
    if (appModel == null) {
      appModel = (M) presenter.createModel();
      modelProvider.put(clzz, appModel);
    }
    return appModel;
  }

//  public static <M extends IAppMVPContract.IModel> void cacheModel(Class clzz, M model) {
//    modelProvider.put(clzz, model);
//  }

  public static <P extends IAppMVPContract.IPresenter, V extends IAppMVPContract.IView> P getPresenter(V view) {
    P appPresenter = null;
    Class clzz = view.getClass();
    if (presenterProvider.containsKey(clzz)) {
//      mPresenter = createPresenter();
      appPresenter = (P) presenterProvider.get(clzz);
    }
    if (appPresenter == null) {
      appPresenter = view.createPresenter();
      presenterProvider.put(clzz, appPresenter);
    }
    appPresenter.inject(view, MVPComponent.getModel(appPresenter));
    return appPresenter;
  }

//  public static <P extends IAppMVPContract.IPresenter> void cachePresenter(Class clzz, P presenter) {
//    presenterProvider.put(clzz, presenter);
//  }
}
