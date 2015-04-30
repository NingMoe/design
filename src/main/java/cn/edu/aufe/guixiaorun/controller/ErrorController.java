package cn.edu.aufe.guixiaorun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guixiaorun on 15-4-7.
 */
@Controller
public class ErrorController {
    //错误页
    @RequestMapping(value = "/error")
    public String login() {
        return "error/error404";
    }
}
