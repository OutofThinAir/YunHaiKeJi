package yunhaikeji.com.yuzhiweilai.presenter;

import java.util.ArrayList;

import yunhaikeji.com.yuzhiweilai.model.bena.ListBannerBean;
import yunhaikeji.com.yuzhiweilai.model.bena.ListTryBean;

/**
 * Use:Presenter 层功能接口
 * Author:陈懿鹏
 * Data:2017/5/25.
 */

public interface PresenterInterface {


    /**
     * 拿到握手成功的标识
     * @param b
     */
    void getFirstHand(boolean b);
    /**
     * 将标识传到view
     */
void showFirst();
    /**
     * 从Model层获取轮播图
     * @param listBannerBean
     */
    void getListBannerForModel(ListBannerBean listBannerBean);

    /**
     * 向V层展示数据
     */
    void showListBannerToView();

    /**
     * 获得试听列表
     * @param list
     */
    void getListTryClass(ArrayList<ListTryBean.DataBean.TryBean> list);

    /**
     * 展示试听列表
     */
    void showListTryClass();

}
