package cn.edu.aufe.guixiaorun.mapper;

import cn.edu.aufe.guixiaorun.entity.AufeTeacherEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by guixiaorun on 15-4-8.
 */
@Repository
public interface TeacherMapper {

    AufeTeacherEntity getByAccount(int account);

    void updateById(Map<String, Object> condition);

    long countAll();

    List<AufeTeacherEntity> getByPage(Map<String, Object> query);

    long countByConditions(Map<String, Object> query);

    List<AufeTeacherEntity> getByPageConditions(Map<String, Object> query);

    int getLastId();

    void insert(Map<String, Object> query);

    void deleteById(Integer id);

    void updateTeacherByConditions(Map<String, Object> query);
}
