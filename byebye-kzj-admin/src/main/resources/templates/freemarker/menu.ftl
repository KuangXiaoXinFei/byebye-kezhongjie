<#macro menu >
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper affix">
    <div class="page-sidebar navbar-collapse collapse">
        <ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
            <li class="sidebar-toggler-wrapper">
                <div class="sidebar-toggler fa fa-bars">
                </div>
            </li>
            <#if menuList?? && (menuList?size>0)>
                <#list menuList as menuItem>
                    <#assign hasChild=((menuItem.subMenu)?? &&((menuItem.subMenu)?size>0))?string('true','false')>
                    <#if hasChild=='true'>
                        <#assign active=((menuItem.menuKey)==(parentMenuKey!))?string('active','')>
                        <#assign open=(active!='')?string('open','')>
                        <#assign downblue=(active!='')?string('down-blue','')>
                        <li class="${active} ${open}">
                            <a href="javascript:void(0);">
                                <span class="${downblue}"></span>
                                <i class="${menuItem.iconClass!'icon-envelope-open'}"></i>
                                <span class="title">${menuItem.text!''}</span>
                                <span class="${active!''}"></span>
                                <span class="selected"></span>
                                <#if hasChild=='true'>
                                    <span class="arrow ${open}"></span>
                                <#else>
                                    <span class="arrow"></span>
                                </#if>
                            </a>

                            <ul class="sub-menu">
                                <#list menuItem.subMenu as subMenuItem>
                                    <#if (subMenuItem.menuKey)==menukey>
                                    <li class="open">
                                    <#else>
                                    <li>
                                    </#if>
                                    <a href="${path}${subMenuItem.linkUrl!''}" target="${subMenuItem.target!'_self'}">
                                    <#--<i class="${subMenuItem.iconClass!'icon-briefcase'}"></i>-->
                                        <span class="title">${subMenuItem.text!''}</span>
                                        <span class="selected"></span>
                                    </a>
                                </li>
                                </#list>
                            </ul>
                        </li>
                    <#else>
                        <#assign active2=((menuItem.menuKey)==menukey)?string('open','')>
                        <#assign downblue2=(active2!='')?string('down-blue','')>
                        <li class="${active2}">
                            <a href="${path}${menuItem.linkUrl!''}" target="${menuItem.target!'_self'}">
                                <span class="${downblue2}"></span>
                                <i class="${menuItem.iconClass!'icon-envelope-open'}"></i>
                                <span class="title">${menuItem.text!''}</span>
                            </a>
                        </li>
                    </#if>
                </#list>
            </#if>
        </ul>
    </div>
</div>
<!-- END CONTAINER -->
</#macro>