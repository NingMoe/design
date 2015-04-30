package cn.edu.aufe.guixiaorun.service.impl;

import cn.edu.aufe.guixiaorun.entity.AufeNotifyEntity;
import cn.edu.aufe.guixiaorun.mapper.AufeNotifyMapper;
import cn.edu.aufe.guixiaorun.service.NotifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guixiaorun on 15-4-7.
 */
@Service
public class NotifyServiceImpl implements NotifyService {
    @Override
    public AufeNotifyEntity findLastNotify() {
        return aufeNotifyMapper.findLast();
    }

    @Override
    public void insert(String notify, String warning) {
        Map<String,Object> query = new HashMap<String, Object>();
        query.put("notify",notify);
        query.put("warning",warning);
        aufeNotifyMapper.insert(query);
    }

    @Resource
    private AufeNotifyMapper aufeNotifyMapper ;
}
