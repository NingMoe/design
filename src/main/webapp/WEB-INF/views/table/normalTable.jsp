<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://bi.be.xiaomi.com/tags" %>
<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-table fa-fw "></i>
            总览 <span>&gt;&nbsp;&nbsp;毕业论文</span>
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

                    <h2>论文列表</h2>

                    <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
                <div role="content">
                    <div class="well" >
                        <form>
                            <div class="row">

                                <div class="col-lg-2">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input type="text" id="searchByTeacher" placeholder="导师姓名(模糊查询)" class="form-control">
                                    </div>
                                </div>

                                <div class="col-lg-2">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-text-height"></i></span>
                                        <input type="text" id="searchByTitle" placeholder="论文标题(模糊查询)" class="form-control">
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

                                <div class="col-lg-2 smart-form">
                                    <label class="select">
                                        <select id="is_selected">
                                            <option value="">论文选题状态</option>
                                            <option>未选中</option>
                                            <option>已选中</option>
                                        </select><i></i>
                                    </label>
                                </div>

                                <div class="col-lg-1">
                                    <div class="input-group-btn">
                                        <button id="normalSearch" class="btn btn-primary" type="button"><i class="fa fa-paw"></i> 立即搜索
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="pageTableDiv" class="widget-body no-padding">
                        <!-- Table -->
                        <jsp:include page="pageTable.jsp"/>
                    </div>
                </div>
            </div>
        </article>
    </div>
    <!-- WIDGET END -->
</section>
<!-- end widget grid -->
<script type="text/javascript">
    // DO NOT REMOVE : GLOBAL FUNCTIONS!
    pageSetUp();
    drawBreadCrumb();
    //普通查询按钮点击事件
    $("#normalSearch").click(function () {
        searchByConditions();
    });
    //监听普通查询框Enter事件
    $("#searchByTeacher,#searchByTitle,#select_academy,#select_profession,#is_selected").keydown(function (e) {
        if (e.which == 13) {
            searchByConditions();
        }
    });

</script>
</div>
