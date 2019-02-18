package com.deng.mall.utils;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class RedisUtils implements Cache {
    private final static Jedis jedisClient = new Jedis("localhost", 6379);
    private final static Logger logger = LoggerFactory.getLogger(RedisUtils.class);
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private String id;

    public RedisUtils(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=[]" ,id);
        this.id = id;
    }



    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object key, Object value) {
        byte[] valueBytes = SerializeUtil.serialize(value);
        byte[] keyBytes = SerializeUtil.serialize(key);
        jedisClient.set(keyBytes, valueBytes);
    }

    @Override
    public Object getObject(Object key) {
        byte[] keyBytes = SerializeUtil.serialize(key);
        byte[] bytes = jedisClient.get(keyBytes);
        Object obj = SerializeUtil.unserialize(bytes);
        return obj;
    }

    @Override
    public Object removeObject(Object key) {
        byte[] keyBytes = SerializeUtil.serialize(key);
        Long reply=jedisClient.expire(keyBytes,0);
        return  reply;
    }

    @Override
    public void clear() {
        jedisClient.flushDB();
    }

    @Override
    public int getSize() {
       int size= Integer.valueOf(jedisClient.dbSize().toString());
       return  size;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
