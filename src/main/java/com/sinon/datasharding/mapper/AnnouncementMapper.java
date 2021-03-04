package com.sinon.datasharding.mapper;


import com.sinon.datasharding.entity.AnnouncementDO;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0.0
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 * @Description AnnouncementMapper
 * @CreateDate 2020/9/23
 */
@Repository
public interface AnnouncementMapper {

    AnnouncementDO selectTest(int id);

    AnnouncementDO selectOne(int id);
}

