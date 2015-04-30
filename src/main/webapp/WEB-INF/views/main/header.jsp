<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HEADER开始 -->
<header id="header">
    <%-- logo区域 --%>
    <div id="logo-group">
        <span id="logo"> <img src="${ctx}/img/logo.png" style="cursor:pointer" id="logoImg"> &nbsp;&nbsp;<font
                style="font-size: large">毕业论文选题系统</font></span>
    </div>

    <div class="pull-right">
        <!-- 隐藏菜单按钮 -->
        <div id="hide-menu" class="btn-header pull-right">
            <span> <a href="javascript:void(0);" data-action="toggleMenu" title="菜单收缩"><i class="fa fa-reorder"></i></a> </span>
        </div>
        <!-- 登出按钮 -->
        <div id="logout" class="btn-header transparent pull-right">
            <span> <a href="/login" title="登出" data-action="userLogout" data-logout-msg="确定离开系统回到登陆界面吗？"><i
                    class="fa fa-sign-out"></i></a> </span>
        </div>

        <!-- 全屏按钮 -->
        <div id="fullscreen" class="btn-header transparent pull-right">
            <span> <a href="javascript:void(0);" data-action="launchFullscreen" title="全屏"><i
                    class="fa fa-arrows-alt"></i></a> </span>
        </div>
    </div>
    <!-- 全文搜索 -->
    <form class="header-search pull-right">
        <input id="search-fld" type="text" disabled="disabled" placeholder="${now}登入" style="background-color: #d6d6d6; font-size: larger; border-radius: 5px;  ">
        <button type="button">
            <i class="fa fa-smile-o "></i>
        </button>
    </form>
</header>
<!-- HEADER结束 -->
