package cn.edu.aufe.guixiaorun.service;

import cn.edu.aufe.guixiaorun.bean.Page;
import cn.edu.aufe.guixiaorun.entity.PaperItemEntity;

import java.util.List;

public interface PaperItemService {
    List<PaperItemEntity> findPaperItemByPage(Page page);

    long countAll();

    long countByAccount(int account);

    Integer getLastPaperId();

    void insertPaper(int id, String academy, String profession, int account, String name, String title, String notes,String teacherPhone);

    void deleteById(String id);

    List<PaperItemEntity> findPaperByPageAccount(Page page, int account);

    long countByConditions(String teacherName, String title, String academy,String profession, String isSelected);

    List<PaperItemEntity> findPaperItemByPageConditions(String teacherName, String title, String academy,String profession, String isSelected, Page page);

    void updatePaper(Integer id, String title, String notes);

    long countByStudent(String profession, String isSelected);

    List<PaperItemEntity> findBySelected(Page page, String profession, String isSelected);

    long countBySelectedConditions(String teacherName, String title, String profession, String isSelected);

    List<PaperItemEntity> findBySelectedConditionsPage(String teacherName, String title, String profession, String isSelected, Page page);

    void insertStudent(int paperId, String name, Integer studentId ,String isSelected);

    void canclePaperByPaperId(int paperId, String studentName, int studentId, String isSelected);

    void deleteByTeacher(int id);

    void updateTeacher(Integer id, String name);

    void removeStudent(int id);

    void updateStudent(Integer id, String name);
}
