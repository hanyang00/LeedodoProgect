package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils;

import java.io.Serializable;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/25 17:25
 */
public class CommodityListBean implements Serializable {

    /**
     * code : 1000
     * descirption : 系统处理成功                       描述
     * object : {"shopId":2,"shopName":"美颜化妆（）","shopDescription":"高端化妆","phone":"17791312895","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"","markPicture":"","longitude":"116.4236920843","latitude":"39.9085650983","address":"中国北京市北京市东城区东交民巷1号","integralRate":8,"commissionRate":-2,"businessStartTime":"0002-11-30 00:00:00.0","businessEndTime":"2020-11-30 00:00:00.0","tags":"wifi","createTime":1500261781000,"perCapitaConsumption":50,"categoryId":40,"distance":""}
     */

    private String code;
    private String descirption;
    private ObjectBean object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public  class ObjectBean implements Serializable{
        /**
         * shopId : 2
         * shopName : 美颜化妆（）
         * shopDescription : 高端化妆
         * phone : 17791312895
         * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
         * verticalVersionPicture :
         * markPicture :
         * longitude : 116.4236920843
         * latitude : 39.9085650983
         * address : 中国北京市北京市东城区东交民巷1号
         * integralRate : 8
         * commissionRate : -2
         * businessStartTime : 0002-11-30 00:00:00.0
         * businessEndTime : 2020-11-30 00:00:00.0
         * tags : wifi
         * createTime : 1500261781000
         * perCapitaConsumption : 50
         * categoryId : 40
         * distance :
         */

        private int shopId;
        private String shopName;
        private String shopDescription;
        private String phone;
        private String picture;
        private String verticalVersionPicture;
        private String markPicture;
        private String longitude;
        private String latitude;
        private String address;
        private int integralRate;
        private int commissionRate;
        private String businessStartTime;
        private String businessEndTime;
        private String tags;
        private long createTime;
        private int perCapitaConsumption;
        private int categoryId;
        private String distance;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopDescription() {
            return shopDescription;
        }

        public void setShopDescription(String shopDescription) {
            this.shopDescription = shopDescription;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getVerticalVersionPicture() {
            return verticalVersionPicture;
        }

        public void setVerticalVersionPicture(String verticalVersionPicture) {
            this.verticalVersionPicture = verticalVersionPicture;
        }

        public String getMarkPicture() {
            return markPicture;
        }

        public void setMarkPicture(String markPicture) {
            this.markPicture = markPicture;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getIntegralRate() {
            return integralRate;
        }

        public void setIntegralRate(int integralRate) {
            this.integralRate = integralRate;
        }

        public int getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(int commissionRate) {
            this.commissionRate = commissionRate;
        }

        public String getBusinessStartTime() {
            return businessStartTime;
        }

        public void setBusinessStartTime(String businessStartTime) {
            this.businessStartTime = businessStartTime;
        }

        public String getBusinessEndTime() {
            return businessEndTime;
        }

        public void setBusinessEndTime(String businessEndTime) {
            this.businessEndTime = businessEndTime;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getPerCapitaConsumption() {
            return perCapitaConsumption;
        }

        public void setPerCapitaConsumption(int perCapitaConsumption) {
            this.perCapitaConsumption = perCapitaConsumption;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "ObjectBean{" +
                    "shopId=" + shopId +
                    ", shopName='" + shopName + '\'' +
                    ", shopDescription='" + shopDescription + '\'' +
                    ", phone='" + phone + '\'' +
                    ", picture='" + picture + '\'' +
                    ", verticalVersionPicture='" + verticalVersionPicture + '\'' +
                    ", markPicture='" + markPicture + '\'' +
                    ", longitude='" + longitude + '\'' +
                    ", latitude='" + latitude + '\'' +
                    ", address='" + address + '\'' +
                    ", integralRate=" + integralRate +
                    ", commissionRate=" + commissionRate +
                    ", businessStartTime='" + businessStartTime + '\'' +
                    ", businessEndTime='" + businessEndTime + '\'' +
                    ", tags='" + tags + '\'' +
                    ", createTime=" + createTime +
                    ", perCapitaConsumption=" + perCapitaConsumption +
                    ", categoryId=" + categoryId +
                    ", distance='" + distance + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CommodityListBean{" +
                "code='" + code + '\'' +
                ", descirption='" + descirption + '\'' +
                ", object=" + object +
                '}';
    }
}
