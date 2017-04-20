package com.springmvc.dao.impl;


import java.util.ArrayList;
import java.util.List;

import com.springmvc.dao.AbstractBaseRedisDao;
import com.springmvc.dao.IUserDao;
import com.springmvc.dto.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * Created by randy on 17-4-20.
 */
@Repository
public class IUserDaoImpl extends AbstractBaseRedisDao<String, User> implements IUserDao {

    /**
     * 新增
     * <br>------------------------------<br>
     *
     * @param user
     * @return
     */
    public boolean add(final User user) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(user.getId());
                byte[] name = serializer.serialize(user.getUserName());
                return connection.setNX(key, name);
            }
        });
        return result;
    }

    /**
     * 批量新增 使用pipeline方式
     * <br>------------------------------<br>
     *
     * @param list
     * @return
     */
    public boolean add(final List<User> list) {
        Assert.notEmpty(list);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                for (User user : list) {
                    byte[] key = serializer.serialize(user.getId());
                    byte[] name = serializer.serialize(user.getUserName());
                    connection.setNX(key, name);
                }
                return true;
            }
        }, false, true);
        return result;
    }

    /**
     * 删除
     * <br>------------------------------<br>
     *
     * @param key
     */
    public void delete(String key) {
        List<String> list = new ArrayList<String>();
        list.add(key);
        delete(list);
    }

    /**
     * 删除多个
     * <br>------------------------------<br>
     *
     * @param keys
     */
    public void delete(List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 修改
     * <br>------------------------------<br>
     *
     * @param user
     * @return
     */
    public boolean update(final User user) {
        String key = user.getId();
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(user.getId());
                byte[] name = serializer.serialize(user.getUserName());
                connection.set(key, name);
                return true;
            }
        });
        return result;
    }

    /**
     * 通过key获取
     * <br>------------------------------<br>
     *
     * @param keyId
     * @return
     */
    public User get(final String keyId) {
        User result = redisTemplate.execute(new RedisCallback<User>() {
            public User doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(keyId);
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                String name = serializer.deserialize(value);
                return new User(keyId, name, null);
            }
        });
        return result;
    }
}
