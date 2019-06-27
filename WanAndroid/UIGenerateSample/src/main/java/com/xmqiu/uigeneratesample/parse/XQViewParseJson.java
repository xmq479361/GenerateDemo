package com.xmqiu.uigeneratesample.parse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xmqiu.uigeneratesample.core.ParseHolder;

import java.util.Iterator;
import java.util.List;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public abstract class XQViewParseJson<R extends ParseHolder> implements XQViewParse<R, JsonObject> {
    public int getInt(JsonObject jsonObj, String key) {
        if(jsonObj==null ||  !jsonObj.has(key)){
            return 0;
        }
        return jsonObj.get(key).getAsInt();
    }
    public String getString(JsonObject jsonObj, String key) {
        if(jsonObj==null || !jsonObj.has(key)){
            return "";
        }
        return jsonObj.get(key).getAsString();
    }
    public boolean getBool(JsonObject jsonObj, String key) {
        if(jsonObj==null ||  !jsonObj.has(key)){
            return false;
        }
        return jsonObj.get(key).getAsBoolean();
    }
    public float getFloat(JsonObject jsonObj, String key) {
        if(jsonObj==null ||  !jsonObj.has(key)){
            return -1f;
        }
        return jsonObj.get(key).getAsFloat();
    }
    public JsonArray getList(JsonObject jsonObj, String key) {
        if(jsonObj==null || !jsonObj.has(key)){
            return null;
        }
        return jsonObj.get(key).getAsJsonArray();
    }
    public JsonObject getObj(JsonObject jsonObj, String key) {
        if(jsonObj==null || !jsonObj.has(key)){
            return null;
        }
        return jsonObj.get(key).getAsJsonObject();
    }
//    private List<List<JsonElement>> getListArray(JsonObject jsonObj, String key) {
//        JsonArray list = getList(jsonObj, key);
//        Iterator<JsonElement> iterator = list.iterator();
//        while(iterator.hasNext()){
//            JsonElement next = iterator.next();
//        }
//        return null;
//    }
//    public int getInt(JsonObject jsonObj, String key) {
//        return jsonObj.get(key).getAsInt();
//    }
//    public int getInt(JsonObject jsonObj, String key) {
//        return jsonObj.get(key).getAsInt();
//    }
}
