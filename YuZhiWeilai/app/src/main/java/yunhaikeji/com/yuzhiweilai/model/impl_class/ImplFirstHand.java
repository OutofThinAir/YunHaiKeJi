package yunhaikeji.com.yuzhiweilai.model.impl_class;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yunhaikeji.com.yuzhiweilai.model.bena.FirstHandBean;
import yunhaikeji.com.yuzhiweilai.model.bena.GetHostBean;
import yunhaikeji.com.yuzhiweilai.model.function_interface.FirstHandInterface;
import yunhaikeji.com.yuzhiweilai.model.url_interface.DataRequestApi;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.presenter.FirstHandPresenter;
import yunhaikeji.com.yuzhiweilai.presenter.ImplPresenter;
import yunhaikeji.com.yuzhiweilai.utils.UrlConnect;

/**
 * Use:
 * Author:陈懿鹏
 * Data:2017/5/27.
 */

public class ImplFirstHand implements FirstHandInterface {
   FirstHandPresenter presenter;
    Context context;

    public ImplFirstHand(FirstHandPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
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
}
