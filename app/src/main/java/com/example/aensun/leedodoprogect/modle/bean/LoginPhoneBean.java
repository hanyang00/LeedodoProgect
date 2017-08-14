package com.example.aensun.leedodoprogect.modle.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aensun on 2017-08-14.
 */

public class LoginPhoneBean {


    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"phone":"13552278749","createTime":1502626386000,"nickname":"大道用户8749","userId":127,"picture":"","token":"5588aa2f751c990f121ca4c6ae89de17"}
     */

    private String code;
    private String descirption;
    private ObjectBean object;


    @Override
    public String toString() {
        return "LoginPhoneBean{" +
                "code='" + code + '\'' +
                ", descirption='" + descirption + '\'' +
                ", object=" + object +
                '}';
    }

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

    public static class ObjectBean {
        /**
         * phone : 13552278749
         * createTime : 1502626386000
         * nickname : 大道用户8749
         * userId : 127
         * picture :
         * token : 5588aa2f751c990f121ca4c6ae89de17
         */

        private String phone;
        private long createTime;
        @SerializedName("nickname")
        private String nickName;
        private int userId;
        @SerializedName("picture")
        private String picTure;
        private String token;

        @Override
        public String toString() {
            return "ObjectBean{" +
                    "phone='" + phone + '\'' +
                    ", createTime=" + createTime +
                    ", nickName='" + nickName + '\'' +
                    ", userId=" + userId +
                    ", picTure='" + picTure + '\'' +
                    ", token='" + token + '\'' +
                    '}';
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPicTure() {
            return picTure;
        }

        public void setPicTure(String picTure) {
            this.picTure = picTure;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
