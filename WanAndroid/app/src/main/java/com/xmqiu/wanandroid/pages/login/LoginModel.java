package com.xmqiu.wanandroid.pages.login;


import com.xmqiu.wanandroid.base.AppModel;
import com.xmqiu.wanandroid.model.net.UserBean;
import com.xmqiu.wanandroid.model.net.Response;
import com.xmqiu.wanandroid.network.NetWorkManager;

import io.reactivex.Observable;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 9:14
 */
public class LoginModel extends AppModel implements ILoginContract.Model {
  @Override
  public Observable<Response<UserBean>> login(String userName, String password) {
    return NetWorkManager.getRequest().login(userName, password);
  }

  @Override
  public void saveCookies(UserBean bean) {

  }
}
