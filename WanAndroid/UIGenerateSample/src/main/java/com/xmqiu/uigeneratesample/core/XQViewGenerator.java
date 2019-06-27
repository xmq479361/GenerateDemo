package com.xmqiu.uigeneratesample.core;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.xmqiu.uigeneratesample.android.ContainerParser;
import com.xmqiu.uigeneratesample.android.PageParser;
import com.xmqiu.uigeneratesample.android.TextParser;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class XQViewGenerator {
    static XQViewCoreAdapter adapter = new XQViewCoreAdapter();

    static {
        adapter.addViewParse(new ContainerParser());
        adapter.addViewParse(new PageParser());
        adapter.addViewParse(new TextParser());
    }
    public static void processJson(String jsonStr){

        adapter.processJsonData(jsonStr);
    }
}
