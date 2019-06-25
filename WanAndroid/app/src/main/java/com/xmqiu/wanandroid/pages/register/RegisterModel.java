package com.xmqiu.wanandroid.pages.register;

import com.xmqiu.wanandroid.base.AppModel;
import com.xmqiu.wanandroid.model.net.Response;
import com.xmqiu.wanandroid.model.net.UserBean;
import com.xmqiu.wanandroid.network.NetWorkManager;

import io.reactivex.Observable;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 12:45
 */
public class RegisterModel extends AppModel implements IRegisterContract.Model {
  @Override
  public Observable<Response<UserBean>> register(String username, String password, String repassword) {
    return NetWorkManager.getRequest().register(username, password, repassword);
  }

}
