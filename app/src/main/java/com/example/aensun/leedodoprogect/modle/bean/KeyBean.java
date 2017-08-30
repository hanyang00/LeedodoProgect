package com.example.aensun.leedodoprogect.modle.bean;

/**
 * Created by aensun on 2017-08-26.
 */

public class KeyBean {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public KeyBean(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "KeyBean{" +
                "key='" + key + '\'' +
                '}';
    }
}
