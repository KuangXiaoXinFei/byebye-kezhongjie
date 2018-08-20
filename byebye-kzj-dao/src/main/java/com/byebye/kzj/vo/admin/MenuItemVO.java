package com.byebye.kzj.vo.admin;

import java.util.List;

/**
 * Description:菜单实体
 * All Rights Reserved.
 *
 * @version 1.0  2017/9/15 13:13  by  张成智（zhangcz@cloud-young.com）创建
 */
public class MenuItemVO {
    /// <summary>
    /// 菜单Key(必须唯一)
    /// </summary>
    private String menuKey;

    /// <summary>
    /// 顶级Key(暂定为两级)
    /// </summary>
    private String parentMenuKey;


    /// <summary>
    /// 链接地址
    /// </summary>
    private String linkUrl;

    /// <summary>
    /// 显示文本
    /// </summary>
    private String text;

    /// <summary>
    /// class属性内容
    /// </summary>
    private String iconClass;

    /// <summary>
    /// 目标窗口位置
    /// </summary>
    private String target;

    /// <summary>
    /// 子菜单
    /// </summary>
    private List<MenuItemVO> subMenu = null;

    /**
     * 应用key
     */
    private String appkey;

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getParentMenuKey() {
        return parentMenuKey;
    }

    public void setParentMenuKey(String parentMenuKey) {
        this.parentMenuKey = parentMenuKey;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<MenuItemVO> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MenuItemVO> subMenu) {
        this.subMenu = subMenu;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
}
