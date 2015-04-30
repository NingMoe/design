package cn.edu.aufe.guixiaorun.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by guixiaorun on 15-4-7.
 */
@Repository
public interface AufeAccountMapper {

    String getPswByAccount(int account);

    String getNameById(int account);

    void insert(Map<String, Object> query);


    void deleteById(int id);

    void updateTeacher(Map<String, Object> query);
}
