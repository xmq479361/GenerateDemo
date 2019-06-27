package com.xmqiu.uigenerate.core;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:07
 */
public class Logger {

    public static void info(String message, Object... args) {
        System.out.println(String.format(message, args));
    }

    public static void e(String tag, String value) {
        System.out.println(tag + "/ " + value);
    }
}
