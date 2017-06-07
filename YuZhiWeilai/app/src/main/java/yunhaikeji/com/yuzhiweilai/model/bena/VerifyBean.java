package yunhaikeji.com.yuzhiweilai.model.bena;

/**
 * Use:验证的bean
 * Author:陈懿鹏
 * Data:2017/6/2.
 */

public class VerifyBean {

    /**
     * data : {"uname":"22222222223","login":true,"session":"40dec907d469be8b10ba6ec1a72923c77bc49a37","message":"测试弹窗","alert":true}
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
         * uname : 22222222223
         * login : true
         * session : 40dec907d469be8b10ba6ec1a72923c77bc49a37
         * message : 测试弹窗
         * alert : true
         */

        private String uname;
        private boolean login;
        private String session;
        private String message;
        private boolean alert;

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }
    }
}
