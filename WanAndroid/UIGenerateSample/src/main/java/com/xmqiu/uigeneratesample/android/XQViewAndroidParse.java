package com.xmqiu.uigeneratesample.android;

import com.google.gson.JsonObject;
import com.xmqiu.uigeneratesample.core.ParseHolder;
import com.xmqiu.uigeneratesample.parse.XQViewParseJson;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public abstract class XQViewAndroidParse extends XQViewParseJson<ParseHolder> {
    abstract String parseType();
    @Override
    public boolean isProcess(String type, JsonObject data) {
        if(type ==null || null == parseType()){
            return false;
        }
        return type.toLowerCase().equals(parseType().toLowerCase());
    }
}
