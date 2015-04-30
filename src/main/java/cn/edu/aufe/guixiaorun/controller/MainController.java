package cn.edu.aufe.guixiaorun.controller;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeNotifyEntity;
import cn.edu.aufe.guixiaorun.entity.PaperItemEntity;
import cn.edu.aufe.guixiaorun.service.AccountService;
import cn.edu.aufe.guixiaorun.service.NotifyService;
import cn.edu.aufe.guixiaorun.service.PaperItemService;
import cn.edu.aufe.guixiaorun.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    //主页
    @RequestMapping(value = "/design/index")
    public String index(HttpServletRequest req) {
        HttpSession session = req.getSession();
        int account = StringUtil.toInt(session.getAttribute("account"));
        String userName = accountService.getUserName(account);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String now = df.format(new Date());// new Date()为获取当前系统时间
        req.setAttribute("user", userName);
        req.setAttribute("now", now);
        AufeNotifyEntity notify = notifyService.findLastNotify();
        req.setAttribute("notify",notify);
        return "main/index";
    }

    //浏览所有论文页
    @RequestMapping(value = "/design/normalTable")
    public String normalTable(HttpServletRequest req) {

        int currentPage = StringUtil.toInt(req.getParameter("currentPage"));
        int perPageCount = StringUtil.toInt(req.getParameter("perPageCount"));
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setPerPageCount(perPageCount);
        long count = paperItemService.countAll();
        page.setTotalCount(count);
        List<PaperItemEntity> paperItemEntityList = paperItemService.findPaperItemByPage(page);
        if (paperItemEntityList != null) {
            page.setEndNum(StringUtil.toLong(paperItemEntityList.size()));
        } else {
            page.setEndNum(0L);
        }
        req.setAttribute("paperItemLs", paperItemEntityList);
        req.setAttribute("page", page);
        return "table/normalTable";
    }

    //普通查询（多条件查询）
    @RequestMapping(value = "/design/searchByConditions")
    public String searchByConditions(HttpServletRequest req) {
        String teacherName = "";
        String title = "";
        String academy = "";
        String profession = "";
        String isSelected = "";
        int currentPage = 0;
        int perPageCount = 0;
        try {
            teacherName = "%" + req.getParameter("teacherName") + "%";
            title = "%" + req.getParameter("title") + "%";
            academy = "%" + req.getParameter("academy") + "%";
            profession = "%" + req.getParameter("profession") + "%";
            isSelected = "%" + req.getParameter("isSelected") + "%";
            currentPage = StringUtil.toInt(req.getParameter("currentPage"));
            perPageCount = StringUtil.toInt(req.getParameter("perPageCount"));
        } catch (Exception e) {
        }
        //接下来根据title做查询
        Page page = new Page();
        page.setCurrentPage(currentPage);
        if (perPageCount == 0) {
            page.setPerPageCount(10);
        } else {
            page.setPerPageCount(perPageCount);
        }
        long count = paperItemService.countByConditions(teacherName, title, academy, profession, isSelected);
        page.setTotalCount(count);
        List<PaperItemEntity> paperItemEntityList = paperItemService.findPaperItemByPageConditions(teacherName, title, academy, profession, isSelected, page);
        if (paperItemEntityList != null && paperItemEntityList.size() > 0) {
            page.setEndNum(StringUtil.toLong(paperItemEntityList.size()));
        } else {
            page.setEndNum(0L);
        }
        req.setAttribute("paperItemLs", paperItemEntityList);
        req.setAttribute("page", page);
        return "table/pageTable";
    }

    @Resource
    private PaperItemService paperItemService;
    @Resource
    private AccountService accountService;
    @Resource
    private NotifyService notifyService;

}
