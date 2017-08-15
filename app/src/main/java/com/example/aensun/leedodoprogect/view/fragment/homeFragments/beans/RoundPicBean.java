package com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans;

import com.google.gson.Gson;

import java.util.List;

/**
 * date:2017/8/14
 * author:张毛第
 * function:
 */

public class RoundPicBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":1,"totalSize":3,"totalPage":1,"list":[{"recommendId":7,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502687154900.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":5,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502687136670.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":6,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502687136670.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""}]}
     */

    public String code;
    public String descirption;
    public ObjectBean object;

    public static RoundPicBean objectFromData(String str) {

        return new Gson().fromJson(str, RoundPicBean.class);
    }

    public static class ObjectBean {
        /**
         * pageNum : 1
         * totalSize : 3
         * totalPage : 1
         * list : [{"recommendId":7,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502687154900.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":5,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502687136670.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":6,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502687136670.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""}]
         */

        public int pageNum;
        public int totalSize;
        public int totalPage;
        public List<ListBean> list;

        public static ObjectBean objectFromData(String str) {

            return new Gson().fromJson(str, ObjectBean.class);
        }

        public static class ListBean {
            /**
             * recommendId : 7
             * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502687154900.jpg
             * description :
             * type : -10
             * sequence : -10
             * status : -10
             * createTime :
             */

            public int recommendId;
            public String picture;
            public String description;
            public int type;
            public int sequence;
            public int status;
            public String createTime;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }
        }
    }
}
