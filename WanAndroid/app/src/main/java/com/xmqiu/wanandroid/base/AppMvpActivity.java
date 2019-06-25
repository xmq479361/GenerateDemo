package com.xmqiu.wanandroid.base;

import com.xq.lib.base.mvp.BaseMvpViewActivity;
import com.xq.lib.base.mvp.IAppMVPContract;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/29 12:39
 */
public abstract class AppMvpActivity<P extends IAppMVPContract.IPresenter> extends BaseMvpViewActivity<P> {
}
