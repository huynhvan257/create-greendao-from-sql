package com.example;

/**
 * Created by van on 10/14/15.
 */
public class TextUtils {

    public static boolean isEmpty(String text){
        if(text == null || text.length() == 0){
            return true;
        }
        return false;
    }
}
