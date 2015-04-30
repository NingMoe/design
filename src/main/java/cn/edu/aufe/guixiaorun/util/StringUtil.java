package cn.edu.aufe.guixiaorun.util;
/*
 * Copyright(C) 2010-2012 Alibaba Group Holding Limited
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
 *  published by the Free Software Foundation.
 *
 */

import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;

/**
 * 有关字符串处理的工具类。
 * <p/>
 * <p>
 * 这个类中的每个方法都可以“安全”地处理<code>null</code>，而不会抛出<code>NullPointerException</code>。
 * </p>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class StringUtil extends StringUtils {
    public static String toDefualtZero(Object tmp) {
        return tmp == null ? "0" : tmp + "";
    }

    public static Integer toIntDefualtZero(Object tmp) {
        if (tmp == null) {
            return 0;
        }
        Integer i = 0;
        String s = tmp.toString();
        try {
            i = Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    public static Integer toInt(Object tmp) {
        if (tmp == null) {
            return null;
        }
        try {
            return Integer.parseInt(tmp+"");
        } catch (Exception e) {
            return null;
        }
    }

    public static Long toLong(Object tmp) {
        if (tmp == null) {
            return null;
        }
        Long i = 0L;
        String s = tmp.toString();
        try {
            i = Long.parseLong(s);
        } catch (Exception e) {
            return null;
        }
        return i;
    }

    public static Long toLongDefualtZero(Object tmp) {
        if (tmp == null) {
            return 0L;
        }
        try {
            return  Long.parseLong(tmp+"");
        } catch (Exception e) {
            return 0L;
        }
    }

    public static Double toDouble(Object tmp) {
        if (tmp == null) {
            return null;
        }
        Double i = 0.0;
        String s = tmp.toString();
        try {
            return  Double.parseDouble(s);
        } catch (Exception e) {
            return 0d;
        }
    }



    public static String toMd5Code(String str) {
        StringBuffer md5CodeBuffer = new StringBuffer();

        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            md5Digest.update(str.getBytes());
            byte[] strBytesDigest = md5Digest.digest();

            // 将二进制字节信息转换为十六进制字符串
            String strHexDigest = "";
            for (int i = 0; i < strBytesDigest.length; i++) {
                strHexDigest = Integer.toHexString(strBytesDigest[i] & 0XFF);
                if (strHexDigest.length() == 1) {
                    md5CodeBuffer.append("0").append(strHexDigest);
                } else {
                    md5CodeBuffer.append(strHexDigest);
                }
            }
        } catch (Exception e) {
            return str;
        }

        return md5CodeBuffer.toString();
    }

    public static String toStrNotNull(String tmp) {
        if (tmp == null) {
            return "";
        } else {
            return tmp.toString();
        }
    }

    public static String getException(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return "\r\n" + sw.toString() + "\r\n";
    }

}