package com.xmqiu.uigeneratesample.android;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xmqiu.uigeneratesample.core.ParseHolder;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class PageParser extends XQViewAndroidParse {

    @Override
    String parseType() {
        return "Page";
    }

    @Override
    public ParseHolder process(ParseHolder holder, String type, JsonObject jsonObj) {
        String name=jsonObj.get("name").getAsString();
        JsonElement children = jsonObj.get("data");
        return ParseHolder.from(holder, children);
    }
}
