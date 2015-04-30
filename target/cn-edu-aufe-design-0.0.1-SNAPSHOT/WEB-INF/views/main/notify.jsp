<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
        <h1 class="page-title txt-color-blueDark">
            <i class="fa fa-home fa-fw "></i>
            通知 <span>&gt;&nbsp;&nbsp;修改</span>
        </h1>
    </div>
</div>

<div class="col-sm-12">

    <div class="well" style="opacity: 2;">

        <h3><i>安徽财经大学毕业论文选题系统</i></h3>

        <div class="jumbotron" id="jumbotron">
            <h1>毕业论文选题需知！</h1>

            <div class="alert alert-success alert-block">
                <a href="#" data-dismiss="alert" class="close">×</a>
                <h4 class="alert-heading">通知：</h4>

                <div class="col-lg-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-bullhorn"></i></span>
                        <input type="text" id="notify" value="${notify.notify}"
                               class="form-control">
                    </div>
                </div>
                <br><br>
            </div>
            <div class="alert alert-danger alert-block">
                <a href="#" data-dismiss="alert" class="close">×</a>
                <h4 class="alert-heading">注意：</h4>

                <div class="col-lg-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-exclamation-triangle"></i></span>
                        <input type="text" id="warning" value="${notify.warning}"
                               class="form-control">
                    </div>
                </div>
                <br><br>
            </div>
            <p>
                <a href="#" id="notify_update" role="button" class="btn btn-primary btn-lg">保存修改</a>
            </p>
        </div>

    </div>
</div>

<script type="text/javascript">
    $(function(){
        $("#notify").focus();
    });
    //保存修改
    $("#notify_update").click(function () {
        var notify = $("#notify").val();
        var warning = $("#warning").val();
        $.post("/design/notify/add", {notify: "" + notify + "", warning: "" + warning + ""}, function (data) {
            if (data == 'yes') {
                $.notify_success("修改通知成功！");
            } else {
                $.notify_danger("修改失败，通知不能为空！")
            }
        });
    });

</script>
