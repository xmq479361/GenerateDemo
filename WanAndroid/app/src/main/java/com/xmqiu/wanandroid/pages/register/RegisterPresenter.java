package com.xmqiu.wanandroid.pages.register;

import android.text.TextUtils;

import com.xmqiu.wanandroid.base.AppPresenter;
import com.xmqiu.wanandroid.common.cache.UserInfoManager;
import com.xq.lib.base.utils.LogUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 13:16
 */
public class RegisterPresenter extends AppPresenter<RegisterActivity, RegisterModel>
    implements IRegisterContract.Presenter<RegisterActivity, RegisterModel> {
  @Override
  public void register(String username, String password, String repassword) {
    addObservable(getModel().register(username, password, repassword)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .doOnNext(response -> {
          LogUtil.d("register respons:%s", response);
          LogUtil.d(response);
          if (null != response && null != response.getData() && response.isSuccess()) {
            if (TextUtils.isEmpty(UserInfoManager.getCacheUserName())) {
              UserInfoManager.saveCacheUserName(username);
            }
            getView().onRegisterSuccess();
            return;
          }
          getView().onRegisterFail(response.getErrorMsg());
        }).doOnError(throwable -> {
          getView().onRegisterFail(throwable.getMessage());
        }));
  }


  @Override
  public RegisterModel createModel() {
    return new RegisterModel();
  }

}
