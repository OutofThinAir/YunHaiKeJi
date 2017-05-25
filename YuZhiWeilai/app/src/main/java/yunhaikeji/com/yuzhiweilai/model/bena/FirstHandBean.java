package yunhaikeji.com.yuzhiweilai.model.bena;

/**
 * Use:首次握手Bean
 * Author:陈懿鹏
 * Data:2017/5/23.
 */

public class FirstHandBean {

    /**
     * data : {"app_id":"B406A2EF","private_key":"AEF63FBAEDD31000F25FAD2E4C3C2974"}
     * ret : 0
     */

    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        /**
         * app_id : B406A2EF
         * private_key : AEF63FBAEDD31000F25FAD2E4C3C2974
         */

        private String app_id;
        private String private_key;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getPrivate_key() {
            return private_key;
        }

        public void setPrivate_key(String private_key) {
            this.private_key = private_key;
        }
    }
}
