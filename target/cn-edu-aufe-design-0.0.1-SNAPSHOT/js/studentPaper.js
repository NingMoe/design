/**
 * Created by guixiaorun on 15-4-24.
 */

pageSetUp();
drawBreadCrumb();

//普通查询按钮点击事件
$("#studentSearch").click(function () {
    studentSearch();
});
//监听普通查询框Enter事件
$("#searchByTeacher,#searchByTitle").keydown(function (e) {
    if (e.which == 13) {
        studentSearch();
    }
});

function studentSearch() {
    var title = $("#searchByTitle").val();
    var teacherName = $("#searchByTeacher").val();
    $.post("/design/student/studentPagePaper", {
        title: "" + title + "",
        teacherName:""+teacherName+""
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
}
