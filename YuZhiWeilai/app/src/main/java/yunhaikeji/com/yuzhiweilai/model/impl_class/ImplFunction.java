package yunhaikeji.com.yuzhiweilai.model.impl_class;

import android.content.Context;
import android.content.SharedPreferences;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yunhaikeji.com.yuzhiweilai.model.bena.GetHostBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.function_interface.ModelFunctionInterface;
import yunhaikeji.com.yuzhiweilai.model.url_interface.DataRequestApi;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.presenter.ImplPresenter;

/**
 * Use:功能接口的实现类
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public class ImplFunction implements ModelFunctionInterface {

    ImplPresenter presenter;


    public ImplFunction(Context context, ImplPresenter presenter) {

        this.presenter = presenter;

    }

    /**
     * 首页轮播图
     * @param appKey
     * @param devId
     * @param verCode
     *
     */
    @Override
    public void getList_banner(Context c, final SharedPreferences p, final String appKey, final String devId, final int verCode) {
        ModelUtils.getHost(ModelUtils.getPrivateKey(p), ModelUtils.getAppKey(p),
                ModelUtils.getLocaldeviceId(c), ModelUtils.getVer_code(c), ModelUtils.getTick(), new Observer<GetHostBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GetHostBean getHostBean) {

                        //生成签名文件
                        StringBuffer sb = new StringBuffer();
                        sb.append(ModelUtils.getPrivateKey(p))
                                .append(appKey)
                                .append(devId)
                                .append(verCode)
                                .append(ModelUtils.getTick());
                        String sign = ModelUtils.md5(sb.toString()).toUpperCase();


                        DataRequestApi requestApi = ModelUtils.getDataRequestApi(getHostBean.getData().getUrl_host());
                        final Observable<ListBannerBean> listBanner = requestApi.getListBanner(appKey, devId, verCode, ModelUtils.getTick(), sign);
                        listBanner.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .map(new Func1<ListBannerBean, ListBannerBean>() {
                                    @Override
                                    public ListBannerBean call(ListBannerBean listBannerBean) {
                                        return listBannerBean;
                                    }
                                }).subscribe(new Observer<ListBannerBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ListBannerBean listBannerBean) {
                                 presenter.getListBannerForModel(listBannerBean);
                            }
                        });
                    }
                });
    }

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
    @Override
    public void getList_try(Context context, final SharedPreferences preferences, final String appKey, final String devId, final int verCode, final String tick, final String session, final String category, final int page_size, final int page_index) {

        ModelUtils.getHost(ModelUtils.getPrivateKey(preferences), ModelUtils.getAppKey(preferences), ModelUtils.getLocaldeviceId(context), ModelUtils.getVer_code(context), ModelUtils.getTick(), new Observer<GetHostBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GetHostBean getHostBean) {
                StringBuffer sb = new StringBuffer();
                sb.append(ModelUtils.getPrivateKey(preferences))
                        .append(appKey)
                        .append(devId)
                        .append(verCode)
                        .append(tick);
                if (session!=null){
                    sb.append(session);
                }

                if (category!=null){
                    sb.append(category);
                }
                sb.append(page_size)
                        .append(page_index);
                String sgin = sb.toString().toUpperCase();



                DataRequestApi requestApi = ModelUtils.getDataRequestApi(getHostBean.getData().getUrl_host());
                requestApi.getListTry(appKey,devId,verCode,tick,session,category,page_size,page_index,sgin);
            }
        });
    }
}
