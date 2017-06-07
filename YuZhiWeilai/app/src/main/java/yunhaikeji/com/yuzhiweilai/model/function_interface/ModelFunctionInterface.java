package yunhaikeji.com.yuzhiweilai.model.function_interface;

import android.content.Context;
import android.content.SharedPreferences;

import rx.Observer;
import yunhaikeji.com.yuzhiweilai.model.bena.GetHostBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ReginBean;

/**
 * Use:Model层功能接口
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public interface ModelFunctionInterface {

    /**
     * 首次握手
     * @param type
     * @param dev_id
     * @param ver_code
     * @param tick
     */
   // void first_hand(Context context,SharedPreferences preferences,String type, final String dev_id, final int ver_code, final String tick);

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

    /**
     * 精品专辑
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
    void getList_topic(Context context,SharedPreferences preferences,String appKey,String devId,int verCode,String tick,
                       String session,String category,int page_size,int page_index);


    /**
     * 注册
     * @param context
     * @param preferences
     * @param appKey
     * @param devId
     * @param verCode
     * @param tick
     * @param mobile
     */
    void user_regin(Context context,SharedPreferences preferences,String appKey,String devId,int verCode,String tick,String mobile,String rand,String pwd);

    /**
     * 注册的第二次请求 校检验证码
     * @param context
     * @param preferences
     * @param appKey
     * @param devId
     * @param verCode
     * @param tick
     * @param session
     * @param rand
     * @param pwd
     */

     void user_check_rand(Context context, SharedPreferences preferences, ReginBean reginBean, String appKey, String devId, int verCode, String tick, String session, String rand, String pwd);

    /**
     * 登录功能
     * @param context
     * @param preferences
     * @param appKey
     * @param devId
     * @param verCode
     * @param tick
     * @param mobile
     * @param pwd
     */
     void pwd_login(Context context,SharedPreferences preferences,String appKey,String devId,int verCode,String tick,String mobile,String pwd);
}
