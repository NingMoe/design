package cn.edu.aufe.guixiaorun.mapper;

import cn.edu.aufe.guixiaorun.entity.AufeStudentEntity;
import cn.edu.aufe.guixiaorun.entity.AufeTeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by guixiaorun on 15-4-8.
 */
@Repository
public interface StudentMapper {

    AufeStudentEntity getByAccount(int account);

    void updateById(Map<String, Object> query);

    void insertPaperById(Map<String, Object> query);

    long countAll();

    List<AufeStudentEntity> getByPage(Map<String, Object> query);

    long countByConditions(Map<String, Object> query);

    List<AufeStudentEntity> getByPageConditions(Map<String, Object> query);

    Integer getLastId();

    void insert(Map<String, Object> query);

    void deleteById(int id);

    Integer getPaperId(int id);

    void updateStudent(Map<String, Object> query);
}
