/**
 * Created by guixiaorun on 15-4-15.
 */
pageSetUp();
drawBreadCrumb();

function cancleAdd() {
    $("#show_add").empty();
    $("#add_dialog").hide({effect:"explode"});
}

$("#add_tab").click(function () {
    $("#show_add").html('<div class="ui-widget-overlay ui-front"></div>');
    $("#add_dialog").show({effect:"slideDown"});
    $("#paper_title").focus();
});

$("#add_paper").click(function () {
    var title = $("#paper_title").val();
    var notes = $("#paper_notes").val();
    cancleAdd();
    $.post("/design/teacher/addPaper", {title: "" + title + "", notes: "" + notes + ""}, function (data) {
        if (data == 'yes') {
            $.notify_success("发布论文题目成功！");
            $("#paper_title").val('');
            $("#paper_notes").val('');
            gotoLastPage();
        } else {
            $.notify_danger("论文题目不能为空！");
        }
    });
});

$(function(){
    $("#add_dialog").draggable({scroll: false});
    $("#update_dialog").draggable({scroll: false});
});

function gotoLastPage(){
    var totalCount = $("#totalCount").text() ;
    var index = Math.ceil((totalCount+1)/10) ;
    $.post("/design/teacher/teacherPageTable", {
        currentPage: "" + index + "",
        perPageCount: "10"
    }, function (table) {
        $("#teacher_paper").html(table);
    });
}
//教师删除论文
function tableDelete(id) {
    $.SmartMessageBox({
        title : "<i class='fa fa-trash-o' style='color:green'></i> 删除论文",
        content : "你确定要删除当前论文题目吗？",
        buttons : '[取消][确认]'
    }, function(ButtonPressed) {
        if (ButtonPressed == "确认") {
            $.post("/design/teacher/paperDelete", {id: "" + id + ""}, function (data) {
                if (data == 'yes') {
                    $.notify_success("删除论文成功！");
                    teacherByPage();
                } else {
                    $.notify_danger("删除论文失败！");
                }
            });
        }
    });
}
//教师修改论文
function tableUpdate(id,title,notes){
    $("#show_update").html('<div class="ui-widget-overlay ui-front"></div>');
    $("#new_paper_title").val(title);
    $("#new_paper_notes").val(notes);
    $("#paper_id").val(id);
    $("#update_dialog").show({effect:"slideDown"});
}
function cancleUpdate() {
    $("#show_update").empty();
    $("#update_dialog").hide({effect:"explode"});
}
$("#update_paper").click(function(){
    var id = $("#paper_id").val();
    var title = $("#new_paper_title").val();
    var notes = $("#new_paper_notes").val();
    cancleUpdate();
    $.post("/design/teacher/updatePaper", {id:""+id+"",title: "" + title + "", notes: "" + notes + ""}, function (data) {
        if (data == 'yes') {
            $.notify_success("修改论文题目成功！");
            $("#new_paper_title").val('');
            $("#new_paper_notes").val('');
            teacherByPage();
        } else {
            $.notify_danger("论文题目不能为空！");
        }
    });
});
