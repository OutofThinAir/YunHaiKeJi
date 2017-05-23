package yunhaikeji.com.yuzhiweilai.model.url_interface;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import yunhaikeji.com.yuzhiweilai.model.bena.FirstHandBean;
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
}
