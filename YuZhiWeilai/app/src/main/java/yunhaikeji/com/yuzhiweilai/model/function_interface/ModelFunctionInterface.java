package yunhaikeji.com.yuzhiweilai.model.function_interface;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Use:Model层功能接口
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public interface ModelFunctionInterface {

    /**
     * 获得首页轮播图
     * @param appKey
     * @param DevId
     * @param verCode
     *
     */
     void getList_banner(Context context,SharedPreferences preferences, String appKey, String DevId, int verCode);

    /**
     * 试听列表
     * @param context
     * @param preferences
     * @param appKey
     * @param devId
     * @param verCode
     * @param tick
     * @param session
     * @param category
     * @param page_size
     * @param page_index
     */
    void getList_try(Context context,SharedPreferences preferences,String appKey,String devId,int verCode,String tick,
                     String session,String category,int page_size,int page_index);

}
