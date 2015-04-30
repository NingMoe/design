<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://bi.be.xiaomi.com/tags" %>
<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-table fa-fw "></i>
            管理 <span>&gt;&nbsp;&nbsp;所有教师</span>
        </h1>
    </div>
</div>

<!-- widget grid -->
<section id="widget-grid">

    <!-- NEW WIDGET START -->
    <div id="search_data_table" class="row">
        <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">

            <div class="jarviswidget jarviswidget-color-pink jarviswidget-sortable" id="wid-id-0"
                 data-widget-deletebutton="false" data-widget-editbutton="false" role="widget" style="">
                <header role="heading">
                    <div class="jarviswidget-ctrls" role="menu"><a data-placement="bottom" title="" rel="tooltip"
                                                                   class="button-icon jarviswidget-toggle-btn"
                                                                   href="javascript:void(0);"
                                                                   data-original-title="收起"><i
                            class="fa fa-minus "></i></a> <a data-placement="bottom" title="" rel="tooltip"
                                                             class="button-icon jarviswidget-fullscreen-btn"
                                                             href="javascript:void(0);"
                                                             data-original-title="全屏"><i
                            class="fa fa-expand "></i></a> <a data-placement="bottom" title="" rel="tooltip"
                                                              class="button-icon jarviswidget-delete-btn"
                                                              href="javascript:void(0);"
                                                              data-original-title="关闭"><i
                            class="fa fa-times"></i></a></div>
                    <div class="widget-toolbar" role="menu"><a href="javascript:void(0);"
                                                               class="dropdown-toggle color-box selector"
                                                               data-toggle="dropdown"></a>
                        <ul class="dropdown-menu arrow-box-up-right color-select pull-right">
                            <li><span data-original-title="Green Grass" data-placement="left" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-green" class="bg-color-green"></span>
                            </li>
                            <li><span data-original-title="Dark Green" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-greenDark"
                                      class="bg-color-greenDark"></span></li>
                            <li><span data-original-title="Light Green" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-greenLight"
                                      class="bg-color-greenLight"></span></li>
                            <li><span data-original-title="Purple" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-purple"
                                      class="bg-color-purple"></span></li>
                            <li><span data-original-title="Magenta" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-magenta"
                                      class="bg-color-magenta"></span></li>
                            <li><span data-original-title="Pink" data-placement="right" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-pink" class="bg-color-pink"></span>
                            </li>
                            <li><span data-original-title="Fade Pink" data-placement="left" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-pinkDark"
                                      class="bg-color-pinkDark"></span></li>
                            <li><span data-original-title="Light Blue" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-blueLight"
                                      class="bg-color-blueLight"></span></li>
                            <li><span data-original-title="Teal" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-teal" class="bg-color-teal"></span>
                            </li>
                            <li><span data-original-title="Ocean Blue" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-blue" class="bg-color-blue"></span>
                            </li>
                            <li><span data-original-title="Night Sky" data-placement="top" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-blueDark"
                                      class="bg-color-blueDark"></span></li>
                            <li><span data-original-title="Night" data-placement="right" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-darken"
                                      class="bg-color-darken"></span></li>
                            <li><span data-original-title="Day Light" data-placement="left" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-yellow"
                                      class="bg-color-yellow"></span></li>
                            <li><span data-original-title="Orange" data-placement="bottom" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-orange"
                                      class="bg-color-orange"></span></li>
                            <li><span data-original-title="Dark Orange" data-placement="bottom" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-orangeDark"
                                      class="bg-color-orangeDark"></span></li>
                            <li><span data-original-title="Red Rose" data-placement="bottom" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-red" class="bg-color-red"></span>
                            </li>
                            <li><span data-original-title="Light Red" data-placement="bottom" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-redLight"
                                      class="bg-color-redLight"></span></li>
                            <li><span data-original-title="Purity" data-placement="right" rel="tooltip"
                                      data-widget-setstyle="jarviswidget-color-white" class="bg-color-white"></span>
                            </li>
                            <li><a data-original-title="Reset widget color to default" data-placement="bottom"
                                   rel="tooltip" data-widget-setstyle="" class="jarviswidget-remove-colors"
                                   href="javascript:void(0);">Remove</a></li>
                        </ul>
                    </div>
                    <span class="widget-icon"> <i class="fa fa-table"></i> </span>

                    <h2>教师列表</h2>

                    <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
                <div role="content">
                    <div class="well">
                        <form>
                            <div class="row">

                                <div class="col-lg-2">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input type="text" id="teacherAccount" placeholder="教师工号(模糊查询)"
                                               class="form-control">
                                    </div>
                                </div>

                                <div class="col-lg-2">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input type="text" id="teacherName" placeholder="教师姓名(模糊查询)"
                                               class="form-control">
                                    </div>
                                </div>

                                <div class="col-lg-2 smart-form">
                                    <label class="select">
                                        <select id="select_academy">
                                            <option value="">选择学院</option>
                                            <option>管理科学与工程学院</option>
                                            <option>会计学院学院</option>
                                            <option>文化艺术与传媒学院</option>
                                            <option>金融学院</option>
                                        </select><i></i>
                                    </label>
                                </div>

                                <div class="col-lg-2 smart-form">
                                    <label class="select">
                                        <select id="select_profession">
                                            <option value="">选择专业</option>
                                            <option>计算机科学与技术</option>
                                            <option>情报学</option>
                                            <option>管理科学</option>
                                            <option>工程</option>
                                        </select><i></i>
                                    </label>
                                </div>

                                <div class="col-lg-1">
                                    <div class="input-group-btn">
                                        <button id="searchTeacher" class="btn btn-primary" type="button"><i
                                                class="fa fa-paw"></i> 立即搜索
                                        </button>
                                    </div>
                                </div>

                                <div class="col-lg-1">
                                    <div class="input-group-btn">
                                        <button id="addTeacher" class="btn btn-primary" type="button"><i
                                                class="fa fa-plus"></i> 添加教师
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                    <div id="pageTableDiv" class="widget-body no-padding">
                        <!-- Table -->
                        <jsp:include page="showTeacherPage.jsp"/>
                    </div>
                </div>
            </div>
        </article>
    </div>
    <!-- WIDGET END -->
</section>
<!-- end widget grid -->
</div>
<div id="show_add">
</div>
<div class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons ui-draggable "
     style="height: auto; width: 600px; top: 189px; left: 438px; display: none;" tabindex="-1" role="dialog"
     aria-describedby="addtab" aria-labelledby="ui-id-1" id="add_dialog">
    <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix"><span id="ui-id-1"
                                                                                            class="ui-dialog-title"><div
            class="widget-header"><h4><i class="fa fa-plus"></i> 添加教师 </h4></div></span>
        <button class="ui-dialog-titlebar-close" onclick="cancleAdd();"></button>
    </div>
    <div id="addtab" class="ui-dialog-content ui-widget-content"
         style="width: auto; min-height: 0px; max-height: none; height: auto;">

        <form>

            <fieldset>

                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" placeholder="请输入教师姓名..." id="add_name" class="form-control">
                </div>

                <div class="form-group">
                    <label>联系方式</label>
                    <input type="text" placeholder="请输入教师电话号码..." id="add_phone" class="form-control">
                </div>

                <div class="row">
                    <div class="col-lg-6 smart-form">
                        <label class="select">
                            <select id="add_academy">
                                <option>管理科学与工程学院</option>
                                <option>会计学院</option>
                                <option>文化艺术与传媒学院</option>
                                <option>金融学院</option>
                            </select><i></i>
                        </label>
                    </div>

                    <div class="col-lg-6 smart-form">
                        <label class="select">
                            <select id="add_profession">
                                <option>计算机科学与技术</option>
                                <option>情报学</option>
                                <option>管理科学</option>
                                <option>工程</option>
                            </select><i></i>
                        </label>
                    </div>
                </div><br>

                <div class="row">
                    <div class="col-lg-6 smart-form">
                        <label class="select">
                            <select id="add_rank">
                                <option>教授</option>
                                <option>副教授</option>
                                <option>讲师</option>
                            </select><i></i>
                        </label>
                    </div>

                    <div class="col-lg-6 smart-form">
                        <label class="select">
                            <select id="add_sex">
                                <option>男</option>
                                <option>女</option>
                            </select><i></i>
                        </label>
                    </div>
                </div>

            </fieldset>

        </form>

    </div>
    <div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
        <div class="ui-dialog-buttonset">
            <button onclick="cancleAdd();" type="button" class="btn btn-info"><i class="fa fa-times"></i>&nbsp; 取消
            </button>
            <button id="add_teacher" type="button" class="btn btn-danger"><i class="fa fa-check"></i>&nbsp; 确认</button>
        </div>
    </div>
</div>
<div id="show_update">
</div>
<div class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons ui-draggable "
     style="height: auto; width: 600px; top: 189px; left: 438px; display: none;" tabindex="-1" role="dialog"
     aria-describedby="addtab" aria-labelledby="ui-id-1" id="update_dialog">
    <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix"><span id="ui-id-2"
                                                                                            class="ui-dialog-title"><div
            class="widget-header"><h4><i class="fa fa-pencil"></i> 修改教师 </h4></div></span>
        <button class="ui-dialog-titlebar-close" onclick="cancleUpdate();"></button>
    </div>
    <div id="updatetab" class="ui-dialog-content ui-widget-content"
         style="width: auto; min-height: 0px; max-height: none; height: auto;">

        <form>

            <fieldset>

                <div class="form-group">
                    <label>教师姓名</label>
                    <input type="text" placeholder="请输入教师姓名..." id="update_name" class="form-control">
                </div>

                <div class="form-group">
                    <label>教师密码</label>
                    <input type="text" placeholder="请输入教师密码..." id="update_password" class="form-control">
                </div>

                <div class="row">
                    <div class="col-lg-4 smart-form">
                        <font style="color: #373737">教师职称</font>
                        <label class="select">
                            <select id="update_rank">
                                <option>教授</option>
                                <option>副教授</option>
                                <option>讲师</option>
                            </select><i></i>
                        </label>
                    </div>
                </div>

            </fieldset>

        </form>

    </div>
    <div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
        <div class="ui-dialog-buttonset">
            <button onclick="cancleUpdate();" type="button" class="btn btn-info"><i class="fa fa-times"></i>&nbsp; 取消
            </button>
            <button id="update_teacher" type="button" class="btn btn-warning"><i class="fa fa-check"></i>&nbsp; 提交
            </button>
        </div>
    </div>
    <input type="hidden" id="update_id"/>
</div>
<script src="${ctx}/js/showAllTeacher.js"/>
