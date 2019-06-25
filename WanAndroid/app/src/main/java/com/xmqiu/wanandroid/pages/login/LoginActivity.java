package com.xmqiu.wanandroid.pages.login;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xmqiu.wanandroid.R;
import com.xmqiu.wanandroid.base.AppActivity;
import com.xmqiu.wanandroid.base.AppMvpActivity;
import com.xmqiu.wanandroid.pages.main.MainActivity;
import com.xmqiu.wanandroid.pages.register.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 1:10
 */
public class LoginActivity extends AppMvpActivity<ILoginContract.Presenter> implements ILoginContract.View {

  @BindView(R.id.id_logreg_uname)
  EditText mEdtUName;
  @BindView(R.id.id_logreg_password)
  EditText mEdtPassword;
  @BindView(R.id.id_logreg_btn_sure)
  Button mBtnSure;
  @BindView(R.id.id_logreg_click_to_reg)
  TextView mTextView;

  @Override
  public int getLayoutId() {
    return R.layout.activity_login;
  }

  @Override
  public void setUserInfo(String userName, String userPwd) {
    mEdtUName.setText(userName);
    mEdtPassword.setText(userPwd);
  }

  @Override
  public void loginSuccess() {
    MainActivity.launch(this);
  }

  @Override
  public void loginFail(String errorMsg) {
    showToast(getString(R.string.text_login_reimnd_failed) + errorMsg);
  }

  @Override
  public void userNameIsEmpty() {
    showToast(R.string.text_login_remind_empty_username);
  }

  @Override
  public void passwordIsEmpty() {
    showToast(R.string.text_login_remind_empty_password);
  }

  public static void launch(AppActivity context) {
    Intent intent = new Intent(context, LoginActivity.class);
    context.startActivity(intent);
  }

  @Override
  public ILoginContract.Presenter createPresenter() {
    return new LoginPresenter();
  }


  @OnClick(R.id.id_logreg_btn_sure)
  public void onIdLogregBtnSureClicked() {
    getPresenter().login(getTextStr(mEdtUName), getTextStr(mEdtPassword));
  }

  @OnClick(R.id.id_logreg_click_to_reg)
  public void onIdLogregClickToRegClicked() {
    RegisterActivity.launch(this);
    finish();
  }

}
