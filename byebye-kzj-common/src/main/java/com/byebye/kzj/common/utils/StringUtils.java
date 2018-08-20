package com.byebye.kzj.common.utils;

/**
 * StringUtils
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }


    /**
     * 判断字符串是否为null或者空字符串
     *
     * @param s 输入字符串
     * @return
     */
    public static boolean isNullOrEmpty(String s) {
        return null == s || s.isEmpty();
    }

    /**
     * 判断字符串是否为null或者空白字符串
     *
     * @param s 输入字符串
     * @return
     */
    public static boolean isNullOrWhiteSpace(String s) {
        return isNullOrEmpty(s.trim());
    }

}
