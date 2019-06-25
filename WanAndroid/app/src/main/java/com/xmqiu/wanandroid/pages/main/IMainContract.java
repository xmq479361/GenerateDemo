package com.xmqiu.wanandroid.pages.main;


import com.xq.lib.base.mvp.IAppMVPContract;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/26 3:00
 */
public interface IMainContract {
  interface View extends IAppMVPContract.IView{
//    void loginSuccess();
//
//    void loginFail(String errorMsg);
//
//    void userNameIsEmpty();
//
//    void passwordIsEmpty();
//
//    void setUserName(String uname);
  }

  interface Presenter extends IAppMVPContract.IPresenter {
//    void login(String userName, String password);
  }

  interface Model extends IAppMVPContract.IModel {
//    Observable<Response<UserBean>> login(String userName, String password);

  }
}
