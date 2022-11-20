package com.mymovie.util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        String uuidStr = UUID.randomUUID().toString();
        uuidStr = uuidStr.replaceAll("-", "");
        return uuidStr;
    }

}
