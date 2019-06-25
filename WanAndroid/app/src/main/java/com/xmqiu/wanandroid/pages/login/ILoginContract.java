package com.xmqiu.wanandroid.pages.login;

import com.xmqiu.wanandroid.model.net.Response;
import com.xmqiu.wanandroid.model.net.UserBean;
import com.xq.lib.base.mvp.IAppMVPContract;

import io.reactivex.Observable;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 8:41
 */
public interface ILoginContract {
  interface View extends IAppMVPContract.IView {
    void loginSuccess();

    void loginFail(String errorMsg);

    void userNameIsEmpty();

    void passwordIsEmpty();

    void setUserInfo(String userName, String userPwd);
  }

  interface Presenter<V extends IAppMVPContract.IView, M extends IAppMVPContract.IModel> extends IAppMVPContract.IPresenter<V, M> {
    void login(String userName, String password);
  }

  interface Model extends IAppMVPContract.IModel {
    Observable<Response<UserBean>> login(String userName, String password);

    void saveCookies(UserBean bean);
  }
}
