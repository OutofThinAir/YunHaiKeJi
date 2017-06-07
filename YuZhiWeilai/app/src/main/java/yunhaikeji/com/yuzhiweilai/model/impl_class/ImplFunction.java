package yunhaikeji.com.yuzhiweilai.model.impl_class;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

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
import yunhaikeji.com.yuzhiweilai.model.bena.LoginBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ReginBean;
import yunhaikeji.com.yuzhiweilai.model.bena.SpecialClassBean;
import yunhaikeji.com.yuzhiweilai.model.bena.VerifyBean;
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
                .map(new Func1<ListTryBean, ListTryBean>() {
                    @Override
                    public ListTryBean call(ListTryBean listTryBean) {
                        return listTryBean;
                    }
                })
                .subscribe(new Observer<ListTryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ListTryBean listTryBean) {

                        presenter.getListTryClass((ArrayList<ListTryBean.DataBean.TryBean>) listTryBean.data.tryX);


                    }
                });
    }

    /**精品专辑
     *
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
    public void getList_topic(Context context, SharedPreferences preferences, String appKey, String devId, int verCode, String tick, String session, String category, int page_size, int page_index) {

        final StringBuffer sb = new StringBuffer();
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

        Observable<SpecialClassBean> tipoc = requestApi.getTipoc(appKey, devId, verCode, tick, session, category, page_size, page_index, sgin);
        tipoc.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SpecialClassBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SpecialClassBean specialClassBean) {
                           presenter.getListSpecial((ArrayList<SpecialClassBean.DataBean.TopicBean>) specialClassBean.getData().getTopic());
                    }
                });
    }

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
    @Override
    public void user_regin(final Context context, final SharedPreferences preferences, final String appKey, final String devId, final int verCode, final String tick, String mobile, final String rand, final String pwd) {

        //生成签名文件
        StringBuffer sb = new StringBuffer();
        sb.append(ModelUtils.getPrivateKey(preferences))
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(tick)
                .append(mobile);
        String sign = ModelUtils.md5(sb.toString()).toUpperCase();

        //获得请请求接口
        DataRequestApi dataRequestApi = ModelUtils.getDataRequestApi(ModelUtils.getHostUrl(preferences));
        Observable<ReginBean> userrigin = dataRequestApi.Userrigin(appKey, devId, verCode, tick, mobile, sign);
        userrigin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ReginBean reginBean) {
                        if (reginBean.getData()==null){
                            presenter.getReginBean(reginBean);
                        }else{
                            user_check_rand(context,preferences,reginBean,appKey,devId,verCode,tick,reginBean.getData().getSession(),
                                    rand,pwd);
                        }



                       // presenter.getReginBean(reginBean);
                    }
                });

    }

    /**
     * 校检验证码
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
    @Override
    public void user_check_rand(Context context, SharedPreferences preferences, final ReginBean reginBean, String appKey, String devId, int verCode, String tick, String session, String rand, String pwd) {

        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(ModelUtils.getPrivateKey(preferences))
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(tick)
                .append(session)
                .append(rand)
                .append(pwd);
        String sign = ModelUtils.md5(sb.toString()).toUpperCase();

        DataRequestApi dataRequestApi = ModelUtils.getDataRequestApi(ModelUtils.getHostUrl(preferences));
        Observable<VerifyBean> verifyBeanObservable = dataRequestApi.checket_verify(appKey, devId, verCode, tick, session, rand, pwd, sign);
        verifyBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerifyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(VerifyBean verifyBean) {
                        //presenter.getReginBean(reginBean);
                        presenter.getVerifyBean(verifyBean);



                    }
                });


    }

    /**
     *
     * @param context
     * @param preferences
     * @param appKey
     * @param devId
     * @param verCode
     * @param tick
     * @param mobile
     * @param pwd
     */
    @Override
    public void pwd_login(Context context, final SharedPreferences preferences, String appKey, String devId, int verCode, String tick, String mobile, String pwd) {

        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(ModelUtils.getPrivateKey(preferences))
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(tick)
                .append(mobile)
                .append(pwd);
       String sgin= ModelUtils.md5(sb.toString()).toUpperCase();
        DataRequestApi userlogin=ModelUtils.getDataRequestApi(ModelUtils.getHostUrl(preferences));
       Observable<LoginBean> loginUser= userlogin.user_pwd_login(appKey,devId,verCode,tick,mobile,pwd,sgin);
        loginUser.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        presenter.getLoginBean(loginBean);

                    }
                });


    }
}
