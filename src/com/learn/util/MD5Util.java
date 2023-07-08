package com.learn.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//两层加密
public class MD5Util {

    public static String encode(String orgStr) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] dest = md.digest(orgStr.getBytes());

        BASE64Encoder base = new BASE64Encoder();
        return base.encode(dest);
    }

//    public static void main(String[] args) {
//
//        System.out.println(MD5Util.encode("root"));
//    }
}
