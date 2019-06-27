package com.xmqiu.uigenerate.core;

import java.io.OutputStream;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:39
 */
public class Config {
    public int deep;
    public String key;

    public Config(String key) {
        deep = 0;
        this.key = key;
    }

    public Config(String key, int deep) {
        this(key);
        this.deep = deep;
    }

    public OutputStream outputStream() {
        return Output.output.get(key);
    }

    public Config child() {
        return new Config(key, deep + 1);
    }
}
