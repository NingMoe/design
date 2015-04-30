package cn.edu.aufe.guixiaorun.service.impl;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.PaperItemEntity;
import cn.edu.aufe.guixiaorun.mapper.PaperItemMapper;
import cn.edu.aufe.guixiaorun.service.PaperItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperItemServiceImpl implements PaperItemService {

    @Override
    public List<PaperItemEntity> findPaperItemByPage(Page page) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        return paperItemMapper.getByPage(query);
    }

    @Override
    public long countAll() {
        return paperItemMapper.countAll();
    }

    @Override
    public long countByAccount(int account) {
        return paperItemMapper.countByAccount(account);
    }

    @Override
    public Integer getLastPaperId() {
        return paperItemMapper.findLastId();
    }

    @Override
    public void insertPaper(int id, String academy,String profession, int account,String name, String title, String notes,String teacherPhone) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("id",id);
        query.put("createTime",new Date());
        query.put("academy",academy);
        query.put("profession",profession);
        query.put("title",title);
        query.put("notes",notes);
        query.put("name",name);
        query.put("account",account);
        query.put("teacherPhone",teacherPhone);
        paperItemMapper.insert(query);
    }

    @Override
    public void deleteById(String id) {
        paperItemMapper.deleteById(id);
    }

    @Override
    public List<PaperItemEntity> findPaperByPageAccount(Page page, int account) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        query.put("teacherAccount",account) ;
        return paperItemMapper.getByPageAndAccount(query);
    }

    @Override
    public long countByConditions(String teacherName, String title, String academy,String profession, String isSelected) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("teacherName",teacherName);
        query.put("title",title);
        query.put("academy",academy);
        query.put("profession",profession);
        query.put("isSelected",isSelected);
        return paperItemMapper.countByConditions(query);
    }

    @Override
    public List<PaperItemEntity> findPaperItemByPageConditions(String teacherName, String title, String academy,String profession, String isSelected, Page page) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        query.put("teacherName",teacherName) ;
        query.put("title",title) ;
        query.put("academy",academy) ;
        query.put("profession",profession) ;
        query.put("isSelected",isSelected) ;
        return paperItemMapper.getByConditionsPage(query);
    }

    @Override
    public void updatePaper(Integer id, String title, String notes) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("id",id) ;
        query.put("title",title) ;
        query.put("notes",notes) ;
        paperItemMapper.updateTitleById(query);
    }

    @Override
    public long countByStudent(String profession, String isSelected) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("profession",profession) ;
        query.put("isSelected",isSelected) ;
        return paperItemMapper.countByStudent(query);
    }

    @Override
    public List<PaperItemEntity> findBySelected(Page page, String profession, String isSelected) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        query.put("profession",profession) ;
        query.put("isSelected",isSelected) ;
        return paperItemMapper.getBySelected(query);
    }

    @Override
    public long countBySelectedConditions(String teacherName, String title, String profession, String isSelected) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("profession",profession) ;
        query.put("isSelected",isSelected) ;
        query.put("teacherName",teacherName) ;
        query.put("title",title) ;
        return paperItemMapper.countBySelectedConditions(query);
    }

    @Override
    public List<PaperItemEntity> findBySelectedConditionsPage(String teacherName, String title, String profession, String isSelected, Page page) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        query.put("profession",profession) ;
        query.put("isSelected",isSelected) ;
        query.put("teacherName",teacherName) ;
        query.put("title",title) ;
        return paperItemMapper.getBySelectedConditionsPage(query);
    }

    @Override
    public void insertStudent(int paperId, String name, Integer studentId,String isSelected) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("id",paperId) ;
        query.put("studentName",name) ;
        query.put("studentId",studentId) ;
        query.put("isSelected",isSelected) ;
        paperItemMapper.insertStudent(query);
    }

    @Override
    public void canclePaperByPaperId(int paperId, String studentName, int studentId, String isSelected) {
        insertStudent(paperId,studentName,studentId,isSelected);
    }

    @Override
    public void deleteByTeacher(int id) {
        paperItemMapper.deleteByTeacher(id);
    }

    @Override
    public void updateTeacher(Integer id, String name) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("teacherId",id) ;
        query.put("teacherName",name) ;
        paperItemMapper.updateTeacherInfo(query);
    }

    @Override
    public void removeStudent(int id) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("id",id) ;
        query.put("studentName","") ;
        query.put("studentId",0) ;
        query.put("isSelected","未选中") ;
        paperItemMapper.removeStudent(query);
    }

    @Override
    public void updateStudent(Integer id, String name) {
        Map<String,Object> query = new HashMap<String, Object>() ;
        query.put("studentId",id) ;
        query.put("studentName",name) ;
        paperItemMapper.updateStudentInfo(query);
    }

    @Resource
    private PaperItemMapper paperItemMapper ;
}
