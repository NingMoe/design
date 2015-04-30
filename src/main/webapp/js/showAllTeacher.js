/**
 * Created by guixiaorun on 15-4-28.
 */
pageSetUp();
drawBreadCrumb();
//普通查询按钮点击事件
$("#searchTeacher").click(function () {
    searchTeacher();
});
//监听普通查询框Enter事件
$("#teacherAccount,#teacherName,#select_academy,#select_profession").keydown(function (e) {
    if (e.which == 13) {
        searchTeacher();
    }
});

function searchTeacher() {
    var teacherId = $("#teacherAccount").val();
    var teacherName = $("#teacherName").val();
    var academy = $("#select_academy").val();
    var profession = $("#select_profession").val();
    $.post("/design/manage/searchTeacher", {
        teacherId: "" + teacherId + "",
        teacherName: "" + teacherName + "",
        academy: "" + academy + "",
        profession: "" + profession + ""
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
}

function cancleAdd() {
    $("#show_add").empty();
    $("#add_dialog").hide({effect: "explode"});
}

$("#addTeacher").click(function () {
    $("#show_add").html('<div class="ui-widget-overlay ui-front"></div>');
    $("#add_dialog").show({effect: "slideDown"});
    $("#add_name").focus();
});
//增加教师
$("#add_teacher").click(function () {
    var name = $("#add_name").val();
    var academy = $("#add_academy").val();
    var profession = $("#add_profession").val();
    var rank = $("#add_rank").val();
    var phone = $("#add_phone").val();
    var sex = $("#add_sex").val();
    cancleAdd();
    $.post("/design/manage/addTeacher", {
        name: "" + name + "",
        academy: "" + academy + "",
        profession: "" + profession + "",
        rank: "" + rank + "",
        phone: "" + phone + "",
        sex: "" + sex + ""
    }, function (data) {
        if (data == 'yes') {
            $.notify_success("添加教师成功！");
            $("#add_name").val('');
            $("#add_phone").val('');
            gotoLastPage();
        } else {
            $.notify_danger("添加教师失败！");
        }
    });
});

$(function () {
    $("#add_dialog").draggable({scroll: false});
    $("#update_dialog").draggable({scroll: false});
});

function gotoLastPage() {
    var totalCount = $("#totalCount").text();
    var index = Math.ceil((totalCount + 1) / 10);
    $.post("/design/manage/searchTeacher", {
        teacherName: "",
        academy: "",
        profession: "",
        teacherId: "",
        currentPage: "" + index + "",
        perPageCount: "10"
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
}

//修改教师信息
function updateTeacher(id,name, password, rank) {
    $("#show_update").html('<div class="ui-widget-overlay ui-front"></div>');
    $("#update_name").val(name);
    $("#update_password").val(password);
    $("#update_rank").val(rank);
    $("#update_id").val(id);
    $("#update_dialog").show({effect: "slideDown"});
}
function cancleUpdate() {
    $("#show_update").empty();
    $("#update_dialog").hide({effect: "explode"});
}
$("#update_teacher").click(function () {
    var id = $("#update_id").val();
    var name = $("#update_name").val();
    var password = $("#update_password").val();
    var rank = $("#update_rank").val();
    cancleUpdate();
    $.post("/design/manage/updateTeacher", {
        id: "" + id + "",
        name: "" + name + "",
        password: "" + password + "",
        rank: "" + rank + ""
    }, function (data) {
        if (data == 'yes') {
            $.notify_success("修改教师信息成功！");
            $("#update_name").val('');
            $("#update_password").val('');
            manageByPage();
        } else {
            $.notify_danger("修改教师信息失败！");
        }
    });
});

//删除教师
function tableDelete(id) {
    $.SmartMessageBox({
        title: "<i class='fa fa-trash-o' style='color:green'></i> 删除教师",
        content: "你确定要删除当前教师吗？",
        buttons: '[取消][确认]'
    }, function (ButtonPressed) {
        if (ButtonPressed == "确认") {
            $.post("/design/manage/deleteTeacher", {id: "" + id + ""}, function (data) {
                if (data == 'yes') {
                    $.notify_success("删除教师成功！");
                    manageByPage();
                } else {
                    $.notify_danger("删除教师失败！");
                }
            });
        }
    });
}

function manageByPage() {
    var index = $('#paginate_button').find('a').text();
    $.post("/design/manage/searchTeacher", {
        teacherName: "",
        academy: "",
        profession: "",
        teacherId: "",
        currentPage: "" + index + "",
        perPageCount: "10"
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
}