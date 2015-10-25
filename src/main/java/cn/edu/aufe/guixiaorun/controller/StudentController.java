package cn.edu.aufe.guixiaorun.controller;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeStudentEntity;
import cn.edu.aufe.guixiaorun.entity.PaperItemEntity;
import cn.edu.aufe.guixiaorun.service.PaperItemService;
import cn.edu.aufe.guixiaorun.service.StudentService;
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
public class StudentController {

    //学生个人信息
    @RequestMapping(value = "/design/student/info")
    public String studentInfo(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("student".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            AufeStudentEntity student = studentService.getInfoByAccount(account);
            req.setAttribute("student", student);
            return "student/info";
        }
        return "error/error404";
    }

    //修改个人信息，暂时只支持修改联系方式
    @RequestMapping(value = "/design/student/updateInfo")
    public void updateInfo(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("student".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            String phone = req.getParameter("phone");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (!RegCheck.checkPhone(phone)) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                studentService.updateById(account, phone);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //进入选择论文模块
    @RequestMapping(value = "design/student/selectPaper")
    public String selectPaper(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("student".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            Page page = new Page();
            page.setCurrentPage(1);
            page.setPerPageCount(10);
            AufeStudentEntity student = studentService.getInfoByAccount(account);
            long count = paperItemService.countByStudent(student.getProfession(), NO_SELECTED);
            page.setTotalCount(count);
            List<PaperItemEntity> paperItemEntityList = paperItemService.findBySelected(page, student.getProfession(), NO_SELECTED);
            if (paperItemEntityList != null && paperItemEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(paperItemEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("paperItemLs", paperItemEntityList);
            req.setAttribute("page", page);
            return "student/studentTable";
        }
        return "error/error404";
    }

    //可选论文查询（多条件查询可分页）
    @RequestMapping(value = "/design/student/studentPagePaper")
    public String searchByConditions(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("student".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            String teacherName = "";
            String title = "";
            int currentPage = 0;
            int perPageCount = 0;
            try {
                teacherName = "%" + req.getParameter("teacherName") + "%";
                title = "%" + req.getParameter("title") + "%";
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
            AufeStudentEntity student = studentService.getInfoByAccount(account);
            long count = paperItemService.countBySelectedConditions(teacherName, title, student.getProfession(), NO_SELECTED);
            page.setTotalCount(count);
            List<PaperItemEntity> paperItemEntityList = paperItemService.findBySelectedConditionsPage(teacherName, title, student.getProfession(), NO_SELECTED, page);
            if (paperItemEntityList != null && paperItemEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(paperItemEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("paperItemLs", paperItemEntityList);
            req.setAttribute("page", page);
            return "student/studentPageTable";
        }
        return "error/error404";
    }

    //选择论文操作
    @RequestMapping(value = "/design/student/getPaper")
    public void selectCheck(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("student".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            int paperId = StringUtil.toInt(req.getParameter("id"));
            String title = req.getParameter("title") + "";
            String phone = req.getParameter("phone") + "";
            AufeStudentEntity student = studentService.getInfoByAccount(account);
            int id = student.getPaperId();
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (id != 0) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                //当可选论文时，将当前学生信息插入到论文信息中并且将论文id插入到学生信息中
                paperItemService.insertStudent(paperId, student.getName(), student.getId(), YES_SELECTED);
                studentService.insertPaper(student.getId(), paperId, title, phone);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //取消已选论文，成功后可以重新选择论文
    @RequestMapping(value = "/design/student/canclePaper")
    public void canclePaper(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("student".equals(person)) {
            int account = StringUtil.toInt(session.getAttribute("account"));
            int paperId = StringUtil.toInt(req.getParameter("id"));
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            //学生表的论文相关信息全部置为默认
            studentService.canclePaperById(account, 0, "尚未选择论文主题","尚未取得导师联系方式");
            //论文表的学生相关信息全部置为默认
            paperItemService.canclePaperByPaperId(paperId,"",0,NO_SELECTED);
            out.write("yes");
            out.flush();
            out.close();

        }

    }


    public static final String NO_SELECTED = "未选中";
    public static final String YES_SELECTED = "已选中";

    @Resource
    private StudentService studentService;

    @Resource
    private PaperItemService paperItemService;
}
