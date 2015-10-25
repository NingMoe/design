package cn.edu.aufe.guixiaorun.controller;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeTeacherEntity;
import cn.edu.aufe.guixiaorun.entity.PaperItemEntity;
import cn.edu.aufe.guixiaorun.service.PaperItemService;
import cn.edu.aufe.guixiaorun.service.TeacherService;
import cn.edu.aufe.guixiaorun.util.RegCheck;
import cn.edu.aufe.guixiaorun.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by guixiaorun on 15-4-7.
 */
@Controller
@Transactional
public class TeacherController {

    //查看当前教师的所有已发布论文
    @RequestMapping(value = "/design/teacher/postPaper")
    public String postPaper(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("teacher".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            Page page = new Page();
            page.setCurrentPage(1);
            page.setPerPageCount(10);
            long count = paperItemService.countByAccount(account);
            page.setTotalCount(count);
            List<PaperItemEntity> paperItemEntityList = paperItemService.findPaperByPageAccount(page, account);
            if (paperItemEntityList != null && paperItemEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(paperItemEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("paperItemLs", paperItemEntityList);
            req.setAttribute("page", page);
            return "teacher/teacherTable";
        }
        return "error/error404";
    }

    //教师论文分页查询
    @RequestMapping(value = "/design/teacher/teacherPageTable")
    public String teacherPageTable(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("teacher".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            int currentPage = 0;
            int perPageCount = 0;
            try {
                currentPage = StringUtil.toInt(req.getParameter("currentPage"));
                perPageCount = StringUtil.toInt(req.getParameter("perPageCount"));
            } catch (Exception e) {
            }
            Page page = new Page();
            page.setCurrentPage(currentPage);
            if (perPageCount == 0) {
                page.setPerPageCount(10);
            } else {
                page.setPerPageCount(perPageCount);
            }
            long count = paperItemService.countByAccount(account);
            page.setTotalCount(count);
            List<PaperItemEntity> paperItemEntityList = paperItemService.findPaperByPageAccount(page, account);
            if (paperItemEntityList != null && paperItemEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(paperItemEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("paperItemLs", paperItemEntityList);
            req.setAttribute("page", page);
            return "teacher/teacherPageTable";
        }
        return "error/error404";
    }

    //教师个人信息
    @RequestMapping(value = "/design/teacher/info")
    public String teacherInfo(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("teacher".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            AufeTeacherEntity teacher = teacherService.getInfoByAccount(account);
            req.setAttribute("teacher", teacher);
            return "teacher/info";
        }
        return "error/error404";
    }

    //修改个人信息，暂时只支持修改联系方式
    @Transactional
    @RequestMapping(value = "/design/teacher/updateInfo")
    public void updateInfo(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("teacher".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            String phone = req.getParameter("phone");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (!RegCheck.checkPhone(phone)) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                teacherService.updateById(account, phone);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //教师发布论文
    @Transactional
    @RequestMapping(value = "/design/teacher/addPaper")
    public void addPaper(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("teacher".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            String title = req.getParameter("title");
            String notes = req.getParameter("notes");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (title == null || "".equals(title.trim()) || notes == null || "".equals(notes.trim())) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                AufeTeacherEntity teacher = teacherService.getInfoByAccount(account);
                //生成一个论文id，按主键逆序查最后一条的id+1。
                Integer id = paperItemService.getLastPaperId();
                if (id==null || id==0){
                    id = 100001;
                }
                paperItemService.insertPaper((id + 1), teacher.getAcademy(),teacher.getProfession(), account, teacher.getName(), title, notes,teacher.getPhone());
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //教师删除论文
    @Transactional
    @RequestMapping(value = "/design/teacher/paperDelete")
    public void paperDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        if ("teacher".equals(person)) {
            String id = req.getParameter("id");
            paperItemService.deleteById(id);
            out.write("yes");
            out.flush();
            out.close();
        } else {
            out.write("no");
            out.flush();
            out.close();
        }
    }
    //教师修改论文
    @Transactional
    @RequestMapping(value = "/design/teacher/updatePaper")
    public void paperUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("teacher".equals(person)) {
            Integer id = StringUtil.toInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String notes = req.getParameter("notes");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (title == null || "".equals(title.trim()) || notes == null || "".equals(notes.trim())) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                paperItemService.updatePaper(id, title, notes);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    @Resource
    private TeacherService teacherService;

    @Resource
    private PaperItemService paperItemService;
}
