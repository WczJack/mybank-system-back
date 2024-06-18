package com.neuedu.mobilebank.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {
    void save(String telephone, String value, long time, TimeUnit unit);
    String get(String telephone,String value);
}
