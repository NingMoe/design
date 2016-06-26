<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="main" role="main">

    <!-- RIBBON -->
    <div id="ribbon">

        <!-- 刷新按钮 -->
    <span class="ribbon-button-alignment">
        <span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"
              rel="tooltip" data-placement="bottom"
              data-original-title="<i class='text-warning fa fa-warning'></i> 警告！将清空本地缓存并刷新页面." data-html="true">
            <i class="fa fa-refresh"></i>
        </span>
    </span>

        <!-- 面包屑 开始 -->
        <ol class="breadcrumb" id="myBreadCrumb">
            <li>首页</li>
        </ol>
        <!-- 面包屑 结束 -->

    </div>
    <!-- END RIBBON -->

    <!-- MAIN CONTENT -->
    <div id="content" style="opacity: 1;">

        <div class="row">
            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
                <h1 class="page-title txt-color-blueDark">
                    <i class="fa fa-home fa-fw "></i>
                    首页 <span>&gt;&nbsp;&nbsp;通知</span>
                </h1>
            </div>
        </div>

        <div class="col-sm-12" >

            <div class="well" style="opacity: 2;">

                <h3><i>安徽财经大学毕业论文选题系统</i> </h3>

                <div class="jumbotron" id="jumbotron">
                    <h1 >毕业论文选题需知！</h1>
                    <div class="alert alert-success alert-block">
                        <a href="#" data-dismiss="alert" class="close">×</a>
                        <h4 class="alert-heading">通知：</h4>
                        <b id="notify">${notify.notify}</b>
                    </div>
                    <div class="alert alert-danger alert-block">
                        <a href="#" data-dismiss="alert" class="close">×</a>
                        <h4 class="alert-heading">注意：</h4>
                        <b id="warning">${notify.warning}</b>
                    </div>
                    <p>
                        <a href="/login" role="button" class="btn btn-primary btn-lg">退出系统</a>
                    </p>
                </div>

            </div>
        </div>

    </div>
    <!-- END MAIN CONTENT -->

</div>
