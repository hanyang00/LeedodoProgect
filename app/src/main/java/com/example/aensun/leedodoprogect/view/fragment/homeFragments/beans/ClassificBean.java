package com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans;

import com.google.gson.Gson;

import java.util.List;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public class ClassificBean {


    /**
     * code : SUCCESS
     * descirption :
     * object : {"pageNum":null,"totalSize":20,"totalPage":2,"list":[{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":20,"categoryName":"游戏动漫","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":19,"categoryName":"图书乐器","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":18,"categoryName":"鲜花宠物","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":17,"categoryName":"汽车","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":16,"categoryName":"运动户外","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":15,"categoryName":"二手交易","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":14,"categoryName":"机票火车票","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":13,"categoryName":"家电","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":12,"categoryName":"服装","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":11,"categoryName":"充值缴费","sequence":0,"parentId":null,"picture":"","type":null,"status":0}]}
     */

    public String code;
    public String descirption;
    public ObjectBean object;

    public static ClassificBean objectFromData(String str) {

        return new Gson().fromJson(str, ClassificBean.class);
    }

    public static class ObjectBean {
        /**
         * pageNum : null
         * totalSize : 20
         * totalPage : 2
         * list : [{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":20,"categoryName":"游戏动漫","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":19,"categoryName":"图书乐器","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":18,"categoryName":"鲜花宠物","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":17,"categoryName":"汽车","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":16,"categoryName":"运动户外","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":15,"categoryName":"二手交易","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":14,"categoryName":"机票火车票","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":13,"categoryName":"家电","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":12,"categoryName":"服装","sequence":0,"parentId":null,"picture":"","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":11,"categoryName":"充值缴费","sequence":0,"parentId":null,"picture":"","type":null,"status":0}]
         */

        public Object pageNum;
        public int totalSize;
        public int totalPage;
        public List<ListBean> list;

        public static ObjectBean objectFromData(String str) {

            return new Gson().fromJson(str, ObjectBean.class);
        }

        public static class ListBean {
            /**
             * beginIndex : 0
             * pageSize : 10
             * sort :
             * order : desc
             * categoryId : 20
             * categoryName : 游戏动漫
             * sequence : 0
             * parentId : null
             * picture :
             * type : null
             * status : 0
             */

            public int beginIndex;
            public int pageSize;
            public String sort;
            public String order;
            public int categoryId;
            public String categoryName;
            public int sequence;
            public Object parentId;
            public String picture;
            public Object type;
            public int status;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }
        }
    }
}
