package com.xmqiu.uigeneratesample;

import com.xmqiu.uigenerate.core.Config;
import com.xmqiu.uigenerate.core.UIWidgetAgent;
import com.xmqiu.uigenerate.core.components.AppBar;
import com.xmqiu.uigenerate.core.components.Locate;
import com.xmqiu.uigenerate.core.components.Page;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;
import com.xmqiu.uigenerate.core.widgets.Container;
import com.xmqiu.uigenerate.core.widgets.Text;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    IWidgetDesc widgetDesc = loadWidgetDesc();



    UIWidgetAgent.addGenerate(new AndroidGenerate());
    UIWidgetAgent.process(new Config(), widgetDesc);
  }

  private static IWidgetDesc loadWidgetDesc() {
    Page widgetDesc =  Page.PageBuilder.aPage()
        .withAppBar(loadAppBar())
        .build();

    return widgetDesc;
  }

  private static AppBar loadAppBar() {
    return AppBar.AppBarBuilder.anAppBar()
        .withMLeftWidget(
            Container.linear(
                Locate.Linear.Oritential.Horiontal,
                Arrays.<IWidgetDesc>asList(new Text("back", null))
            )
        )
        .withMCenterWidget(
            Container.linear(
                Locate.Linear.Oritential.Horiontal,
                Arrays.<IWidgetDesc>asList(new Text("Title", null))
            )
        )
        .build();
  }
}
