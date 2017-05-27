package yunhaikeji.com.yuzhiweilai.model.impl_class;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yunhaikeji.com.yuzhiweilai.application.App;
import yunhaikeji.com.yuzhiweilai.model.bena.FirstHandBean;
import yunhaikeji.com.yuzhiweilai.model.bena.GetHostBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.model.function_interface.ModelFunctionInterface;
import yunhaikeji.com.yuzhiweilai.model.url_interface.DataRequestApi;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelObserver;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.presenter.ImplPresenter;
import yunhaikeji.com.yuzhiweilai.utils.UrlConnect;

/**
 * Use:功能接口的实现类
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public class ImplFunction implements ModelFunctionInterface {

    ImplPresenter presenter;
    Context context;


    public ImplFunction(Context context, ImplPresenter presenter) {

        this.context=context;
        this.presenter = presenter;

    }


    @Override
    public void first_hand(final Context context, final SharedPreferences preferences, String type, String dev_id, int ver_code, String tick) {
        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(UrlConnect.PUBLIC_KEY)
                .append(type)
                .append(dev_id)
                .append(ver_code)
                .append(tick);
        //Md5加密
        String sign_ = ModelUtils.md5(sb.toString());
        String sign=sign_.toUpperCase();

        Log.d("sign",sign);

        //获得调用接口
        DataRequestApi dataRequestApi = ModelUtils.getDataRequestApi(UrlConnect.BESE_URL);
        //请求网络
        final Observable<FirstHandBean> firstHand = dataRequestApi.firstHand(type, dev_id, ver_code, tick, sign);
        //给被观察者设置线程
        firstHand.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<FirstHandBean, FirstHandBean>() {
                    @Override
                    public FirstHandBean call(FirstHandBean firstHandBean) {
                        return firstHandBean;
                    }
                })
                .subscribe(new Observer<FirstHandBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FirstHandBean firstHandBean) {

                        // Toast.makeText(MainActivity.this, "sssss", Toast.LENGTH_SHORT).show();
                        //得到app_key 和private_key
                        String appKey = firstHandBean.getData().getApp_id();
                        String mprivateKey = firstHandBean.getData().getPrivate_key();


                        //存储到SharedPreferences 里,同时存储一个标记,表示首次安装
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putString(UrlConnect.APP_KEY, appKey);
                        edit.putString(UrlConnect.PRIVATE_KEY, mprivateKey);
                        edit.putBoolean(UrlConnect.ISFIRSTINSTALL, true);
                        edit.commit();
                        // notification.mynotify();
                        //导向
                        ModelUtils.getHost(mprivateKey, appKey, ModelUtils.getLocaldeviceId(context),
                                ModelUtils.getVer_code(context), ModelUtils.getTick(), new Observer<GetHostBean>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(GetHostBean getHostBean) {
                                        SharedPreferences.Editor edit = preferences.edit();
                                        edit.putString("host_url",getHostBean.getData().getUrl_host());
                                        edit.commit();

                                      presenter.getFirstHand(true);


                                    }
                                });



                    }
                });
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
        //生成签名文件
        StringBuffer sb = new StringBuffer();
        sb.append(ModelUtils.getPrivateKey(p))
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(ModelUtils.getTick());
        String sign = ModelUtils.md5(sb.toString()).toUpperCase();


        DataRequestApi requestApi = ModelUtils.getDataRequestApi(ModelUtils.getHostUrl(p));
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

        String sgin =ModelUtils.md5(sb.toString()).toUpperCase();

        DataRequestApi requestApi = ModelUtils.getDataRequestApi(ModelUtils.getHostUrl(preferences));
        final Observable<ListTryBean> listtry= requestApi.getListTry(appKey,devId,verCode,tick,session,category,page_size,page_index,sgin);
        listtry.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ListTryBean, ArrayList<ListTryBean>>() {
                    @Override
                    public ArrayList<ListTryBean> call(ListTryBean listTryBean) {
                        ArrayList<ListTryBean> list=new ArrayList<ListTryBean>();
                        list.add(listTryBean);
                        return list;
                    }
                }).subscribe(new Observer<ArrayList<ListTryBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ArrayList<ListTryBean> listTryBeen) {
                //数据传到p层
                // Log.d("Mo_on",listTryBeen.toString());
            }
        });
    }
}
