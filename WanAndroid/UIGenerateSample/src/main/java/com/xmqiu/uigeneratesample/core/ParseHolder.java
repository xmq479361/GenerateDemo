package com.xmqiu.uigeneratesample.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class ParseHolder implements ParseInfo<List<JsonObject>> {
    public List<JsonObject> childrenObj = new ArrayList<JsonObject>();
    public OutputStream outputStream;
    public ParseHolder(OutputStream outputStream){
        this.outputStream =outputStream;
    }

    public ParseHolder(ParseHolder baseHolder) {
        this(baseHolder.outputStream);
    }


    public static ParseHolder from(ParseHolder baseHolder, JsonElement jsonObj) {
        ParseHolder holder = new ParseHolder(baseHolder);
        holder.childrenObj.addAll(_parse(jsonObj));
        return holder;
    }

    static List<JsonObject> _parse(JsonElement children) {
        List<JsonObject> childrenObj = new ArrayList<JsonObject>();
        if (children == null) {
            return childrenObj;
        }
        if (children.isJsonObject()) {
            childrenObj.add(children.getAsJsonObject());
        } else {
            JsonArray jsonArray = children.getAsJsonArray();
            Iterator<JsonElement> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JsonElement next = iterator.next();
                childrenObj.addAll(_parse(next));
            }
        }
        return childrenObj;
    }

    @Override
    public List<JsonObject> obj() {
        return childrenObj;
    }
}
