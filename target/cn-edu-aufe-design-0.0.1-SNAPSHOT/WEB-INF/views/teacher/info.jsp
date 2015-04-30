<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-6">
        <h1 class="page-title txt-color-blueDark"><i class="fa fa-pencil-square-o fa-fw "></i> 个人信息
            <span>&gt;&nbsp; 详情 </span></h1>
    </div>
    <%--<div class="col-lg-6">--%>
    <%--<div id="sparks" class="text-right">--%>
    <%--<div class="btn-group">--%>
    <%--<button type="button" class="btn btn-default" data-action="go_to_list" rel="tooltip"--%>
    <%--data-placement="bottom" data-original-title="返回列表">--%>
    <%--<i class="fa fa-reply text-info"></i>--%>
    <%--</button>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
</div>

<section id="widget-grid">
    <div class="row">
        <article class="col-xs-12 col-sm-12 col-md-7 col-lg-7 sortable-grid ui-sortable">

            <div class="jarviswidget jarviswidget-color-pink jarviswidget-sortable" id="wid-id-88"
                 data-widget-editbutton="false" role="widget" style="position: relative; opacity: 1;">
                <header role="heading">
                    <div class="jarviswidget-ctrls" role="menu"><a href="#" class="button-icon jarviswidget-toggle-btn"
                                                                   rel="tooltip" title="" data-placement="bottom"
                                                                   data-original-title="收起"><i
                            class="fa fa-minus "></i></a> <a href="javascript:void(0);"
                                                             class="button-icon jarviswidget-fullscreen-btn"
                                                             rel="tooltip" title="" data-placement="bottom"
                                                             data-original-title="全屏"><i
                            class="fa fa-expand "></i></a> <a href="javascript:void(0);"
                                                              class="button-icon jarviswidget-delete-btn" rel="tooltip"
                                                              title="" data-placement="bottom"
                                                              data-original-title="关闭"><i
                            class="fa fa-times"></i></a></div>
                    <div class="widget-toolbar" role="menu"><a data-toggle="dropdown"
                                                               class="dropdown-toggle color-box selector"
                                                               href="javascript:void(0);"></a>
                        <ul class="dropdown-menu arrow-box-up-right color-select pull-right">
                            <li><span class="bg-color-green" data-widget-setstyle="jarviswidget-color-green"
                                      rel="tooltip" data-placement="left" data-original-title="Green Grass"></span></li>
                            <li><span class="bg-color-greenDark" data-widget-setstyle="jarviswidget-color-greenDark"
                                      rel="tooltip" data-placement="top" data-original-title="Dark Green"></span></li>
                            <li><span class="bg-color-greenLight" data-widget-setstyle="jarviswidget-color-greenLight"
                                      rel="tooltip" data-placement="top" data-original-title="Light Green"></span></li>
                            <li><span class="bg-color-purple" data-widget-setstyle="jarviswidget-color-purple"
                                      rel="tooltip" data-placement="top" data-original-title="Purple"></span></li>
                            <li><span class="bg-color-magenta" data-widget-setstyle="jarviswidget-color-magenta"
                                      rel="tooltip" data-placement="top" data-original-title="Magenta"></span></li>
                            <li><span class="bg-color-pink" data-widget-setstyle="jarviswidget-color-pink" rel="tooltip"
                                      data-placement="right" data-original-title="Pink"></span></li>
                            <li><span class="bg-color-pinkDark" data-widget-setstyle="jarviswidget-color-pinkDark"
                                      rel="tooltip" data-placement="left" data-original-title="Fade Pink"></span></li>
                            <li><span class="bg-color-blueLight" data-widget-setstyle="jarviswidget-color-blueLight"
                                      rel="tooltip" data-placement="top" data-original-title="Light Blue"></span></li>
                            <li><span class="bg-color-teal" data-widget-setstyle="jarviswidget-color-teal" rel="tooltip"
                                      data-placement="top" data-original-title="Teal"></span></li>
                            <li><span class="bg-color-blue" data-widget-setstyle="jarviswidget-color-blue" rel="tooltip"
                                      data-placement="top" data-original-title="Ocean Blue"></span></li>
                            <li><span class="bg-color-blueDark" data-widget-setstyle="jarviswidget-color-blueDark"
                                      rel="tooltip" data-placement="top" data-original-title="Night Sky"></span></li>
                            <li><span class="bg-color-darken" data-widget-setstyle="jarviswidget-color-darken"
                                      rel="tooltip" data-placement="right" data-original-title="Night"></span></li>
                            <li><span class="bg-color-yellow" data-widget-setstyle="jarviswidget-color-yellow"
                                      rel="tooltip" data-placement="left" data-original-title="Day Light"></span></li>
                            <li><span class="bg-color-orange" data-widget-setstyle="jarviswidget-color-orange"
                                      rel="tooltip" data-placement="bottom" data-original-title="Orange"></span></li>
                            <li><span class="bg-color-orangeDark" data-widget-setstyle="jarviswidget-color-orangeDark"
                                      rel="tooltip" data-placement="bottom" data-original-title="Dark Orange"></span>
                            </li>
                            <li><span class="bg-color-red" data-widget-setstyle="jarviswidget-color-red" rel="tooltip"
                                      data-placement="bottom" data-original-title="Red Rose"></span></li>
                            <li><span class="bg-color-redLight" data-widget-setstyle="jarviswidget-color-redLight"
                                      rel="tooltip" data-placement="bottom" data-original-title="Light Red"></span></li>
                            <li><span class="bg-color-white" data-widget-setstyle="jarviswidget-color-white"
                                      rel="tooltip" data-placement="right" data-original-title="Purity"></span></li>
                            <li><a href="javascript:void(0);" class="jarviswidget-remove-colors" data-widget-setstyle=""
                                   rel="tooltip" data-placement="bottom"
                                   data-original-title="Reset widget color to default">Remove</a></li>
                        </ul>
                    </div>
                    <span class="widget-icon"> <i class="fa fa-edit"></i> </span>

                    <h2>信息详情</h2>
                    <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>

                <!-- widget div-->
                <div role="content">
                    <div class="widget-body">
                        <form class="smart-form edit-column" method="post">
                            <fieldset>
                                <div class="row">
                                    <section class="col col-8">
                                        <label class="label">教师工号</label>
                                        <label class="input">
                                            <i class="icon-append fa fa-lock"></i>
                                            <input type="text" value="${teacher.id}" disabled="disabled"
                                                   class="form-control">
                                        </label>
                                    </section>
                                </div>
                                <div class="row">
                                    <section class="col col-8">
                                        <label class="label">教师姓名</label>
                                        <label class="input">
                                            <i class="icon-append fa fa-user"></i>
                                            <input type="text" value="${teacher.name}" disabled="disabled"
                                                   class="form-control">
                                        </label>
                                    </section>
                                </div>
                                <div class="row">
                                    <section class="col col-8">
                                        <label class="label">所在学院</label>
                                        <label class="input">
                                            <i class="icon-append fa fa-university"></i>
                                            <input type="text" value="${teacher.academy}"
                                                   disabled="disabled" class="form-control">
                                        </label>
                                    </section>
                                </div>
                                <div class="row">
                                    <section class="col col-8">
                                        <label class="label">任教专业</label>
                                        <label class="input">
                                            <i class="icon-append fa fa-mortar-board"></i>
                                            <input type="text" value="${teacher.profession}"
                                                   disabled="disabled" class="form-control">
                                        </label>
                                    </section>
                                </div>
                                <div class="row">
                                    <section class="col col-8">
                                        <label class="label">教师职称</label>
                                        <label class="input">
                                            <i class="icon-append fa fa-leaf"></i>
                                            <input type="text" value="${teacher.rank}(${teacher.sex})"
                                                   disabled="disabled" class="form-control">
                                        </label>
                                    </section>
                                </div>
                                <div class="row">
                                    <section class="col col-8">
                                        <label class="label">联系方式</label>
                                        <label class="input">
                                            <i class="icon-append fa fa-phone"></i>
                                            <input type="text" class="column-name" id="phone" placeholder="联系方式"
                                                   value="${teacher.phone}">
                                        </label>
                                    </section>
                                </div>
                                <div class="row">
                                    <section class="col col-8"></section>
                                    <section class="col col-8"></section>
                                </div>
                                <div class="row" onclick="saveTeacherInfo();">
                                    <section class="col col-8">
                                        <button class="btn btn-success btn-lg btn-block" type="button">
                                            <i class="fa fa-save"></i>
                                            保存修改
                                        </button>
                                    </section>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                    <!-- end widget content -->
                </div>
                <!-- end widget div -->
            </div>
        </article>
        <article class="col-xs-12 col-sm-12 col-md-5 col-lg-4 sortable-grid ui-sortable">

            <div class="jarviswidget jarviswidget-color-pink jarviswidget-sortable" id="wid-id-89"
                 data-widget-editbutton="false" role="widget" style="position: relative; opacity: 1;">
                <header role="heading">
                    <div class="jarviswidget-ctrls" role="menu"> <a href="javascript:void(0);"
                                                             class="button-icon jarviswidget-fullscreen-btn"
                                                             rel="tooltip" title="" data-placement="bottom"
                                                             data-original-title="全屏"><i
                            class="fa fa-expand "></i></a> <a href="javascript:void(0);"
                                                              class="button-icon jarviswidget-delete-btn" rel="tooltip"
                                                              title="" data-placement="bottom"
                                                              data-original-title="关闭"><i
                            class="fa fa-times"></i></a></div>
                    <div class="widget-toolbar" role="menu"><a data-toggle="dropdown"
                                                               class="dropdown-toggle color-box selector"
                                                               href="javascript:void(0);"></a>
                        <ul class="dropdown-menu arrow-box-up-right color-select pull-right">
                            <li><span class="bg-color-green" data-widget-setstyle="jarviswidget-color-green"
                                      rel="tooltip" data-placement="left" data-original-title="Green Grass"></span></li>
                            <li><span class="bg-color-greenDark" data-widget-setstyle="jarviswidget-color-greenDark"
                                      rel="tooltip" data-placement="top" data-original-title="Dark Green"></span></li>
                            <li><span class="bg-color-greenLight" data-widget-setstyle="jarviswidget-color-greenLight"
                                      rel="tooltip" data-placement="top" data-original-title="Light Green"></span></li>
                            <li><span class="bg-color-purple" data-widget-setstyle="jarviswidget-color-purple"
                                      rel="tooltip" data-placement="top" data-original-title="Purple"></span></li>
                            <li><span class="bg-color-magenta" data-widget-setstyle="jarviswidget-color-magenta"
                                      rel="tooltip" data-placement="top" data-original-title="Magenta"></span></li>
                            <li><span class="bg-color-pink" data-widget-setstyle="jarviswidget-color-pink" rel="tooltip"
                                      data-placement="right" data-original-title="Pink"></span></li>
                            <li><span class="bg-color-pinkDark" data-widget-setstyle="jarviswidget-color-pinkDark"
                                      rel="tooltip" data-placement="left" data-original-title="Fade Pink"></span></li>
                            <li><span class="bg-color-blueLight" data-widget-setstyle="jarviswidget-color-blueLight"
                                      rel="tooltip" data-placement="top" data-original-title="Light Blue"></span></li>
                            <li><span class="bg-color-teal" data-widget-setstyle="jarviswidget-color-teal" rel="tooltip"
                                      data-placement="top" data-original-title="Teal"></span></li>
                            <li><span class="bg-color-blue" data-widget-setstyle="jarviswidget-color-blue" rel="tooltip"
                                      data-placement="top" data-original-title="Ocean Blue"></span></li>
                            <li><span class="bg-color-blueDark" data-widget-setstyle="jarviswidget-color-blueDark"
                                      rel="tooltip" data-placement="top" data-original-title="Night Sky"></span></li>
                            <li><span class="bg-color-darken" data-widget-setstyle="jarviswidget-color-darken"
                                      rel="tooltip" data-placement="right" data-original-title="Night"></span></li>
                            <li><span class="bg-color-yellow" data-widget-setstyle="jarviswidget-color-yellow"
                                      rel="tooltip" data-placement="left" data-original-title="Day Light"></span></li>
                            <li><span class="bg-color-orange" data-widget-setstyle="jarviswidget-color-orange"
                                      rel="tooltip" data-placement="bottom" data-original-title="Orange"></span></li>
                            <li><span class="bg-color-orangeDark" data-widget-setstyle="jarviswidget-color-orangeDark"
                                      rel="tooltip" data-placement="bottom" data-original-title="Dark Orange"></span>
                            </li>
                            <li><span class="bg-color-red" data-widget-setstyle="jarviswidget-color-red" rel="tooltip"
                                      data-placement="bottom" data-original-title="Red Rose"></span></li>
                            <li><span class="bg-color-redLight" data-widget-setstyle="jarviswidget-color-redLight"
                                      rel="tooltip" data-placement="bottom" data-original-title="Light Red"></span></li>
                            <li><span class="bg-color-white" data-widget-setstyle="jarviswidget-color-white"
                                      rel="tooltip" data-placement="right" data-original-title="Purity"></span></li>
                            <li><a href="javascript:void(0);" class="jarviswidget-remove-colors" data-widget-setstyle=""
                                   rel="tooltip" data-placement="bottom"
                                   data-original-title="Reset widget color to default">Remove</a></li>
                        </ul>
                    </div>
                    <span class="widget-icon"> <i class="fa fa-info-circle"></i> </span>

                    <h2>信息说明</h2>
                    <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span>
                </header>
                <!-- widget div-->
                    <div class="panel-body no-padding text-align-center">
                        <div class="price-features">
                            <ul class="list-unstyled text-left">
                                <li><i class="fa fa-check text-success"></i> 教师工号为唯一标识</li>
                                <li><i class="fa fa-warning text-danger"></i> 本人不可以更改工号信息</li>
                                <li><i class="fa fa-warning text-danger"></i> 本人不可以更改姓名信息</li>
                                <li><i class="fa fa-warning text-danger"></i> 本人不可以更改学院信息</li>
                                <li><i class="fa fa-warning text-danger"></i> 本人不可以更改专业信息</li>
                                <li><i class="fa fa-star text-primary"></i> 暂时只支持本人修改联系方式</li>
                                <li><i class="fa fa-star text-primary"></i> 职称将会定期更新</li>
                            </ul>
                            <div align="left" id="dabaiDiv">
                                <img id="dabaiImg" src="${ctx}/img/dabai2.png" width="237"  />
                            </div>
                        </div>
                    </div>
                    <!-- end widget content -->
            </div>
        </article>
    </div>
</section>

<script type="text/javascript">
    // DO NOT REMOVE : GLOBAL FUNCTIONS!
    pageSetUp();
    drawBreadCrumb();
    function saveTeacherInfo() {
        var phone = $("#phone").val();
        $.post("/design/teacher/updateInfo", {phone: "" + phone + ""}, function (data) {
            if (data == 'yes') {
                $.notify_success("修改个人信息成功！");
            } else {
                $.notify_danger("修改个人信息失败！");
            }
        });
    }
</script>