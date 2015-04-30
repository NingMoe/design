<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://bi.be.xiaomi.com/tags" %>
<table width="100%"
       class="table table-striped table-bordered table-hover dataTable no-footer"
       id="dt_basic" role="grid" aria-describedby="dt_basic_info" style="width: 100%; margin-top:0px;">
    <thead>
    <tr role="row" class="success" >
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
        <th rowspan="1" colspan="1" style="width: 60px;"><i
                class="fa fa-fw fa-check txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            状态
        </th>
        <th rowspan="1" colspan="1" style="width: 100px;"><i
                class="fa fa-fw fa-calendar txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            增加日期
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
            <td>${paperItem.isSelected}</td>
            <td>${paperItem.createTime}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<page:page url="#" pageIndex="pn" page="${page}"/>
<script src="${ctx}/js/normalTable.js" />
