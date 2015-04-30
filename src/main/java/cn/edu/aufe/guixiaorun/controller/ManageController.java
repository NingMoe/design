package cn.edu.aufe.guixiaorun.controller;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeNotifyEntity;
import cn.edu.aufe.guixiaorun.entity.AufeStudentEntity;
import cn.edu.aufe.guixiaorun.entity.AufeTeacherEntity;
import cn.edu.aufe.guixiaorun.entity.PaperItemEntity;
import cn.edu.aufe.guixiaorun.service.*;
import cn.edu.aufe.guixiaorun.util.RegCheck;
import cn.edu.aufe.guixiaorun.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by guixiaorun on 15-4-27.
 */
@Controller
public class ManageController {

    //查看所有老师
    @RequestMapping(value = "/design/manage/teacherManage")
    public String allTeacher(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            Page page = new Page();
            page.setCurrentPage(1);
            page.setPerPageCount(10);
            long count = teacherService.countAll();
            page.setTotalCount(count);
            List<AufeTeacherEntity> aufeTeacherEntityList = teacherService.findTeacherByPage(page);
            if (aufeTeacherEntityList != null && aufeTeacherEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(aufeTeacherEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("teacherLs", aufeTeacherEntityList);
            req.setAttribute("page", page);
            return "manage/showAllTeacher";
        }
        return "error/error404";
    }

    //普通查询（多条件查询）
    @RequestMapping(value = "/design/manage/searchTeacher")
    public String searchTeacher(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            String teacherName = "";
            String teacherId = "";
            String academy = "";
            String profession = "";
            int currentPage = 0;
            int perPageCount = 0;
            try {
                teacherName = "%" + req.getParameter("teacherName") + "%";
                teacherId = "%" + req.getParameter("teacherId") + "%";
                academy = "%" + req.getParameter("academy") + "%";
                profession = "%" + req.getParameter("profession") + "%";
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
            long count = teacherService.countByConditions(teacherId, teacherName, academy, profession);
            page.setTotalCount(count);
            List<AufeTeacherEntity> aufeTeacherEntityList = teacherService.findTeacherByPageConditions(teacherId, teacherName, academy, profession, page);
            if (aufeTeacherEntityList != null && aufeTeacherEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(aufeTeacherEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("teacherLs", aufeTeacherEntityList);
            req.setAttribute("page", page);
            return "manage/showTeacherPage";
        }
        return "error/error404";
    }

    //增加教师
    @RequestMapping(value = "/design/manage/addTeacher")
    public void addTeacher(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            String name = req.getParameter("name");
            String academy = req.getParameter("academy");
            String profession = req.getParameter("profession");
            String rank = req.getParameter("rank");
            String phone = req.getParameter("phone");
            String sex = req.getParameter("sex");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (!RegCheck.checkName(name) || !RegCheck.checkPhone(phone)) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                //生成一个教师id，按主键逆序查最后一条的id+1。
                int id = teacherService.getLastId() + 1;
                //随机生成一个6位密码
                String password = ((int) ((Math.random() * 9 + 1) * 100000)) + "";
                //添加教师记录(教师表和帐号表都得增加记录)
                accountService.addAccount(id,name,password);
                teacherService.insertTeacher(id, name, password, academy, phone, rank, profession, sex);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //删除教师
    @RequestMapping(value = "/design/manage/deleteTeacher")
    public void teacherDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        if ("admin".equals(person)) {
            int id = StringUtil.toInt(req.getParameter("id"));
            //(教师表、帐号表和论文表都得删除记录)
            accountService.removeAccount(id);
            teacherService.deleteById(id);
            paperItemService.deleteByTeacher(id);
            out.write("yes");
            out.flush();
            out.close();
        } else {
            out.write("no");
            out.flush();
            out.close();
        }
    }
    //修改教师
    @RequestMapping(value = "/design/manage/updateTeacher")
    public void teacherUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            Integer id = StringUtil.toInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String rank = req.getParameter("rank");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (!RegCheck.checkName(name) || !RegCheck.checkPassword(password)) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                //(教师表、帐号表和论文表都得修改记录)
                accountService.updateTeacher(id, name,password);
                teacherService.updateTeacher(id, name,password,rank);
                paperItemService.updateTeacher(id,name);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //查看所有学生
    @RequestMapping(value = "/design/manage/studentManage")
    public String allStudent(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            Page page = new Page();
            page.setCurrentPage(1);
            page.setPerPageCount(10);
            long count = studentService.countAll();
            page.setTotalCount(count);
            List<AufeStudentEntity> aufeStudentEntityList = studentService.findStudentByPage(page);
            if (aufeStudentEntityList != null && aufeStudentEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(aufeStudentEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("studentLs", aufeStudentEntityList);
            req.setAttribute("page", page);
            return "manage/showAllStudent";
        }
        return "error/error404";
    }

    //普通查询（多条件查询）
    @RequestMapping(value = "/design/manage/searchStudent")
    public String searchStudent(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            String studentName = "";
            String studentId = "";
            String academy = "";
            String profession = "";
            int currentPage = 0;
            int perPageCount = 0;
            try {
                studentName = "%" + req.getParameter("studentName") + "%";
                studentId = "%" + req.getParameter("studentId") + "%";
                academy = "%" + req.getParameter("academy") + "%";
                profession = "%" + req.getParameter("profession") + "%";
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
            long count = studentService.countByConditions(studentId, studentName, academy, profession);
            page.setTotalCount(count);
            List<AufeStudentEntity> aufeStudentEntityList = studentService.findStudentByPageConditions(studentId, studentName, academy, profession, page);
            if (aufeStudentEntityList != null && aufeStudentEntityList.size() > 0) {
                page.setEndNum(StringUtil.toLong(aufeStudentEntityList.size()));
            } else {
                page.setEndNum(0L);
            }
            req.setAttribute("studentLs", aufeStudentEntityList);
            req.setAttribute("page", page);
            return "manage/showStudentPage";
        }
        return "error/error404";
    }

    //增加学生
    @RequestMapping(value = "/design/manage/addStudent")
    public void addStudent(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            String name = req.getParameter("name");
            String academy = req.getParameter("academy");
            String profession = req.getParameter("profession");
            String inClass = req.getParameter("inClass");
            String phone = req.getParameter("phone");
            String sex = req.getParameter("sex");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (!RegCheck.checkName(name) || !RegCheck.checkPhone(phone) || "".equals(inClass)) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                //生成一个教师id，按主键逆序查最后一条的id+1。
                Integer id = studentService.getLastId() + 1;
                if (id==null){
                    id = 20110001;
                }
                //随机生成一个6位密码
                String password = ((int) ((Math.random() * 9 + 1) * 100000)) + "";
                //添加学生记录(教师表和帐号表都得增加记录)
                accountService.addAccount(id,name,password);
                studentService.insertStudent(id, name, password, academy, phone, inClass, profession, sex);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //删除学生
    @RequestMapping(value = "/design/manage/deleteStudent")
    public void studentDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        if ("admin".equals(person)) {
            int id = StringUtil.toInt(req.getParameter("id"));
            //(教师表、帐号表和论文表都得删除记录)
            accountService.removeAccount(id);
            studentService.deleteById(id);
            Integer paperId = studentService.getPaperId(id);
            if (paperId != null && paperId != 0) {
                paperItemService.removeStudent(paperId);
            }
            out.write("yes");
            out.flush();
            out.close();
        } else {
            out.write("no");
            out.flush();
            out.close();
        }
    }
    //修改学生
    @RequestMapping(value = "/design/manage/updateStudent")
    public void studentUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            Integer id = StringUtil.toInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            res.setCharacterEncoding("UTF-8");
            PrintWriter out = res.getWriter();
            if (!RegCheck.checkName(name) || !RegCheck.checkPassword(password)) {
                out.write("no");
                out.flush();
                out.close();
            } else {
                //(学生表、帐号表和论文表都得修改记录)
                accountService.updateStudent(id, name, password);
                studentService.updateStudent(id, name, password);
                paperItemService.updateStudent(id, name);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    //通知管理
    @RequestMapping(value = "/design/notify")
    public String toUpdateNotify(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        if ("admin".equals(person)) {
            AufeNotifyEntity notify = notifyService.findLastNotify();
            req.setAttribute("notify", notify);
            return "main/notify";
        }
        return "error/error404";
    }

    //改变通知
    @RequestMapping(value = "/design/notify/add")
    public void notifyAdd(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        String person = session.getAttribute("person") + "";
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        String notify = req.getParameter("notify");
        String warning = req.getParameter("warning");
        if ("admin".equals(person)) {
            if (notify==null||"".equals(notify.trim())||warning==null||"".equals(warning.trim())) {
                out.write("no");
                out.flush();
                out.close();
            }else{
                notifyService.insert(notify,warning);
                out.write("yes");
                out.flush();
                out.close();
            }
        }
    }

    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentService studentService;
    @Resource
    private AccountService accountService;
    @Resource
    private PaperItemService paperItemService;
    @Resource
    private NotifyService notifyService;

}
