package yunhaikeji.com.yuzhiweilai.model.bena;

/**
 * Use:注册返回数据bean
 * Author:陈懿鹏
 * Data:2017/6/2.
 */

public class ReginBean {

    /**
     * data : {"session":"ad739ba4fae4327f7406127aa57577b2657a9525","user_new":true}
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
         * session : ad739ba4fae4327f7406127aa57577b2657a9525
         * user_new : true
         */

        private String session;
        private boolean user_new;

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public boolean isUser_new() {
            return user_new;
        }

        public void setUser_new(boolean user_new) {
            this.user_new = user_new;
        }
    }
}
