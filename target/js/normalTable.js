/**
 * Created by guixiaorun on 15-4-21.
 */

//论文普通模式分页查看脚本
$("[name='_page']").click(function () {
    var index = $(this).find('a').attr('data-page');
    var title = $("#searchByTitle").val();
    var academy = $("#select_academy").val();
    var profession = $("#select_profession").val();
    var isSelected = $("#is_selected").val();
    var teacherName = $("#searchByTeacher").val();
    $.post("/design/searchByConditions", {
        currentPage: "" + index + "",
        perPageCount: "10",
        title: "" + title + "",
        academy: "" + academy + "",
        profession: "" + profession + "",
        isSelected: "" + isSelected + "",
        teacherName:""+teacherName+""
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
});

//根据条件查找论文
function searchByConditions() {
    var title = $("#searchByTitle").val();
    var academy = $("#select_academy").val();
    var profession = $("#select_profession").val();
    var isSelected = $("#is_selected").val();
    var teacherName = $("#searchByTeacher").val();
    $.post("/design/searchByConditions", {
        title: "" + title + "",
        academy: "" + academy + "",
        profession: "" + profession + "",
        isSelected: "" + isSelected + "",
        teacherName:""+teacherName+""
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
}


