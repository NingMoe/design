<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://bi.be.xiaomi.com/tags" %>
<table width="100%"
       class="table table-striped table-bordered table-hover dataTable no-footer"
       id="dt_basic" role="grid" aria-describedby="dt_basic_info" style="width: 100%; margin-top:0px;">
    <thead>
    <tr role="row" class="success">
        <th rowspan="1" colspan="1" style="width: 68px;"><i
                class="fa fa-fw fa-list-ol txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            编号
        </th>
        <th rowspan="1" colspan="1" style="width: 86px;"><i
                class="fa fa-fw fa-user txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            导师
        </th>
        <th rowspan="1" colspan="1" style="width: 145px;"><i
                class="fa fa-fw fa-university txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            学院
        </th>
        <th rowspan="1" colspan="1" style="width: 125px;"><i
                class="fa fa-fw fa-graduation-cap txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            专业
        </th>
        <th rowspan="1" colspan="1" style="width: 307px;"><i
                class="fa fa-fw fa-text-height txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            论文标题
        </th>
        <th rowspan="1" colspan="1" style="width: 255px;"><i
                class="fa fa-fw fa-pencil-square-o txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            备注
        </th>
        <th rowspan="1" colspan="1" style="width: 100px;"><i
                class="fa fa-fw fa-calendar txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            增加日期
        </th>
        <th rowspan="1" colspan="1" style="width: 60px;"><i
                class="fa fa-fw fa-check txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            选择操作
        </th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${paperItemLs==null||paperItemLs.size()==0}">
        <tr role="row" class="even">
            <td colspan="8">没有数据</td>
        </tr>
    </c:if>
    <c:forEach items="${paperItemLs}" var="paperItem" varStatus="status">
        <tr role="row" class="even">
            <td>${paperItem.id}</td>
            <td>${paperItem.teacherName}</td>
            <td>${paperItem.academy}</td>
            <td>${paperItem.profession}</td>
            <td>${paperItem.title}</td>
            <td>${paperItem.notes}</td>
            <td>${paperItem.createTime}</td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="btn btn-info btn-xs" rel="tooltip"
                                           data-placement="center" data-original-title="选择"
                                           onclick="paperSelect('${paperItem.id}','${paperItem.title}','${paperItem.teacherPhone}');"><i
                    class="fa fa-check"></i>选择</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<page:page url="#" pageIndex="pn" page="${page}"/>
<script type="text/javascript">

    function paperSelect(id, title, phone) {
        $.SmartMessageBox({
            title: "<i class='fa fa-check' style='color:green'></i> 选择论文",
            content: "你确定要选择当前论文题目吗？",
            buttons: '[取消][确认]'
        }, function (ButtonPressed) {
            if (ButtonPressed == "确认") {
                $.post("/design/student/getPaper", {
                    id: "" + id + "",
                    title: "" + title + "",
                    phone: "" + phone + ""
                }, function (data) {
                    if (data == 'yes') {
                        $.notify_success("选择论文成功！");
                        studentSelectSuccess();
                    } else {
                        $.notify_danger("您不能重复选题！");
                    }
                });
            }
        });
    }

    //学生可选论文分页查看
    $("[name='_page']").click(function () {
        var index = $(this).find('a').attr('data-page');
        var title = $("#searchByTitle").val();
        var teacherName = $("#searchByTeacher").val();
        $.post("/design/student/studentPagePaper", {
            currentPage: "" + index + "",
            perPageCount: "10",
            title: "" + title + "",
            teacherName: "" + teacherName + ""
        }, function (table) {
            $("#pageTableDiv").html(table);
        });
    });

    //学生根据条件查找论文
    function searchByConditions() {
        var title = $("#searchByTitle").val();
        var teacherName = $("#searchByTeacher").val();
        $.post("/design/student/studentPagePaper", {
            title: "" + title + "",
            teacherName: "" + teacherName + ""
        }, function (table) {
            $("#pageTableDiv").html(table);
        });
    }
    //选择成功后刷新当前页
    function studentSelectSuccess() {
        var index = $('#paginate_button').find('a').text();
        var title = $("#searchByTitle").val();
        var teacherName = $("#searchByTeacher").val();
        $.post("/design/student/studentPagePaper", {
            title: "" + title + "",
            teacherName: "" + teacherName + "",
            currentPage: "" + index + "",
            perPageCount: "10"
        }, function (table) {
            $("#pageTableDiv").html(table);
        });
    }
</script>
