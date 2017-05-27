package yunhaikeji.com.yuzhiweilai.view.function_interface;

import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;

/**
 * Use:View 层功能接口
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public interface ViewInterface {
    void getFristHand(boolean b);

    /**
     * 展示轮播图
     * @param listBannerBean
     */
    void showListBanner(ListBannerBean listBannerBean);

    //void showListTryClass();



}
