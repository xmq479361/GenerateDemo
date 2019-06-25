package com.xmqiu.wanandroid.pages.register;

import com.xmqiu.wanandroid.model.net.Response;
import com.xmqiu.wanandroid.model.net.UserBean;
import com.xq.lib.base.mvp.IAppMVPContract;

import io.reactivex.Observable;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 12:44
 */
public interface IRegisterContract {
  interface View extends IAppMVPContract.IView {
    void onRegisterFail(String errorMsg);

    void onRegisterSuccess();
  }

  interface Model extends IAppMVPContract.IModel {
    Observable<Response<UserBean>> register(String username, String password, String repassword);
  }

  interface Presenter<V extends IAppMVPContract.IView, M extends IAppMVPContract.IModel>
      extends IAppMVPContract.IPresenter<V, M> {
    void register(String username, String password, String repassword);
  }

}
