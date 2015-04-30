<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://bi.be.xiaomi.com/tags" %>
<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-table fa-fw "></i>
            总览 <span>&gt;&nbsp;&nbsp;我的论文</span>
        </h1>
    </div>
</div>

<!-- widget grid -->
<section class="" id="widget-grid">

    <!-- NEW WIDGET START -->
    <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">

        <div data-widget-editbutton="false" id="wid-id-0"
             class="jarviswidget jarviswidget-color-pink jarviswidget-sortable"
             style="position: relative; opacity: 1; left: 0px; top: 0px;" role="widget">
            <header role="heading">
                <div class="jarviswidget-ctrls" role="menu"><a data-placement="bottom" title="" rel="tooltip"
                                                               class="button-icon jarviswidget-toggle-btn"
                                                               href="javascript:void(0);"
                                                               data-original-title="Collapse"><i
                        class="fa fa-minus "></i></a> <a data-placement="bottom" title="" rel="tooltip"
                                                         class="button-icon jarviswidget-fullscreen-btn"
                                                         href="javascript:void(0);"
                                                         data-original-title="Fullscreen"><i
                        class="fa fa-expand "></i></a> <a data-placement="bottom" title="" rel="tooltip"
                                                          class="button-icon jarviswidget-delete-btn"
                                                          href="javascript:void(0);"
                                                          data-original-title="Delete"><i
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

            <!-- widget div-->
            <div role="content">

                <!-- widget content -->
                <div class="widget-body no-padding">
                    <%--<div class="alert adjusted alert-warning fade in">--%>
                        <%--<button data-dismiss="alert" class="close">--%>
                            <%--×--%>
                        <%--</button>--%>
                        <%--<i class="fa-fw fa-lg fa fa-warning"></i>--%>
                        <%--<strong>论文编号为随机生成且唯一，请及时删除废弃的论文题目！</strong>--%>
                    <%--</div>--%>
                    <div id="dt_basic_wrapper" class="dataTables_wrapper form-inline no-footer">
                        <div class="dt-toolbar">
                            <p>
                                <a href="javascript:void(0);" class="btn btn-primary" id="add_tab"><i
                                        class="fa fa-plus"></i> 发布论文</a>
                            </p>
                        </div>
                        <div id="teacher_paper">
                            <jsp:include page="teacherPageTable.jsp"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </article>
    <!-- WIDGET END -->
</section>
<!-- end widget grid -->
<script src="${ctx}/js/teacherPaper.js"></script>
</div>
<div id="show_add">
</div>
<div class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons ui-draggable "
     style="height: auto; width: 600px; top: 189px; left: 438px; display: none;" tabindex="-1" role="dialog"
     aria-describedby="addtab" aria-labelledby="ui-id-1" id="add_dialog">
    <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix"><span id="ui-id-1"
                                                                                            class="ui-dialog-title"><div
            class="widget-header"><h4><i class="fa fa-plus"></i> 发布论文 </h4></div></span>
        <button class="ui-dialog-titlebar-close" onclick="cancleAdd();"></button>
    </div>
    <div id="addtab" class="ui-dialog-content ui-widget-content"
         style="width: auto; min-height: 0px; max-height: none; height: auto;">

        <form>

            <fieldset>

                <div class="form-group">
                    <label>论文标题</label>
                    <input type="text" placeholder="请输入论文标题..." id="paper_title" class="form-control">
                </div>

                <div class="form-group">
                    <label>论文备注</label>
                    <textarea rows="3" placeholder="请输入论文备注..." id="paper_notes" class="form-control"></textarea>
                </div>

            </fieldset>

        </form>

    </div>
    <div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
        <div class="ui-dialog-buttonset">
            <button onclick="cancleAdd();" type="button" class="btn btn-info"><i class="fa fa-times"></i>&nbsp; 取消
            </button>
            <button id="add_paper" type="button" class="btn btn-danger"><i class="fa fa-check"></i>&nbsp; 提交</button>
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
            class="widget-header"><h4><i class="fa fa-pencil"></i> 修改论文 </h4></div></span>
        <button class="ui-dialog-titlebar-close" onclick="cancleUpdate();"></button>
    </div>
    <div id="updatetab" class="ui-dialog-content ui-widget-content"
         style="width: auto; min-height: 0px; max-height: none; height: auto;">

        <form>

            <fieldset>

                <div class="form-group">
                    <label>论文标题</label>
                    <input type="text" placeholder="请输入论文标题..." id="new_paper_title" class="form-control">
                </div>

                <div class="form-group">
                    <label>论文备注</label>
                    <textarea rows="3" placeholder="请输入论文备注..." id="new_paper_notes" class="form-control"></textarea>
                </div>

            </fieldset>

        </form>

    </div>
    <div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
        <div class="ui-dialog-buttonset">
            <button onclick="cancleUpdate();" type="button" class="btn btn-info"><i class="fa fa-times"></i>&nbsp; 取消
            </button>
            <button id="update_paper" type="button" class="btn btn-warning"><i class="fa fa-check"></i>&nbsp; 提交</button>
        </div>
    </div>
    <input type="hidden" id="paper_id" />
</div>
</body>