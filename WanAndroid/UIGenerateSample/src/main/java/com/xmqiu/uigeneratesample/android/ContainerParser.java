package com.xmqiu.uigeneratesample.android;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xmqiu.uigeneratesample.core.ParseHolder;
import com.xmqiu.uigeneratesample.parse.BaseJsonViewParser;
import com.xmqiu.uigeneratesample.parse.XQParseResult;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class ContainerParser extends XQViewAndroidParse {


    @Override
    String parseType() {
        return "Container";
    }

    @Override
    public ParseHolder process(ParseHolder holder, String type, JsonObject jsonObj) {
        String name=jsonObj.get("width").getAsString();
        JsonElement children = jsonObj.get("children");
        return ParseHolder.from(holder, children);
    }
}
