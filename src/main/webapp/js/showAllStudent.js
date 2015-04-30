/**
 * Created by guixiaorun on 15-4-28.
 */
pageSetUp();
drawBreadCrumb();
//普通查询按钮点击事件
$("#searchStudent").click(function () {
    searchStudent();
});
//监听普通查询框Enter事件
$("#studentAccount,#studentName,#select_academy,#select_profession").keydown(function (e) {
    if (e.which == 13) {
        searchStudent();
    }
});

function searchStudent() {
    var studentId = $("#studentAccount").val();
    var studentName = $("#studentName").val();
    var academy = $("#select_academy").val();
    var profession = $("#select_profession").val();
    $.post("/design/manage/searchStudent", {
        studentId: "" + studentId + "",
        studentName: "" + studentName + "",
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

$("#addStudent").click(function () {
    $("#show_add").html('<div class="ui-widget-overlay ui-front"></div>');
    $("#add_dialog").show({effect: "slideDown"});
    $("#add_name").focus();
});
//增加学生
$("#add_student").click(function () {
    var name = $("#add_name").val();
    var academy = $("#add_academy").val();
    var profession = $("#add_profession").val();
    var inClass = $("#add_class").val();
    var phone = $("#add_phone").val();
    var sex = $("#add_sex").val();
    cancleAdd();
    $.post("/design/manage/addStudent", {
        name: "" + name + "",
        academy: "" + academy + "",
        profession: "" + profession + "",
        inClass: "" + inClass + "",
        phone: "" + phone + "",
        sex: "" + sex + ""
    }, function (data) {
        if (data == 'yes') {
            $.notify_success("添加学生成功！");
            $("#add_name").val('');
            $("#add_phone").val('');
            $("#add_class").val('');
            gotoLastPage();
        } else {
            $.notify_danger("添加学生失败！");
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
    $.post("/design/manage/searchStudent", {
        studentName: "",
        academy: "",
        profession: "",
        studentId: "",
        currentPage: "" + index + "",
        perPageCount: "10"
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
}

//修改学生信息
function updateStudent(id,name, password) {
    $("#show_update").html('<div class="ui-widget-overlay ui-front"></div>');
    $("#update_name").val(name);
    $("#update_password").val(password);
    $("#update_id").val(id);
    $("#update_dialog").show({effect: "slideDown"});
}
function cancleUpdate() {
    $("#show_update").empty();
    $("#update_dialog").hide({effect: "explode"});
}
$("#update_student").click(function () {
    var id = $("#update_id").val();
    var name = $("#update_name").val();
    var password = $("#update_password").val();
    cancleUpdate();
    $.post("/design/manage/updateStudent", {
        id: "" + id + "",
        name: "" + name + "",
        password: "" + password + ""
    }, function (data) {
        if (data == 'yes') {
            $.notify_success("修改学生信息成功！");
            $("#update_name").val('');
            $("#update_password").val('');
            manageByPage();
        } else {
            $.notify_danger("修改学生信息失败！");
        }
    });
});

//删除教师
function tableDelete(id) {
    $.SmartMessageBox({
        title: "<i class='fa fa-trash-o' style='color:green'></i> 删除学生",
        content: "你确定要删除当前学生吗？",
        buttons: '[取消][确认]'
    }, function (ButtonPressed) {
        if (ButtonPressed == "确认") {
            $.post("/design/manage/deleteStudent", {id: "" + id + ""}, function (data) {
                if (data == 'yes') {
                    $.notify_success("删除学生成功！");
                    manageByPage();
                } else {
                    $.notify_danger("删除学生失败！");
                }
            });
        }
    });
}

function manageByPage() {
    var index = $('#paginate_button').find('a').text();
    $.post("/design/manage/searchStudent", {
        studentName: "",
        academy: "",
        profession: "",
        studentId: "",
        currentPage: "" + index + "",
        perPageCount: "10"
    }, function (table) {
        $("#pageTableDiv").html(table);
    });
}