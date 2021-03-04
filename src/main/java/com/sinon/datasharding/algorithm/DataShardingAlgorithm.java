package com.sinon.datasharding.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Classname DataShardingAlgorithm
 * @Description TODO
 * @Date 2021/3/3 15:13
 * @Created by sinon
 * @Author <a href="huangyanzhi@wxchina.com">Sinon</a>
 */
public class DataShardingAlgorithm implements HintShardingAlgorithm<String> {
    private static final Logger logger = LoggerFactory.getLogger(DataShardingAlgorithm.class);

    private static final AtomicInteger ROUND_ROBIN = new AtomicInteger(0);

    /**
     * 自定义Hint 实现算法
     * 能够保证绕过Sharding-JDBC SQL解析过程
     * @param availableTargetNames
     * @param shardingValue 不再从SQL 解析中获取值，而是直接通过hintManager.addTableShardingValue("t_order", 1)参数指定
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        Collection<String> result = new HashSet<>();
        for (String value : shardingValue.getValues()) {
            if (availableTargetNames.contains(value)) {
                result.add(value);
            }
        }
        logger.info("availableTargetNames:{},shardingValue:{},返回的数据源:{}",
                new Object[]{availableTargetNames, shardingValue, result});

        return result;
    }
}
