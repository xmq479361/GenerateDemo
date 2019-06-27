package com.xmqiu.uigenerate.core.components;

import com.xmqiu.uigenerate.core.BaseWidget;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;
import com.xmqiu.uigenerate.core.widgets.Container;

import java.util.Collections;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:10
 */
public class AppBar extends Container {

    public AppBar() {
        super(new Locate.Linear(Locate.Linear.Oritential.Horiontal), Collections.<IWidgetDesc>emptyList());
    }

    @Override
    public String toString() {
        return "AppBar{" +
                "mLocate=" + mLocate +
                '}';
    }

    public static final class AppBarBuilder {
        BaseWidget mLeftWidget;
        BaseWidget mCenterWidget;
        BaseWidget mRightWidget;

        private AppBarBuilder() {
        }

        public static AppBarBuilder anAppBar() {
            return new AppBarBuilder();
        }

        public AppBarBuilder withMLeftWidget(BaseWidget mLeftWidget) {
            this.mLeftWidget = mLeftWidget;
            return this;
        }

        public AppBarBuilder withMCenterWidget(BaseWidget mCenterWidget) {
            this.mCenterWidget = mCenterWidget;
            return this;
        }

        public AppBarBuilder withMRightWidget(BaseWidget mRightWidget) {
            this.mRightWidget = mRightWidget;
            return this;
        }

        public AppBar build() {
            AppBar appBar = new AppBar();
            appBar.addChildren(this.mLeftWidget, this.mCenterWidget, this.mRightWidget);
            return appBar;
        }
    }
}
