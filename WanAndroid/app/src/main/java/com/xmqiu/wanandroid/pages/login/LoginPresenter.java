package com.xmqiu.wanandroid.pages.login;

import android.text.TextUtils;
import android.util.Log;

import com.xmqiu.wanandroid.base.AppPresenter;
import com.xmqiu.wanandroid.common.cache.UserInfoManager;
import com.xq.lib.base.utils.LogUtil;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 9:11
 */
public class LoginPresenter extends AppPresenter<LoginActivity, LoginModel>
    implements ILoginContract.Presenter<LoginActivity, LoginModel> {

  @Override
  public void onResume() {
    super.onResume();
    getView().setUserInfo(UserInfoManager.getCacheUserName(), UserInfoManager.getCacheUserPwd());

  }

  @Override
  public LoginModel createModel() {
    return new LoginModel();
  }


  @Override
  public void login(String userName, String password) {
    if (TextUtils.isEmpty(userName)) {
      getView().userNameIsEmpty();
      return;
    }
    if (TextUtils.isEmpty(password)) {
      getView().passwordIsEmpty();
      return;
    }
    addObservable(runSync(getModel().login(userName, password))
        .doOnError(throwable -> {
          android.util.Log.e("loginError", Log.getStackTraceString(throwable));
          getView().loginFail(throwable.getMessage());
//          getView().loginFail("loginError");
        })
        .doOnNext(response -> {
          LogUtil.d("login respons:%s", response);
          LogUtil.jsonD(response);
          if (response.isSuccess() && null != response.getData()) {
            UserInfoManager.saveCacheUserName(userName);
            UserInfoManager.cacheCacheUserPwd(password);
            UserInfoManager.saveCacheUser(response.getData());
            getModel().saveCookies(response.getData());
            getView().loginSuccess();
          } else {
            getView().loginFail(response.getErrorMsg());
          }
        }));
  }

}
