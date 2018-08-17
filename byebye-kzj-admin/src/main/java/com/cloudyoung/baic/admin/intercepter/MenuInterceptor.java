package com.cloudyoung.baic.admin.intercepter;

import com.alibaba.fastjson.JSON;
import com.cloudyoung.baic.admin.annotation.ResourceKey;
import com.cloudyoung.baic.service.adminservice.AuthAccountService;
import com.cloudyoung.baic.vo.admin.MenuItemVO;
import com.cloudyoung.baic.vo.admin.ResourceVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2017/9/14 19:37  by  张成智（zhangcz@cloud-young.com）创建
 */
public class MenuInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthAccountService authAccountService;

    private static final Logger logger = LogManager.getLogger(MenuInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //ajax请求直接返回
        if (httpServletRequest.getHeader("x-requested-with") != null && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        }
        List<MenuItemVO> menuList = null;
        List<String> allMenuKey = null;
        Principal userPrincipal = httpServletRequest.getUserPrincipal();
        if (userPrincipal == null) {
            return true;
        }
        String userName = userPrincipal.getName();
        List<ResourceVo> result = authAccountService.getResourceListByAccountName(userName);
        if (CollectionUtils.isEmpty(result)) {
            return true;
        }
        List<ResourceVo> resourceList = result;
        logger.info(String.format("获取到的权限菜单列表为：%s", JSON.toJSONString(resourceList)));
        if (resourceList == null || resourceList.size() <= 0) {
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        //排序
//        Collections.sort(resourceList, Comparator.comparing(PermissionResource::getOrderNum));
        //获取用户所有的有权限的菜单
        menuList = GetAllMenu(resourceList);
        allMenuKey = GetAllMenuKey(resourceList);


        httpServletRequest.setAttribute("menuList", menuList);
        String menukey = "";
        String parentMenuKey = "";

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        ResourceKey methodAnnotation = method.getAnnotation(ResourceKey.class);
        // 有 @ResourceKey 注解，需要认证
        if (methodAnnotation != null) {
            menukey = methodAnnotation.value();
            if (StringUtils.isNotEmpty(menukey)) {
                parentMenuKey = GetParentMenuKey(menukey, menuList);
                if (!allMenuKey.contains(menukey)) {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/error/noauthority");
                    return false;
                }
            }
        }
        httpServletRequest.setAttribute("parentMenuKey", parentMenuKey);
        httpServletRequest.setAttribute("menukey", menukey);
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * @param resourceList 资源列表
     * @return
     * @Descpription:获取所有菜单key
     * @version 1.0  2017/9/26 14:49   by  张成智（zhangcz@cloud-young.com）创建
     */
    private List<String> GetAllMenuKey(List<ResourceVo> resourceList) {
        List<String> allMenuKey = new ArrayList<>();
        if (resourceList != null && resourceList.size() > 0) {
            allMenuKey = resourceList.stream().map(x -> x.getResourceKey()).collect(Collectors.toList());
        }
        return allMenuKey;
    }

    /**
     * 获取上级菜单key
     *
     * @param menuKey
     * @return
     */
    public String GetParentMenuKey(String menuKey, List<MenuItemVO> menuList) throws IOException {
        MenuItemVO item = null;
        for (MenuItemVO menu : menuList) {
            if (menu.getMenuKey().equals(menuKey)) {
                item = menu;
                break;
            }
        }
        if (item == null) {
            for (MenuItemVO menu : menuList) {
                if (menu.getSubMenu() != null) {
                    for (MenuItemVO subMenu : menu.getSubMenu()) {
                        if (subMenu.getMenuKey().equals(menuKey)) {
                            item = subMenu;
                            break;
                        }
                    }
                }
            }
        }
        if (item == null) {
            return "";
        }
        return item.getParentMenuKey();
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    private List<MenuItemVO> GetAllMenu(List<ResourceVo> resourceList) throws IOException {
        List<MenuItemVO> menuList = new ArrayList<>();
        for (ResourceVo res : resourceList) {
            MenuItemVO menuItemVOTmp = new MenuItemVO();
            menuItemVOTmp.setMenuKey(res.getResourceKey());
            menuItemVOTmp.setLinkUrl(res.getResourceUrl());
            //设置父id
            for (ResourceVo resParent : resourceList) {
                if (res.getParentId() != null && res.getParentId() != 0 && res.getParentId().equals(resParent.getResourceId())) {
                    menuItemVOTmp.setParentMenuKey(resParent.getResourceKey());
                    break;
                }
            }
            menuItemVOTmp.setText(res.getResourceName());
            menuItemVOTmp.setIconClass(res.getIcon());
            menuList.add(menuItemVOTmp);
        }
        for (MenuItemVO menuItemVO : menuList) {
            List<MenuItemVO> subMenu = new ArrayList<>();
            for (MenuItemVO menuItemVOSub : menuList) {
                if (menuItemVO.getMenuKey().equals(menuItemVOSub.getParentMenuKey())) {
                    subMenu.add(menuItemVOSub);
                }
            }
            menuItemVO.setSubMenu(subMenu);
        }
        menuList.removeIf(x -> x.getParentMenuKey() != null);
        return menuList;
    }

    /**
     * 递归遍历菜单，填充到List
     *
     * @param parentNode
     * @param menuList
     * @return
     */
    private List<MenuItemVO> LoadNode(MenuItemVO parentNode, List<MenuItemVO> menuList) {
        if (menuList == null || menuList.size() <= 0) {
            return null;
        }
        List<MenuItemVO> list = new ArrayList<MenuItemVO>();
        menuList.stream().forEach(menu -> {
            if (parentNode != null) {
                menu.setParentMenuKey(parentNode.getMenuKey());
            }
            if (menu.getSubMenu() != null && menu.getSubMenu().size() > 0) {
                List<MenuItemVO> menuItemList = LoadNode(menu, menu.getSubMenu());
                menu.setSubMenu(menuItemList);
            }
            list.add(menu);
        });
        return list;
    }
}
