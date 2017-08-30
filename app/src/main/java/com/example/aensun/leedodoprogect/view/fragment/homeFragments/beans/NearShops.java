package com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans;

import com.google.gson.Gson;

import java.util.List;

/**
 * date:2017/8/17
 * author:张毛第
 * function:
 */

public class NearShops {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":null,"totalSize":5,"totalPage":1,"list":[{"shopId":8,"shopName":"兰州拉面","shopDescription":"兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰：\"兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。\"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：\u201c雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面\u201d。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。 ","phone":"18309291927","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4222264290","latitude":"39.9647538159","address":"北京市朝阳区和平街街道和平家园","integralRate":3,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 21:00:00.0","tags":"wifi","createTime":1501487875000,"perCapitaConsumption":25,"categoryId":21,"distance":""},{"shopId":104,"shopName":"花店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119052887","latitude":"40.0180509945","address":"北京市通州区宋庄镇辛店村西北方向","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":18,"distance":""},{"shopId":101,"shopName":"体育店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4118838310","latitude":"39.9747522601","address":"北京市朝阳区和平街街道胜古北社区","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":43,"distance":""},{"shopId":100,"shopName":"水果店","shopDescription":"","phone":"15623148569","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4136433601","latitude":"39.9683718429","address":"北京市朝阳区和平街街道胜古庄社区西南方向","integralRate":9,"commissionRate":10,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车位","createTime":1501556364000,"perCapitaConsumption":50,"categoryId":42,"distance":""},{"shopId":102,"shopName":"菜市场","shopDescription":"菜市场","phone":"18626535187","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119267464","latitude":"39.9824967600","address":"北京市朝阳区小关街道小关社区西北方向","integralRate":8,"commissionRate":10,"businessStartTime":"0002-11-30 00:00:00.0","businessEndTime":"0002-11-30 00:00:00.0","tags":"wifi","createTime":1501829773000,"perCapitaConsumption":50,"categoryId":42,"distance":""}]}
     */

    public String code;
    public String descirption;
    public ObjectBean object;

    public static NearShops objectFromData(String str) {

        return new Gson().fromJson(str, NearShops.class);
    }

    public static class ObjectBean {
        /**
         * pageNum : null
         * totalSize : 5
         * totalPage : 1
         * list : [{"shopId":8,"shopName":"兰州拉面","shopDescription":"兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰：\"兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。\"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：\u201c雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面\u201d。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。 ","phone":"18309291927","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4222264290","latitude":"39.9647538159","address":"北京市朝阳区和平街街道和平家园","integralRate":3,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 21:00:00.0","tags":"wifi","createTime":1501487875000,"perCapitaConsumption":25,"categoryId":21,"distance":""},{"shopId":104,"shopName":"花店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119052887","latitude":"40.0180509945","address":"北京市通州区宋庄镇辛店村西北方向","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":18,"distance":""},{"shopId":101,"shopName":"体育店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4118838310","latitude":"39.9747522601","address":"北京市朝阳区和平街街道胜古北社区","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":43,"distance":""},{"shopId":100,"shopName":"水果店","shopDescription":"","phone":"15623148569","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4136433601","latitude":"39.9683718429","address":"北京市朝阳区和平街街道胜古庄社区西南方向","integralRate":9,"commissionRate":10,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车位","createTime":1501556364000,"perCapitaConsumption":50,"categoryId":42,"distance":""},{"shopId":102,"shopName":"菜市场","shopDescription":"菜市场","phone":"18626535187","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119267464","latitude":"39.9824967600","address":"北京市朝阳区小关街道小关社区西北方向","integralRate":8,"commissionRate":10,"businessStartTime":"0002-11-30 00:00:00.0","businessEndTime":"0002-11-30 00:00:00.0","tags":"wifi","createTime":1501829773000,"perCapitaConsumption":50,"categoryId":42,"distance":""}]
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
             * shopId : 8
             * shopName : 兰州拉面
             * shopDescription : 兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰："兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：“雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面”。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。
             * phone : 18309291927
             * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
             * verticalVersionPicture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
             * markPicture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
             * longitude : 116.4222264290
             * latitude : 39.9647538159
             * address : 北京市朝阳区和平街街道和平家园
             * integralRate : 3
             * commissionRate : 12
             * businessStartTime : 2017-07-13 08:00:00.0
             * businessEndTime : 2017-07-13 21:00:00.0
             * tags : wifi
             * createTime : 1501487875000
             * perCapitaConsumption : 25
             * categoryId : 21
             * distance :
             */

            public int shopId;
            public String shopName;
            public String shopDescription;
            public String phone;
            public String picture;
            public String verticalVersionPicture;
            public String markPicture;
            public String longitude;
            public String latitude;
            public String address;
            public int integralRate;
            public int commissionRate;
            public String businessStartTime;
            public String businessEndTime;
            public String tags;
            public long createTime;
            public int perCapitaConsumption;
            public int categoryId;
            public String distance;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }
        }
    }
}
