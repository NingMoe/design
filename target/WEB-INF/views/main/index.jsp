<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="http://bi.be.xiaomi.com/tags"%>
<!DOCTYPE html>
<html lang="en-us">

<%-- head --%>
<jsp:include page="head.jsp" />
<body class="">

    <%-- Header --%>
    <jsp:include page="header.jsp" />
    <!-- 左侧面板  -->
    <jsp:include page="menu.jsp" />
    <!-- 主面板 -->
    <jsp:include page="main.jsp" />
    <!-- 页足 -->
    <div class="page-footer">
        <div class="row">
            <div class="col-xs-12 col-sm-6">
                <span class="txt-color-white">www.aufe.edu.cn 安徽财经大学 © 2015-2016</span>
            </div>
        </div>
    </div>
    <%-- 引入js脚本 --%>
    <jsp:include page="js.jsp" />
</html>