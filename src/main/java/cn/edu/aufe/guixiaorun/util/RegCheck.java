package cn.edu.aufe.guixiaorun.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by guixiaorun on 15-4-7.
 */
public class RegCheck {

    // 帐号正则验证
    public static boolean checkUser(int account) {
        String reg = "^\\d{8}|\\d{10}$";
        return (account+"").matches(reg);
    }

    // 密码正则验证
    public static boolean checkPassword(String psw) {
        String reg = "^\\d{6}$";
        return psw.matches(reg);
    }

    //电话号码正则校验
    public static boolean checkPhone(String phone){
        String reg = "^\\d{11}$";
        return phone.matches(reg);
    }

    //姓名正则校验
    public static boolean checkName(String name){
        //暂时规定为2到10个中文
        return name.matches("[\u4e00-\u9fa5]{2,10}") ;
    }

}
