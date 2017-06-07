package yunhaikeji.com.yuzhiweilai.model.bena;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Use:试听课程
 * Author:陈懿鹏
 * Data:2017/5/25.
 */


public class ListTryBean {

    /**
     * ret : 0
     * data : {"app_id":"B406A2EF","private_key":"AEF63FBAEDD31000F25FAD2E4C3C2974"}
     */

    public int ret;
    public DataBean data;

    public  class DataBean {
        /**
         * app_id : B406A2EF
         * private_key : AEF63FBAEDD31000F25FAD2E4C3C2974
         */

        public String app_id;
        public String private_key;
        public String url_host;
        public List<BannerBean> banner;

        public String page_index;
        public int total;
        public String page_size;
        @SerializedName("try")
        public List<TryBean> tryX;


        public  class BannerBean {
            public String click;
            public String image;
        }


        public  class TryBean {
            public String title2;
            public String speaker;
            public String title;
            public int try_time;
            public String image;
            public int type;
            public int length;
            public String object_id;
        }
    }
}
