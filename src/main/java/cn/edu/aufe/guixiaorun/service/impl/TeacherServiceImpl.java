package cn.edu.aufe.guixiaorun.service.impl;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeTeacherEntity;
import cn.edu.aufe.guixiaorun.mapper.TeacherMapper;
import cn.edu.aufe.guixiaorun.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guixiaorun on 15-4-8.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Override
    public AufeTeacherEntity getInfoByAccount(int account) {
        return teacherMapper.getByAccount(account) ;
    }

    @Override
    public void updateById(int account, String phone) {
        Map<String,Object> condition = new HashMap<String, Object>() ;
        condition.put("account",account);
        condition.put("phone",phone);
        teacherMapper.updateById(condition);
    }

    @Override
    public long countAll() {
        return teacherMapper.countAll();
    }

    @Override
    public List<AufeTeacherEntity> findTeacherByPage(Page page) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        return teacherMapper.getByPage(query);
    }

    @Override
    public long countByConditions(String teacherId, String teacherName, String academy, String profession) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("teacherId",teacherId) ;
        query.put("teacherName",teacherName) ;
        query.put("academy",academy) ;
        query.put("profession",profession) ;
        return teacherMapper.countByConditions(query);
    }

    @Override
    public List<AufeTeacherEntity> findTeacherByPageConditions(String teacherId, String teacherName, String academy, String profession, Page page) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("teacherId",teacherId) ;
        query.put("teacherName",teacherName) ;
        query.put("academy",academy) ;
        query.put("profession",profession) ;
        query.put("startNum",page.getStartNum()) ;
        query.put("perPageCount",page.getPerPageCount()) ;
        return teacherMapper.getByPageConditions(query);
    }

    @Override
    public int getLastId() {
        return teacherMapper.getLastId();
    }

    @Override
    public void insertTeacher(int id, String name, String password, String academy, String phone, String rank, String profession, String sex) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("id",id) ;
        query.put("name",name) ;
        query.put("password",password) ;
        query.put("academy",academy) ;
        query.put("phone",phone) ;
        query.put("rank",rank) ;
        query.put("profession",profession) ;
        query.put("sex",sex) ;
        teacherMapper.insert(query);
    }

    @Override
    public void deleteById(Integer id) {
        teacherMapper.deleteById(id) ;
    }

    @Override
    public void updateTeacher(Integer id, String name, String password, String rank) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("id",id) ;
        query.put("name",name) ;
        query.put("password",password) ;
        query.put("rank",rank) ;
        teacherMapper.updateTeacherByConditions(query);
    }


    @Resource
    private TeacherMapper teacherMapper ;
}
