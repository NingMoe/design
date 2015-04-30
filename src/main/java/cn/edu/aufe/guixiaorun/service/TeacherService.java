package cn.edu.aufe.guixiaorun.service;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeTeacherEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guixiaorun on 15-4-8.
 */
public interface TeacherService {
    AufeTeacherEntity getInfoByAccount(int account);

    void updateById(int account, String phone);

    long countAll();


    List<AufeTeacherEntity> findTeacherByPage(Page page);

    long countByConditions(String teacherId, String teacherName, String academy, String profession);

    List<AufeTeacherEntity> findTeacherByPageConditions(String teacherId, String teacherName, String academy, String profession, Page page);

    int getLastId();

    void insertTeacher(int id, String name, String password, String academy, String phone, String rank, String profession, String sex);

    void deleteById(Integer id);

    void updateTeacher(Integer id, String name, String password, String rank);

}
