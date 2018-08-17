
package com.cloudyoung.baic.vo.api;

import java.io.Serializable;

public class BaseVo implements Serializable {

    private String version_name; //app版本号
    private String brand; //手机品牌
    private String mobile_model; //手机型号
    private String system_version; //手机系统版本
    private String screen_pixel; //手机分辨率
    private String platform; // 平台 ios,android
    private String network_type; //网络类型

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMobile_model() {
        return mobile_model;
    }

    public void setMobile_model(String mobile_model) {
        this.mobile_model = mobile_model;
    }

    public String getSystem_version() {
        return system_version;
    }

    public void setSystem_version(String system_version) {
        this.system_version = system_version;
    }

    public String getScreen_pixel() {
        return screen_pixel;
    }

    public void setScreen_pixel(String screen_pixel) {
        this.screen_pixel = screen_pixel;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getNetwork_type() {
        return network_type;
    }

    public void setNetwork_type(String network_type) {
        this.network_type = network_type;
    }
}
