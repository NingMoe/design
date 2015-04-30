package cn.edu.aufe.guixiaorun.mapper;

import cn.edu.aufe.guixiaorun.entity.PaperItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by guixiaorun on 15-4-5.
 */
@Repository
public interface PaperItemMapper {

    List<PaperItemEntity> getByPage(Map<String,Object> query) ;

    long countAll();

    void insert(Map<String, Object> query);

    List<PaperItemEntity> getByAccount(int account);

    long countByAccount(int account);

    void updateByTeacher(Map<String, Object> query);

    Integer findLastId();

    void deleteById(String id);

    List<PaperItemEntity> getByPageAndAccount(Map<String, Object> query);

    long countByConditions(Map<String, Object> query);

    List<PaperItemEntity> getByConditionsPage(Map<String,Object> query);

    void updateTitleById(Map<String, Object> query);

    long countByStudent(Map<String, Object> query);

    List<PaperItemEntity> getBySelected(Map<String, Object> query);

    long countBySelectedConditions(Map<String, Object> query);

    List<PaperItemEntity> getBySelectedConditionsPage(Map<String, Object> query);

    void insertStudent(Map<String, Object> query);

    void deleteByTeacher(int id);

    void updateTeacherInfo(Map<String, Object> query);

    void removeStudent(Map<String, Object> query);

    void updateStudentInfo(Map<String, Object> query);
}
