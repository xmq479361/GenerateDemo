package com.xmqiu.uigenerate.entity.widgets;

import com.xmqiu.uigenerate.entity.Color;
import com.xmqiu.uigenerate.entity.Gravity;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class Text extends Widget {
    public String text;
    public Gravity gravity;
    public int textSize;
    public Color textColor;
    public String type ="Text";

    @Override
    public String toString() {
        return "Text{" +
                super.toString()+
                ", text='" + text + '\'' +
                ", gravity=" + gravity +
                ", textSize=" + textSize +
                ", textColor=" + textColor +
                '}';
    }
}
