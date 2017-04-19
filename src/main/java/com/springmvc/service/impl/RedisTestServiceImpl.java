package com.springmvc.service.impl;

import com.springmvc.service.RedisTestService;

/**
 * Created by randy on 17-4-17.
 */
public class RedisTestServiceImpl implements RedisTestService {

    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

}
