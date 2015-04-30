package cn.edu.aufe.guixiaorun.controller;

import cn.edu.aufe.guixiaorun.service.AccountService;
import cn.edu.aufe.guixiaorun.service.LoginService;
import cn.edu.aufe.guixiaorun.service.TeacherService;
import cn.edu.aufe.guixiaorun.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by guixiaorun on 15-4-7.
 */
@Controller
public class LoginController {
    //登录页的主页
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "login/login";
    }

    //登录前验证
    @RequestMapping(value = "/login/check")
    public void loginCheck(HttpServletRequest req,HttpServletResponse res)throws Exception {
        int account = 0 ;
        String password = "" ;
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter() ;
        try {
            account = StringUtil.toInt(req.getParameter("account"));
            password = req.getParameter("password");
        }catch(Exception e){
            res.sendRedirect("/login");
            return ;
        }
        boolean flag = accountService.checkUser(account,password) ;
        if(flag){
            HttpSession session = req.getSession() ;
            session.setMaxInactiveInterval(-1);  //当前会话超时时间设置为永不超时
            String key = "key";
            String person = "" ;
            if (account==321){
               person = "admin";
            }
            else if (account>99999999) {
                person = "teacher";

            }else{
                person = "student" ;
            }
            session.setAttribute("account",account);
            session.setAttribute("password",password);
            session.setAttribute("key",key);
            session.setAttribute("person",person) ;
            out.write("yes");
            out.flush();
            out.close();
        }else{
            out.write("no");
            out.flush();
            out.close();
        }
    }

    @Resource
    private AccountService accountService;
}
