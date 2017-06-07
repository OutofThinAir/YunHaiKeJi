package yunhaikeji.com.yuzhiweilai.model.bena;

/**
 * Use:登录的bean
 * Author:陈懿鹏
 * Data:2017/6/5.
 */

public class LoginBean {

    /**
     * data : {"alert":false,"message":"","session":"5559936945f96e05efbbf344"}
     * ret : 0
     */

    private DataBean data;
    private int ret;
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * alert : false
         * message :
         * session : 5559936945f96e05efbbf344
         */

        private boolean alert;
        private String message;
        private String session;

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }
    }
}
