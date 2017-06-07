package yunhaikeji.com.yuzhiweilai.model.bena;

import java.util.List;

/**
 * Use:专辑课程
 * Author:陈懿鹏
 * Data:2017/5/28.
 */

public class SpecialClassBean {


    /**
     * data : {"page_index":"0","page_size":"5","topic":[{"image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","length":5,"object_id":"20000028","title":"专辑测试1","title2":"测试","type":1},{"image":"https://pretty.f8cam.com/static/image/product/tf/tfmphswfje.jpg","length":3,"object_id":"20000031","title":"测试所用","title2":"111","type":2},{"image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","length":1,"object_id":"20000030","title":"专辑测试1","title2":"测试","type":1},{"image":"https://pretty.f8cam.com/static/image/product/np/nplxaplnag.jpg","length":1,"object_id":"20000037","title":"ghmm","title2":"mjhm","type":1}],"total":4}
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
         * page_index : 0
         * page_size : 5
         * topic : [{"image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","length":5,"object_id":"20000028","title":"专辑测试1","title2":"测试","type":1},{"image":"https://pretty.f8cam.com/static/image/product/tf/tfmphswfje.jpg","length":3,"object_id":"20000031","title":"测试所用","title2":"111","type":2},{"image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","length":1,"object_id":"20000030","title":"专辑测试1","title2":"测试","type":1},{"image":"https://pretty.f8cam.com/static/image/product/np/nplxaplnag.jpg","length":1,"object_id":"20000037","title":"ghmm","title2":"mjhm","type":1}]
         * total : 4
         */

        private String page_index;
        private String page_size;
        private int total;
        private List<TopicBean> topic;

        public String getPage_index() {
            return page_index;
        }

        public void setPage_index(String page_index) {
            this.page_index = page_index;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<TopicBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicBean> topic) {
            this.topic = topic;
        }

        public static class TopicBean {
            /**
             * image : https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg
             * length : 5
             * object_id : 20000028
             * title : 专辑测试1
             * title2 : 测试
             * type : 1
             */

            private String image;
            private int length;
            private String object_id;
            private String title;
            private String title2;
            private int type;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getObject_id() {
                return object_id;
            }

            public void setObject_id(String object_id) {
                this.object_id = object_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle2() {
                return title2;
            }

            public void setTitle2(String title2) {
                this.title2 = title2;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
