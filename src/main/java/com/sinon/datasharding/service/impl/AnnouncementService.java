package com.sinon.datasharding.service.impl;

import com.sinon.datasharding.entity.AnnouncementDO;
import com.sinon.datasharding.mapper.AnnouncementMapper;
import com.sinon.datasharding.service.IAnnouncementService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementService
 * @CreateDate 2020/9/23
 */

@Service
@CacheConfig(cacheNames = "announcement")
public class AnnouncementService implements IAnnouncementService {
    private final AnnouncementMapper announcementMapper;

    @Autowired
    private AnnouncementService announcementService;

    public AnnouncementService(AnnouncementMapper announcementMapper) {
        this.announcementMapper = announcementMapper;
    }


    @Override
    public AnnouncementDO selectTest(int id) {
//        HintManager hintManager = HintManager.getInstance();
//        hintManager.setDatabaseShardingValue("ds0");
        AnnouncementDO announcementDO = announcementMapper.selectTest(id);
//        hintManager.close();
        return announcementDO;
    }



    @Override
    public AnnouncementDO selectOne(int id) {
        //HintManager hintManager = HintManager.getInstance();
        //hintManager.setDatabaseShardingValue("ds1");
        AnnouncementDO announcementDO = announcementMapper.selectTest(id);
        //分片键值保存在 ThreadLocal 中，所以需要在操作结束时调用 hintManager.close() 来清除 ThreadLocal 中的内容。
        //hintManager.close();
        return announcementDO;
    }


    @Scheduled(cron = "*/1 * * * * ?")
    public void test(){
        System.out.println(new Date());
    }

}
