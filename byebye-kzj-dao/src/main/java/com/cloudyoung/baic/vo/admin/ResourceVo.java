package com.cloudyoung.baic.vo.admin;

import java.io.Serializable;

/**
 * Description:
 * @version 1.0  2018/7/6 15:45  by  李娜（lina@cloud-young.com）创建
 * @param 
 * @return
 */
public class ResourceVo implements Serializable {
    private Integer resourceId;
    private String resourceName;
    private String resourceKey;
    private String resourceUrl;
    private String icon;
    private Integer parentId;
    private Integer orderNum;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
