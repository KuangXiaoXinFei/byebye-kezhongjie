package com.byebye.kzj.webapi.intercepter;

import java.security.MessageDigest;
import java.util.*;

public class SignValidator {

    private final static String FIELD_SIGN = "sign";
    private final static String KEY = "#EDCvfr4";

    public static boolean verify(final HashMap signMap, String sign, String token) {
        String new_sign = generateSignature(signMap, token);
        new_sign = new_sign.toLowerCase();
        boolean r = new_sign.equals(sign.toLowerCase());
        return r;
    }

    public static String generateSignature(final Map signMap, String token) {
        Set<String> keySet = signMap.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);//按key进行排序
        //Map<String, String> resultMap = sortMapByKey(signMap);
        StringBuffer sb = new StringBuffer(token);
        if (keyArray != null) {
            for (String k : keyArray) {
                if (FIELD_SIGN.equals(k)) {
                    continue;
                }
                sb.append(k.toLowerCase()).append("=");
                sb.append(signMap.get(k).toString().trim().toLowerCase()).append("&");
            }
        }
        sb.append("key=").append(KEY);
        String paramsStr = sb.toString();
        String new_sign = MD5(paramsStr);
        return new_sign;
    }

    private static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    private static Map<String, String> sortMapByKey(Map map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new Comparator<String>() {
            //比较器类
            @Override
            public int compare(String str1, String str2) {
                str1 = str1.toLowerCase();
                str2 = str2.toLowerCase();
                return str1.compareTo(str2);
            }
        });
        sortMap.putAll(map);
        return sortMap;
    }

}

