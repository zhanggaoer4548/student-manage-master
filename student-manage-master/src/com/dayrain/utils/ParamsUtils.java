package com.dayrain.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ParamsUtils {

    public static String wrapper(String name) {
        if(name == null) {
            return null;
        }
        name = "'%" + name + "%'";
        return name;
    }
}
