package com.xmqiu.uigenerate.core.widgets;

import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.entity.Gravity;
import com.xmqiu.uigenerate.entity.Color;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:57
 */
public class Text extends BaseSingleWidget {
  public String text;
  public Gravity gravity;
  public int textSize;
  public Color textColor;
  public String type ="Text";
  public Text(String text,Style style){
    super(style);
    this.text = text;
  }

  @Override
  public String toString() {
    return "Text{" +
        "text='" + text + '\'' +
        '}';
  }
}
