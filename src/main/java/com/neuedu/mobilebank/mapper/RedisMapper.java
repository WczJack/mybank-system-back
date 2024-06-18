package com.neuedu.mobilebank.mapper;

import java.util.concurrent.TimeUnit;

public interface RedisMapper {
    void save(String telephone, String value, long time, TimeUnit unit);
    String get(String telephone);
}
