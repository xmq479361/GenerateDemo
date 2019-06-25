package com.xmqiu.wanandroid.pages.register;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xmqiu.wanandroid.R;
import com.xmqiu.wanandroid.base.AppActivity;
import com.xmqiu.wanandroid.base.AppMvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 12:54
 */
public class RegisterActivity extends AppMvpActivity<IRegisterContract.Presenter> implements IRegisterContract.View {
  @BindView(R.id.id_logreg_uname)
  EditText mEdtUName;
  @BindView(R.id.id_logreg_password)
  EditText mEdtPwd;
  @BindView(R.id.id_logreg_password_again)
  EditText mEdtPwdAgain;
//  @BindView(R.id.id_logreg_btn_sure)
//  Button mBtnSure;


  @Override
  public int getLayoutId() {
    return R.layout.activity_register;
  }

  @OnClick({R.id.id_logreg_btn_sure})
  public void onViewClicked(View view) {
    Toast.makeText(getBaseContext(), "hahshs", Toast.LENGTH_LONG).show();
    getPresenter().register(getTextStr(mEdtUName), getTextStr(mEdtPwd), getTextStr(mEdtPwdAgain));
  }

  @Override
  public void onRegisterSuccess() {
    showToast(R.string.text_reg_reimnd_success);
  }

  @Override
  public void onRegisterFail(String errorMsg) {
    showToast(getString(R.string.text_reg_reimnd_failed) + errorMsg);
  }

  @Override
  public IRegisterContract.Presenter createPresenter() {
    return new RegisterPresenter();
  }

  public final static void launch(Activity appActivity) {
    appActivity.startActivity(new Intent(appActivity, RegisterActivity.class));
  }

}
