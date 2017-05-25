package yunhaikeji.com.yuzhiweilai.model.url_interface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import rx.Observer;
import yunhaikeji.com.yuzhiweilai.model.bena.FirstHandBean;
import yunhaikeji.com.yuzhiweilai.model.bena.GetHostBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.utils.UrlConnect;

/**
 * Use:数据的请求接口
 * Author:陈懿鹏
 * Data:2017/5/23.
 */

public interface DataRequestApi {

    /**
     *FirstHand 首次握手
     * @param type app类型 为ANDROID
     * @param dev_id 设备标识
     * @param ver_code 版本号
     * @param tick 时间戳
     * @param sign 签名
     * @return
     */

    @POST(UrlConnect.FRIST_HAND)
    @FormUrlEncoded

    Observable<FirstHandBean> firstHand(@Field("type")String type,@Field("dev_id")String dev_id,
                                        @Field("ver_code")int ver_code,@Field("tick")String tick,
    @Field("sign")String sign);


    /**
     * 通过向导服务器 获得分流的数据接口
     * @param appId
     * @param dev_id
     * @param ver_code
     * @param tick
     * @param sign
     * @return
     */
    @POST(UrlConnect.GED_HOST)
    @FormUrlEncoded
    Observable<GetHostBean> getHost(@Field("app_id")String appId,@Field("dev_id")String dev_id,
                                    @Field("ver_code")int ver_code,@Field("tick")String tick,
                                    @Field("sign")String sign);

    /**
     * 获得首页轮播图
     * @param appId
     * @param dev_id
     * @param ver_code
     * @param tick
     * @param sign
     * @return
     */
    @POST(UrlConnect.LISD_BNNER)
    @FormUrlEncoded
    Observable<ListBannerBean> getListBanner(@Field("app_id")String appId, @Field("dev_id")String dev_id,
                                           @Field("ver_code")int ver_code, @Field("tick")String tick,
                                           @Field("sign")String sign);


    /**
     * 免费试听列表
     * @param app_id
     * @param dev_id
     * @param ver_code
     * @param tick
     * @param session
     * @param category
     * @param page_size
     * @param page_index
     * @param sign
     * @return
     */
    @POST(UrlConnect.LIST_TRY)
    @FormUrlEncoded
    Observable<ListTryBean> getListTry(@Field("app_id")String app_id,@Field("dev_id")String dev_id,@Field("ver_code")int ver_code,
    @Field("tick")String tick,@Field("session")String session,@Field("category")String category,
       @Field("page_size")int page_size,@Field("page_index")int page_index,@Field("sign")String sign);

}
