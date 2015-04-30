<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en-us" id="extr-page">

<head>
    <meta charset="utf-8">
    <title>登录论文选题系统</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- #CSS Links -->
    <!-- Basic Styles -->
    <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/mystyle.css">

    <!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
    <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css">

    <!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
    <link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css">

    <!-- #FAVICONS -->
    <link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">
    <link rel="icon" href="img/favicon.png" type="image/x-icon">

</head>

<body class="animated fadeInDown">

<div id="main" role="main" class="login_main">
    <!-- MAIN CONTENT -->
    <div id="content" class="container">

        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
                <h1 class="txt-color-red login-header-big">安徽财经大学论文选题系统</h1>

                <div class="hero">

                    <div class="pull-left login-desc-box-l">
                        <h4 class="paragraph-header">请同学们登录后选题，必须在规定时间内选好题目，并提交开题报告。</h4>
                    </div>

                    <img src="img/bigaufe.png" class="pull-right display-image" style="width:350px">

                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <h5 class="about-heading">关于本系统</h5>

                        <p>本系统最终解释权归属安徽财经大学</p>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <h5 class="about-heading">许可证</h5>

                        <p>
                            www.aufe.edu.cn 安徽财经大学 Copyright © 2015-2016
                        </p>
                    </div>
                </div>

            </div>
            <div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
                <div class="well no-padding">
                    <form method="post" id="login-form" class="smart-form client-form">
                        <header>
                            登录
                        </header>

                        <fieldset>
                            <section>
                                <label class="label">学号</label>
                                <label class="input state-success"> <i class="icon-append fa fa-user"></i>
                                    <input type="text" name="account" id="account">
                                    <b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i>请输入学号</b></label>
                            </section>

                            <section>
                                <label class="label">密码</label>
                                <label class="input state-success"> <i class="icon-append fa fa-lock"></i>
                                    <input type="password" name="password" id="password" >
                                    <b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i>请输入密码</b>
                                </label>

                                <div class="note">
                                    <b>*请务必输入正确的学号密码</b>
                                </div>
                            </section>

                            <section>
                                <label class="checkbox ">
                                    <input type="checkbox" name="remember" checked="">
                                    <i></i>记住密码</label>
                            </section>
                        </fieldset>
                        <footer>
                            <button type="button" class="btn btn-success" onclick="loginCheck();">
                                登录
                            </button>
                        </footer>
                    </form>

                </div>

                <ul class="list-inline text-center">
                    <li>
                        <a href="http://weibo.com/" class="btn btn-primary btn-circle"><i class="fa fa-weibo"></i></a>
                    </li>
                    <li>
                        <a href="https://wx.qq.com/" class="btn btn-info btn-circle"><i class="fa fa-weixin"></i></a>
                    </li>
                    <li>
                        <a href="https://www.baidu.com/" class="btn btn-warning btn-circle"><i class="fa fa-paw"></i></a>
                    </li>
                    <li>
                        <a href="http://www.qq.com/" class="btn btn-danger btn-circle"><i class="fa fa-qq"></i></a>
                    </li>
                </ul>

            </div>
        </div>
    </div>
</div>

<!--================================================== -->

<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
<script src="js/plugin/pace/pace.min.js"></script>

<script> if (!window.jQuery) {
    document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');
} </script>

<script> if (!window.jQuery.ui) {
    document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
} </script>
<!-- BOOTSTRAP JS -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- JQUERY VALIDATE -->
<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>
<!-- JQUERY MASKED INPUT -->
<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>
<!-- MAIN APP JS FILE -->
<script src="js/app.min.js"></script>
<%-- 登录模块脚本 --%>
<script src="js/login.js"></script>

<form name="loginForm" action="/design/index" method="post">
    <input type="hidden" value="" name="account" id="loginAccount">
    <input type="hidden" value="" name="password" id="loginPassword">
</form>

</body>
</html>
