<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://bi.be.xiaomi.com/tags" %>
<table width="100%"
       class="table table-striped table-bordered table-hover dataTable no-footer"
       id="dt_basic" role="grid" aria-describedby="dt_basic_info" style="width: 100%;">
    <thead>
    <tr role="row" class="success">
        <th rowspan="1" colspan="1" style="width: 68px;"><i
                class="fa fa-fw fa-list-ol txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            编号
        </th>
        <th rowspan="1" colspan="1" style="width: 125px;"><i
                class="fa fa-fw fa-university txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            学院
        </th>
        <th rowspan="1" colspan="1" style="width: 337px;"><i
                class="fa fa-fw fa-text-height txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            论文标题
        </th>
        <th rowspan="1" colspan="1" style="width: 275px;"><i
                class="fa fa-fw fa-pencil-square-o txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            备注
        </th>
        <th rowspan="1" colspan="1" style="width: 50px;"><i
                class="fa fa-fw fa-check txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            状态
        </th>
        <th rowspan="1" colspan="1" style="width: 100px;"><i
                class="fa fa-fw fa-calendar txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            增加日期
        </th>
        <th rowspan="1" colspan="1" style="width: 80px;"><i
                class="fa fa-fw fa-calendar txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            操作
        </th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${paperItemLs==null||paperItemLs.size()==0}">
        <tr role="row" class="even">
            <td colspan="7">没有数据</td>
        </tr>
    </c:if>
    <c:forEach items="${paperItemLs}" var="paperItem" varStatus="status">
        <tr role="row" class="even">
            <td>${paperItem.id}</td>
            <td>${paperItem.academy}</td>
            <td>${paperItem.title}</td>
            <td>${paperItem.notes}</td>
            <td>${paperItem.isSelected}</td>
            <td>${paperItem.createTime}</td>
            <td style="text-align: center">
                <a href="#" class="btn btn-warning btn-xs" rel="tooltip"
                   data-placement="left" data-original-title="修改"
                   onclick="tableUpdate('${paperItem.id}','${paperItem.title}','${paperItem.notes}');"><i
                        class="fa fa-pencil"></i>修改</a>
                <a href="#" class="btn btn-danger btn-xs" rel="tooltip"
                   data-placement="right" data-original-title="删除" onclick="tableDelete(${paperItem.id});"><i
                        class="fa fa-trash-o"></i>删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<page:page url="#" pageIndex="pn" page="${page}"/>
<script type="text/javascript">
    //教师论文分页查看脚本
    $("[name='_page']").click(function () {
        var index = $(this).find('a').attr('data-page');
        $.post("/design/teacher/teacherPageTable", {
            currentPage: "" + index + "",
            perPageCount: "10"
        }, function (table) {
            $("#teacher_paper").html(table);
        });
    });
    function teacherByPage() {
        var index = $('#paginate_button').find('a').text();
        $.post("/design/teacher/teacherPageTable", {
            currentPage: "" + index + "",
            perPageCount: "10"
        }, function (table) {
            $("#teacher_paper").html(table);
        });
    }
</script>