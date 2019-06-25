package com.xmqiu.uigenerate.core.components;

import com.xmqiu.uigenerate.core.BaseWidget;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;
import com.xmqiu.uigenerate.core.widgets.BaseGroupWidget;
import com.xmqiu.uigenerate.core.widgets.Container;

import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:09
 */
public class Page extends BaseGroupWidget {
   private AppBar mAppBar;
   private Container mBody;


  public Page() {
//    super(new Locate.Linear(Locate.Linear.Oritential.Vertical), null);
    super(null);
  }


  @Override
  public List<IWidgetDesc> getChildren() {
    return super.getChildren();
  }

  public static final class PageBuilder {
    private AppBar mAppBar;
    private Container mBody;
    private Style mStyle;

    private PageBuilder() {
    }

    public static PageBuilder aPage() {
      return new PageBuilder();
    }

    public PageBuilder withAppBar(AppBar mAppBar) {
      this.mAppBar = mAppBar;
      return this;
    }

    public PageBuilder withBody(Container mBody) {
      this.mBody = mBody;
      return this;
    }


    public Page build() {
      Page page = new Page();
      page .addChildren(mAppBar);
      page .addChildren(mBody);
      return page;
    }
  }
}
