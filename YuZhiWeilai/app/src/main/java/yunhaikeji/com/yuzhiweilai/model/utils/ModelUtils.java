package yunhaikeji.com.yuzhiweilai.model.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import yunhaikeji.com.yuzhiweilai.utils.MD5;

/**
 * Use:Model层的工具类
 * Author:陈懿鹏
 * Data:2017/5/23.
 */

public class ModelUtils {

    /**

     * app类型
     * @param
     * @return
     */
 public  static final String APPTYPE ="ANDROID";

    /**

     * 获取app版本号
     * @param context
     * @return code
     */
    public static int getVer_code(Context context){
        int code=-1;
         try {
             //注意："com.example.try_downloadfile_progress"对应AndroidManifest.xml里的package="……"部分
             code = context.getPackageManager().getPackageInfo(
                                        context.getPackageName(), 0).versionCode;
                    } catch (PackageManager.NameNotFoundException e) {
                         Log.e("msg",e.getMessage());
                    }
        return code;
    }

    /**
     * 获取app版本名称
     * @param context
     * @return
     */
    public static String getVer_name(Context context){
        String name="";
        try {
            //注意："com.example.try_downloadfile_progress"对应AndroidManifest.xml里的package="……"部分
            name = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("msg",e.getMessage());
        }
        return name;
    }

    /**
     * 获得设备唯一表示
     * @param context
     * @return
     */

    public static String getLocaldeviceId(Context context){
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null
                || deviceId.trim().length() == 0) {
            deviceId = String.valueOf(System
                    .currentTimeMillis());
        }
        return deviceId ;
    }


    /**
     * 获得时间戳
     * @return
     */
    public static String getTick(){
        //获得系统时间
        Date date =new Date();
        //转化成long类型
        long time = date.getTime();
        String tick_=String.valueOf(time);
        //String tick=tick_.substring(0,10);
        return tick_;

    }

    /**
     * MD5算法
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
