package com.xq.lib.base.mvp;

import android.content.Intent;

import com.xq.lib.base.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 0:49
 */
public abstract class BasePresenter<V extends IAppMVPContract.IView, M extends IAppMVPContract.IModel> {
  protected String TAG = getClass().getSimpleName();
  private M mModel;
  private V mView;
  List<Disposable> mDisposables = new ArrayList<>();

  public void inject(V view, M model) {
    this.mModel = model;
    this.mView = view;
  }

  public void initData(Intent intent) {
  }

  protected M getModel() {
    return mModel;
  }

  public V getView() {
    return mView;
  }

  public <T> Observable<T> runSync(Observable<T> observable) {
    return observable
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io());
  }

  public void addObservable(Observable observable) {
    this.mDisposables.add(observable.subscribe());
  }

  public void addSubscribe(Disposable disposable) {
    this.mDisposables.add(disposable);
  }

  public void onResume() {

  }

  public void unSubscribe() {
    if (null != this.mDisposables) {
      for (Disposable disposable : this.mDisposables) {
        if (null == disposable || disposable.isDisposed()) {
          continue;
        }
        LogUtil.d("%s unSubscribe ", TAG, disposable);
        disposable.dispose();
      }
    }
    this.mView = null;
    this.mModel = null;
  }

  public void subscribeOn() {

  }
}
