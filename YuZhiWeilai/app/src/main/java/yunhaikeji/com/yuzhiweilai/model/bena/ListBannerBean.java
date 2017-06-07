package yunhaikeji.com.yuzhiweilai.model.bena;

import java.util.List;

/**
 * Use:首页轮播 图
 * Author:陈懿鹏
 * Data:2017/5/25.
 */


public class ListBannerBean {


    /**
     * ret : 0
     * data : {"banner":[{"image":"","click":""},{"image":"","click":""},{"image":"","click":""}]}
     */



    private int id;
    private int ret;

    private DataBean data;



    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static class DataBean {

        private int id;

        private List<BannerBean> banner;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }


        public static class BannerBean {
            /**
             * image :
             * click :
             */

            private int id;
            private String image;
            private String click;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getClick() {
                return click;
            }

            public void setClick(String click) {
                this.click = click;
            }
        }
    }
}
