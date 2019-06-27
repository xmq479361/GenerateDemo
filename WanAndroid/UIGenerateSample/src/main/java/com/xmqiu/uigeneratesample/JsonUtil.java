package com.xmqiu.uigeneratesample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.xmqiu.uigenerate.entity.AlignValue;
import com.xmqiu.uigenerate.entity.Color;

import java.lang.reflect.Type;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class JsonUtil {
    static Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(AlignValue.class, new AlignValueEnumSerializer());
        gsonBuilder.registerTypeAdapter(Color.class, new ColorSerializer());
        gson = gsonBuilder.create();
    }

    public static <T>  T fromJson(String json, Type type){
        return gson.fromJson(json, type);
    }
    public static <T>  T fromJson(String json, Class<T> tClass){
        return gson.fromJson(json, tClass);
    }

    public static <T> T fromJson(JsonElement json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }
    public static <T> T fromJson(JsonElement json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    static class AlignValueEnumSerializer implements JsonSerializer<AlignValue>, JsonDeserializer<AlignValue> {
        @Override
        public JsonElement serialize(AlignValue state, Type arg1, JsonSerializationContext arg2) {
            return new JsonPrimitive(state.ordinal());
        }

        @Override
        public AlignValue deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context) throws JsonParseException {
            if (json.getAsInt() < AlignValue.values().length) {
                return AlignValue.values()[json.getAsInt()];
            }
            return null;
        }
    }
    static class ColorSerializer implements JsonSerializer<Color>, JsonDeserializer<Color> {
        @Override
        public JsonElement serialize(Color value, Type arg1, JsonSerializationContext arg2) {
            return new JsonPrimitive(value.value);
        }

        @Override
        public Color deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context) throws JsonParseException {
            String jsonStr = json.getAsString();
            if (jsonStr.length()==7 && jsonStr.startsWith("#")) {
                return new Color(jsonStr);
            }
            return null;
        }
    }
}
