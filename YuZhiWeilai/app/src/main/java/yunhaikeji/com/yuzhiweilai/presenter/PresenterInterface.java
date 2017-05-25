package yunhaikeji.com.yuzhiweilai.presenter;

import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;

/**
 * Use:Presenter 层功能接口
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public interface PresenterInterface {

    /**
     * 从Model层获取轮播图
     * @param listBannerBean
     */
    void getListBannerForModel(ListBannerBean listBannerBean);

    void showListBannerToView();

}
