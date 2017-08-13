package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerbyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：RecommendBean
 * 创建人：yangyobgli
 * 创建时间：2017/8/13 14:19
 */
public class RecommendBean {
    private String imv;
    private String name;
    private String address;

    public RecommendBean(String imv, String name, String address) {
        this.imv = imv;
        this.name = name;
        this.address = address;
    }

    public String getImv() {
        return imv;
    }

    public void setImv(String imv) {
        this.imv = imv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * http://img2.woyaogexing.com/2017/07/20/54832afa64a95dbc!600x600.jpg
     * @return
     */

    public static List<RecommendBean> getRecommendList(){
        List<RecommendBean> list=new ArrayList<>();
        list.add(new RecommendBean("http://img2.woyaogexing.com/2017/07/20/53f9336db3137d95!600x600.jpg","小可爱的西店","[安贞门]"));
        list.add(new RecommendBean("http://img2.woyaogexing.com/2017/07/20/4a1cdb845ba212dd!600x600.jpg","小可爱的西店","[安贞门]"));
        list.add(new RecommendBean("http://img2.woyaogexing.com/2017/07/20/7e189f3a01569829!600x600.jpg","小可爱的西店","[安贞门]"));
        return list;
    }
    @Override
    public String toString() {
        return "RecommendBean{" +
                "imv='" + imv + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
