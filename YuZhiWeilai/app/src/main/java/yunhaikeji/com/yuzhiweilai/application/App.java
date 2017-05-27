package yunhaikeji.com.yuzhiweilai.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import retrofit2.http.Field;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yunhaikeji.com.yuzhiweilai.model.bena.FirstHandBean;
import yunhaikeji.com.yuzhiweilai.model.bena.GetHostBean;
import yunhaikeji.com.yuzhiweilai.model.url_interface.DataRequestApi;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelObserver;
import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.utils.UrlConnect;
import yunhaikeji.com.yuzhiweilai.view.activity.MainActivity;

/**
 * Use:用于一系列初始化工作
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public class App extends Application {
    public static final String COFIGNAME="cofig";
    private SharedPreferences preferences;
    public Notifiy notify;


    @Override
    public void onCreate() {
        super.onCreate();

        //初始化向导连接
        //获得首次安装的标识
        preferences = getSharedPreferences(COFIGNAME,MODE_PRIVATE);
        final boolean firstInstall =ModelUtils.isFirstInstall(preferences);
        Log.d("Main_firstInstall", "firstInstall "+firstInstall);
        if (firstInstall==false){
           // firstHand(ModelUtils.APPTYPE,ModelUtils.getLocaldeviceId(this),ModelUtils.getVer_code(this),ModelUtils.getTick());
        }else {
            ModelUtils.getHost(ModelUtils.getPrivateKey(preferences), ModelUtils.getAppKey(preferences), ModelUtils.getLocaldeviceId(this),
                    ModelUtils.getVer_code(this), ModelUtils.getTick(), new Observer<GetHostBean>() {
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
                            //notify.mnotify(false);
                        }
                    });
        }


    }

    /**
     *首次握手
     * @param type app类型
     * @param dev_id 设备ID
     * @param ver_code 版本号
     * @param tick 时间戳
     */

    private void firstHand(String type, final String dev_id, final int ver_code, final String tick){
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
                ModelUtils.getHost(mprivateKey, appKey, ModelUtils.getLocaldeviceId(App.this),
                        ModelUtils.getVer_code(App.this), ModelUtils.getTick(), new Observer<GetHostBean>() {
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
                                Toast.makeText(App.this, getHostBean.getData().getUrl_host(), Toast.LENGTH_SHORT).show();
                                notify.mnotify(true);


                            }
                        });



            }
        });

    }

    //通知接口
    public interface Notifiy{
        void mnotify(boolean f);
    }

    public void setNotify(Notifiy notify){
        this.notify=notify;
    }

}
