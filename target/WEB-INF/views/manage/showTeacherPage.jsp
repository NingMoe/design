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
            工号
        </th>
        <th rowspan="1" colspan="1" style="width: 96px;"><i
                class="fa fa-fw fa-user txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            姓名
        </th>
        <th rowspan="1" colspan="1" style="width: 68px;"><i
                class="fa fa-fw fa-key txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            密码
        </th>
        <th rowspan="1" colspan="1" style="width: 135px;"><i
                class="fa fa-fw fa-university txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            学院
        </th>
        <th rowspan="1" colspan="1" style="width: 125px;"><i
                class="fa fa-fw fa-graduation-cap txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            专业
        </th>
        <th rowspan="1" colspan="1" style="width: 75px;"><i
                class="fa fa-fw fa-leaf txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            职称
        </th>
        <th rowspan="1" colspan="1" style="width: 100px;"><i
                class="fa fa-fw fa-phone txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            联系方式
        </th>
        <th rowspan="1" colspan="1" style="width: 30px;"><i
                class="fa fa-fw fa-group txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            性别
        </th>
        <th rowspan="1" colspan="1" style="width: 80px;"><i
                class="fa fa-fw fa-check txt-color-blue hidden-md hidden-sm hidden-xs"></i>
            操作
        </th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${teacherLs==null||teacherLs.size()==0}">
        <tr role="row" class="even">
            <td colspan="9">没有数据</td>
        </tr>
    </c:if>
    <c:forEach items="${teacherLs}" var="teacher" varStatus="status">
        <tr role="row" class="even">
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.password}</td>
            <td>${teacher.academy}</td>
            <td>${teacher.profession}</td>
            <td>${teacher.rank}</td>
            <td>${teacher.phone}</td>
            <td>${teacher.sex}</td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="btn btn-warning btn-xs" rel="tooltip"
                                           data-placement="center" data-original-title="修改"
                                           onclick="updateTeacher('${teacher.id}','${teacher.name}','${teacher.password}','${teacher.rank}');"
                    ><i
                    class="fa fa-pencil"></i>修改</a>&nbsp;&nbsp;<a href="#" class="btn btn-danger btn-xs" rel="tooltip"
                                                                  data-placement="center" data-original-title="删除"
                                                                  onclick="tableDelete(${teacher.id});"
                    ><i
                    class="fa fa-times"></i>删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<page:page url="#" pageIndex="pn" page="${page}"/>
<script src="${ctx}/js/showPageTeacher.js"/>
