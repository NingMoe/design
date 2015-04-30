package cn.edu.aufe.guixiaorun.service;

import cn.edu.aufe.guixiaorun.entity.AufeNotifyEntity;

/**
 * Created by guixiaorun on 15-4-7.
 */
public interface NotifyService {
    AufeNotifyEntity findLastNotify();

    void insert(String notify, String warning);
}
