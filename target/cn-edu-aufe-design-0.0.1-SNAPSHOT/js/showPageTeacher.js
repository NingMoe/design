/**
 * Created by guixiaorun on 15-4-27.
 */
//管理员分页查看教师
$("[name='_page']").click(function () {
    var index = $(this).find('a').attr('data-page');
    var studentId = $("#studentAccount").val();
    var studentName = $("#studentName").val();
    var academy = $("#select_academy").val();
    var profession = $("#select_profession").val();
    $.post("/design/manage/searchStudent", {
        currentPage: "" + index + "",
        perPageCount: "10",
        teacherId: "" + teacherId + "",
        teacherName: "" + teacherName + "",
        academy: "" + academy + "",
        profession: "" + profession + ""
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
});

