package cn.edu.aufe.guixiaorun.mapper;

import cn.edu.aufe.guixiaorun.entity.AufeNotifyEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by guixiaorun on 15-4-7.
 */
@Repository
public interface AufeNotifyMapper {

    AufeNotifyEntity findLast();

    void insert(Map<String, Object> query);
}
