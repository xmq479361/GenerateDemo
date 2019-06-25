package com.xmqiu.uigenerate.core.widgets;

import com.xmqiu.uigenerate.core.components.Style;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:57
 */
public class Text extends BaseSingleWidget {
  public String value;
  public Text(String value,Style style){
    super(style);
    this.value = value;
  }

  @Override
  public String toString() {
    return "Text{" +
        "value='" + value + '\'' +
        '}';
  }
}
