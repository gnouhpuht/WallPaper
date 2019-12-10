package com.phuong.wallpaper.untils;

import android.util.Log;

public class Utils {
    protected static String getTag() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];

            return "[" + stackTraceElement.getClassName().substring(stackTraceElement.getClassName().lastIndexOf(".") + 1) + "][" + stackTraceElement.getMethodName() + "][" + stackTraceElement.getLineNumber() + "]";
        } catch (Exception e) {
            return "[UNKNOW]";
        }

    }
    public static void debug(String msg) {
        if (msg == null) {
            msg = "[]";
        }
        if (msg.equals("")) {
            msg = "[]";
        }
        Log.d("[DEBUG]" + getTag(), msg);

    }

    public static void debug(String msg, Throwable e) {
        if (msg == null) {
            msg = "[]";
        }
        if (msg.equals("")) {
            msg = "[]";
        }
        Log.d("[DEBUG]" + getTag(), msg, e);

    }

    public static void info(String msg) {
        if (msg == null) {
            msg = "[]";
        }
        if (msg.equals("")) {
            msg = "[]";
        }
        Log.d("[INFO]" + getTag(), msg);
    }

    public static void warn(String msg) {
        if (msg == null) {
            msg = "[]";
        }
        if (msg.equals("")) {
            msg = "[]";
        }
        Log.w("[WARN]" + getTag(), msg);
    }

    public static void error(String msg) {
        if (msg == null) {
            msg = "[]";
        }
        if (msg.equals("")) {
            msg = "[]";
        }
        Log.e("[ERROR]" + getTag(), msg);
    }

    public static void error(String msg, Throwable e) {
        if (msg == null) {
            msg = "[]";
        }
        if (msg.equals("")) {
            msg = "[]";
        }
        Log.e("[ERROR]" + getTag(), msg, e);
    }
}
