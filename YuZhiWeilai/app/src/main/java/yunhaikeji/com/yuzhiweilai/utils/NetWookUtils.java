package yunhaikeji.com.yuzhiweilai.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Use:网络判断
 * Author:陈懿鹏
 * Data:2017/5/27.
 */

public class NetWookUtils {

    /**
     * 判断网络是否正常
     * @param context
     * @return
     */
    public static boolean isHaveNet(Context context){

        //判断有没有网
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }

        return false;
    }

    /**
     * 判断是不是wift
     * @param context
     * @return
     */
    public static boolean isWifi(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null&&info.getType()==ConnectivityManager.TYPE_WIFI){
            return true;
        }

        return false;
    }
}
