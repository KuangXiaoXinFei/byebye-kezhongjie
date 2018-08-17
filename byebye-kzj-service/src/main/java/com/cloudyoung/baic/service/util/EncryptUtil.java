package com.cloudyoung.baic.service.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author 1.0 刘风栓
 */
public class EncryptUtil {
    private static final String DES = "DES";
    private static final String CODE = "UTF-8";

    public EncryptUtil() {
    }

    public static String encrypt(String data, String key) {
        try {
            return encrypt(data, key, "UTF-8");
        } catch (Exception e) {
            return data;
        }
    }

    public static String encrypt(String data, String key, String code) throws Exception {
        byte[] bt = encrypt(data.getBytes(code), key.getBytes(code));
        String strs = Base64.encodeBase64String(bt);
        return strs;
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, securekey, sr);
        return cipher.doFinal(data);
    }

    public static String decryptString(String data, String key) {
        try {
            return decrypt(data, key, "UTF-8");
        } catch (Exception e) {
            return data;
        }
    }

    public static String decrypt(String data, String key, String code) throws Exception {
        if (data == null) {
            return null;
        } else {
            byte[] buf = Base64.decodeBase64(data.getBytes(code));
            byte[] bt = decrypt(buf, key.getBytes(code));
            return new String(bt, code);
        }
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, securekey, sr);
        return cipher.doFinal(data);
    }

    public static String sha512(String originalText) {
        return originalText == null ? null : DigestUtils.sha512Hex(originalText);
    }

    public static String base64Encode(String originalText) throws UnsupportedEncodingException {
        return originalText == null ? null : Base64.encodeBase64String(originalText.getBytes("UTF-8"));
    }

    public static String base64Decode(String text) throws UnsupportedEncodingException {
        return text == null ? null : new String(Base64.decodeBase64(text), "UTF-8");
    }

    /**
     * MD5加salt加密
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
     * 将得到的字节数组变成字符串返回
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