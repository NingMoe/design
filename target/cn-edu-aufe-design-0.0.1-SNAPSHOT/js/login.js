/**
 * Created by guixiaorun on 15-4-7.
 */

function loginCheck() {
    var account = $("#account").val() ;
    var password = $("#password").val() ;
    if (account == '' || password == '') {
        //输出：学号密码不能为空
        $(".note").html("<font color='red'><b>*学号(工号)密码不能为空!</b></font>") ;
    } else {
        $.post('/login/check?account=' + account + '&password=' + password+ ' ',function(data) {
            if (data == 'yes') {
                $("#loginAccount").val(account) ;
                $("#loginPassword").val(password) ;
                document.loginForm.submit();
            } else if (data == 'no') {
                //输出：学号或者密码有误
                $(".note").html("<font color='red'><b>*学号(工号)或者密码有误!</b></font>") ;
            }
        });
    }
}

//监听login表单Enter事件
$("#account").keydown(function (e) {
    if (e.which == 13) {
        loginCheck();
    }
});
$("#password").keydown(function (e) {
    if (e.which == 13) {
        loginCheck();
    }
});
