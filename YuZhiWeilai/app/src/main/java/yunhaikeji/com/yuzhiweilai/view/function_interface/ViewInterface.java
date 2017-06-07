package yunhaikeji.com.yuzhiweilai.view.function_interface;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;
import yunhaikeji.com.yuzhiweilai.model.bena.SpecialClassBean;

/**
 * Use:View 层功能接口
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public interface ViewInterface {
    //void getFristHand(boolean b);

    /**
     * 展示轮播图
     * @param listBannerBean
     */
    void showListBanner(ListBannerBean listBannerBean);

    /**
     * 展示试听列表
     * @param list
     */
    void showListTryClass(ArrayList<ListTryBean.DataBean.TryBean> list);

    /**
     * 展示精品专辑
     * @param list
     */
    void showListSpecial(ArrayList<SpecialClassBean.DataBean.TopicBean> list);


    /**
     * 展示注册信息
     * @param info
     */
    void showReginInfo(String info);

    /**
     * 展示登录信息
     * @param info
     */
    void showLoginInfo(String info);


}
