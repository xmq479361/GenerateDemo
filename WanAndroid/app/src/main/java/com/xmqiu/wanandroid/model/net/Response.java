package com.xmqiu.wanandroid.model.net;

import com.google.gson.Gson;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 8:24
 * 网络请求
 */
public class Response<T> {
  final static int CODE_USER_REGISTER = -1;
//  {
//    "data": null,
//      "errorCode": -1,
//      "errorMsg": "用户名已经被注册！"
//  }

  public String errorMsg;
  public int errorCode;
  public T data;

  public boolean isSuccess() {
    return errorCode == 0;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    errorMsg = errorMsg;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    errorCode = errorCode;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
//    "Response{" +
//        "mErrorMsg='" + mErrorMsg + '\'' +
//        ", mErrorCode=" + mErrorCode +
//        ", mData=" + mData +
//        '}';
  }
}
