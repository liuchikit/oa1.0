package com.zhumian.util;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/13 23:12
 */
public class RedisCache implements Cache {

    private RedisTemplate<String,Object> redisTemplate;
    private String name;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper get(Object key) {
        String k = key.toString();
        Object object = null;
        object = redisTemplate.execute((RedisConnection connection) -> {
            byte[] keyb = k.getBytes();
            byte[] value = connection.get(keyb);
            if (value == null) {
                return null;
            }
            return toObject(value);
        });
        return (object != null ? new SimpleValueWrapper(object) : null);
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        final String k = key.toString();
        final Object v = value;
        final long liveTime = 86400;
        redisTemplate.execute((RedisConnection redisConnection) ->{
            byte[] keyb = k.getBytes();
            byte[] valueb = toByteArray(v);
            redisConnection.set(keyb, valueb);
            if (liveTime > 0) {
                redisConnection.expire(keyb, liveTime);
            }
            return 1L;
        });

    }

    @Override
    public void evict(Object key) {
        final String k = key.toString();
        redisTemplate.execute((RedisConnection redisConnection) -> {
            return redisConnection.del(k.getBytes());
        });

    }

    @Override
    public void clear() {
        redisTemplate.execute((RedisConnection redisConnection) -> {
            redisConnection.flushDb();
            return "ok";
        });
    }

    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }
}
