package com.aegis.testnewmvpdataview.utils;

import com.tencent.mmkv.MMKV;

public class SpUtil {




    private static final MMKV kv = MMKV.defaultMMKV();

    public static void putBoolean(String key, boolean value) {
        kv.encode(key, value);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return kv.decodeBool(key, defValue);
    }

    public static void putInt(String key, int value) {
        kv.encode(key, value);
    }

    public static int getInt(String key, int defValue) {
        return kv.decodeInt(key, defValue);
    }

    public static void putString(String key, String value) {
        kv.encode(key, value);
    }

    public static String getString(String key, String defValue) {
        return kv.decodeString(key, defValue);
    }

    public static void clearAll() {
        kv.clearAll();
    }
}
