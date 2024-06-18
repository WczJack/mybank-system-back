package com.neuedu.mobilebank.mapper.mapperimpl;

import com.neuedu.mobilebank.mapper.RedisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository("rmi")
public class RedisMapperImpl implements RedisMapper {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save(String telephone, String value, long time, TimeUnit unit) {
        ValueOperations op = redisTemplate.opsForValue();
        op.set(telephone, value, time, unit);
    }

    @Override
    public String get(String telephone) {
        ValueOperations op = redisTemplate.opsForValue();
        String value = (String) (op.get(telephone));
        return value;
    }
}
