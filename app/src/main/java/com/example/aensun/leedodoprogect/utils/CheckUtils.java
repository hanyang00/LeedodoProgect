package com.example.aensun.leedodoprogect.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aensun on 2017-08-14.
 */

public class CheckUtils {
    /**
     * 验证手机号码
     * @param phoneNumber 手机号码
     * @return boolean
     */
    public static boolean checkPhoneNumber(String phoneNumber){
        Pattern pattern=Pattern.compile("^1[0-9]{10}$");
        Matcher matcher=pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    /**
     * 密码
     * @param username 密码
     * @return boolean
     */
    public static boolean checkUsername(String username){
        String regex = "([a-zA-Z0-9-.]{6,12})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(username);
        return m.matches();
    }
}
