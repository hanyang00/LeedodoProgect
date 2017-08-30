package com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans;

import com.google.gson.Gson;

/**
 * date:2017/8/24
 * author:张毛第
 * function:
 */

public class DetailsPageBean {
    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"shopId":8,"shopName":"兰州拉面","shopDescription":"兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰：\"兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。\"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：\u201c雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面\u201d。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。 ","phone":"18309291927","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"","markPicture":"","longitude":"116.4222264290","latitude":"39.9647538159","address":"北京市朝阳区和平街街道和平家园","integralRate":3,"commissionRate":-2,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 21:00:00.0","tags":"wifi","createTime":1501487875000,"perCapitaConsumption":25,"categoryId":21,"distance":""}
     */

    public String code;
    public String descirption;
    public ObjectBean object;

    public static DetailsPageBean objectFromData(String str) {

        return new Gson().fromJson(str, DetailsPageBean.class);
    }

    public static class ObjectBean {
        /**
         * shopId : 8
         * shopName : 兰州拉面
         * shopDescription : 兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰："兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：“雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面”。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。
         * phone : 18309291927
         * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
         * verticalVersionPicture :
         * markPicture :
         * longitude : 116.4222264290
         * latitude : 39.9647538159
         * address : 北京市朝阳区和平街街道和平家园
         * integralRate : 3
         * commissionRate : -2
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

        public static ObjectBean objectFromData(String str) {

            return new Gson().fromJson(str, ObjectBean.class);
        }
    }
}
