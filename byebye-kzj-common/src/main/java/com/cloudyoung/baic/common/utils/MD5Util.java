package com.cloudyoung.baic.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/5 下午7:17
 */
public class MD5Util {

    /**
     * @param password
     * @return
     * @Descpription:MD5加salt加密
     * @version 1.0  2017/11/13 16:04   by  张成智（zhangcz@cloud-young.com）创建
     */
    public static String md5Encrypt(String password, String salt) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
            byte[] results = md5.digest((salt + password).getBytes());
            String resultString = byteArrayToHexString(results);
            String pwd = resultString.toLowerCase();
            return pwd;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param b
     * @return
     * @Descpription:将得到的字节数组变成字符串返回
     * @version 1.0  2017/11/13 16:04   by  张成智（zhangcz@cloud-young.com）创建
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString(byte b) {
        String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
