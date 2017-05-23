package yunhaikeji.com.yuzhiweilai.application;

import android.app.Application;

import yunhaikeji.com.yuzhiweilai.model.utils.ModelUtils;
import yunhaikeji.com.yuzhiweilai.utils.UrlConnect;

/**
 * Use:用于一系列初始化工作
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

    }

    //首次握手
    private void firstHand(String type,String dev_id,int ver_code,String tick){

        //拼接 字符串 生成签名文件
        StringBuffer sb = new StringBuffer();
        sb.append(UrlConnect.PUBLIC_KEY)
                .append(type)
                .append(dev_id)
                .append(ver_code)
                .append(tick);
        //Md5生成签名
        String sign = ModelUtils.md5(sb.toString());

        //

    }

}
