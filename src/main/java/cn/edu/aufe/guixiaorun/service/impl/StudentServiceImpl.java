package cn.edu.aufe.guixiaorun.service.impl;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeStudentEntity;
import cn.edu.aufe.guixiaorun.mapper.StudentMapper;
import cn.edu.aufe.guixiaorun.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guixiaorun on 15-4-8.
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Resource
    private StudentMapper studentMapper ;

    @Override
    public AufeStudentEntity getInfoByAccount(int account) {
        return studentMapper.getByAccount(account) ;
    }

    @Override
    public void updateById(int account, String phone) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("account",account);
        query.put("phone",phone);
        studentMapper.updateById(query);
    }

    @Override
    public void insertPaper(Integer studentId, Integer paperId,String paperTitle,String teacherPhone) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("studentId",studentId);
        query.put("paperId",paperId);
        query.put("paperTitle",paperTitle);
        query.put("teacherPhone",teacherPhone);
        studentMapper.insertPaperById(query);
    }

    @Override
    public void canclePaperById(int account, int paperId, String paperTitle, String teacherPhone) {
        insertPaper(account,paperId,paperTitle,teacherPhone);
    }

    @Override
    public long countAll() {
        return studentMapper.countAll();
    }

    @Override
    public List<AufeStudentEntity> findStudentByPage(Page page) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        return studentMapper.getByPage(query);
    }

    @Override
    public long countByConditions(String studentId, String studentName, String academy, String profession) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("studentId",studentId);
        query.put("studentName",studentName);
        query.put("academy",academy);
        query.put("profession",profession);
        return studentMapper.countByConditions(query);
    }

    @Override
    public List<AufeStudentEntity> findStudentByPageConditions(String studentId, String studentName, String academy, String profession, Page page) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("studentId",studentId);
        query.put("studentName",studentName);
        query.put("academy",academy);
        query.put("profession",profession);
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        return studentMapper.getByPageConditions(query);
    }

    @Override
    public Integer getLastId() {
        return studentMapper.getLastId();
    }

    @Override
    public void insertStudent(Integer id, String name, String password, String academy, String phone, String inClass, String profession, String sex) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("id",id);
        query.put("name",name);
        query.put("password",password);
        query.put("academy",academy);
        query.put("phone",phone);
        query.put("inClass",inClass);
        query.put("profession",profession);
        query.put("sex",sex);
        studentMapper.insert(query);
    }

    @Override
    public void deleteById(int id) {
        studentMapper.deleteById(id);
    }

    @Override
    public Integer getPaperId(int id) {
        return studentMapper.getPaperId(id);
    }

    @Override
    public void updateStudent(Integer id, String name, String password) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("id",id);
        query.put("name",name);
        query.put("password",password);
        studentMapper.updateStudent(query);
    }
}
