package cn.edu.aufe.guixiaorun.service;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.AufeStudentEntity;

import java.util.List;

/**
 * Created by guixiaorun on 15-4-8.
 */
public interface StudentService {
    AufeStudentEntity getInfoByAccount(int account);

    void updateById(int account, String phone);

    void insertPaper(Integer studentId, Integer paperId,String paperTitle,String teacherPhone);

    void canclePaperById(int account, int paperId, String paperTitle, String teacherPhone);

    long countAll();

    List<AufeStudentEntity> findStudentByPage(Page page);

    long countByConditions(String studentId, String studentName, String academy, String profession);

    List<AufeStudentEntity> findStudentByPageConditions(String studentId, String studentName, String academy, String profession, Page page);

    Integer getLastId();

    void insertStudent(Integer id, String name, String password, String academy, String phone, String inClass, String profession, String sex);

    void deleteById(int id);

    Integer getPaperId(int id);

    void updateStudent(Integer id, String name, String password);
}
