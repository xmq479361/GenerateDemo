package com.xmqiu.uigenerate.core.widgets;

import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:57
 */
public class EditText extends Text{

  public EditText(String value, Style style) {
    super(value, style);
  }

  @Override
  public String toString() {
    return "EditText{" +
        "text='" + text + '\'' +
            ", hint='" + hint + '\'' +
        '}';
  }

  public EditText hint(String hint) {
    this.hint = hint;
    return this;
  }
  public String hint;
}
