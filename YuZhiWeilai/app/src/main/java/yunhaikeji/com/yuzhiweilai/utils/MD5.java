package yunhaikeji.com.yuzhiweilai.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * Use:MD5算法的类
 * Author:陈懿鹏
 * Data:2017/5/23.
 */

public class MD5 {

    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F' };


    public static void main(String[] args) {
        System.out.println(md5sum("/init.rc"));
    }

    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static String md5sum(String filename) {
         String md5Str=null;
        InputStream fis;
        byte[] buffer = new byte[1024];
        int numRead = 0;
        MessageDigest md5;
        try {
            fis = new FileInputStream(filename);
            md5 = MessageDigest.getInstance("MD5");
            while ((numRead = fis.read(buffer)) > 0) {
                md5.update(buffer, 0, numRead);
            }
            fis.close();
            md5Str = toHexString(md5.digest());

        } catch (Exception e) {
            Log.e("MD5","错误");

        }
        return md5Str;
    }

}
