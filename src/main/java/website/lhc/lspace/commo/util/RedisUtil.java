package website.lhc.lspace.commo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.util
 * @ClassName: RedisUtil
 * @Author: lhc
 * @Description: Spring Data Redis工具类
 * @Date: 2020/4/1 下午 03:12
 */
@Slf4j
@Component
public class RedisUtil {

    /**
     * 分隔符
     */
    private static final String SEPARATE = "_";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 获取
     *
     * @param key key
     * @return Object
     */
    public Object get(String key) {
        if (StringUtils.hasLength(key)) {
            Object a = redisTemplate.opsForValue().get(key.toLowerCase());
            log.info("get from redis;key:{},result:{}", key, a);
            return a;
        }
        return null;
    }

    public void set(String key, Object value, long time, TimeUnit unit) {
        if (value != null) {
            redisTemplate.opsForValue().set(key.toLowerCase(), value, time, unit);
        }
    }

    /**
     * 添加值
     *
     * @param key   key
     * @param value value
     */
    public void set(String key, Object value) {
        if (StringUtils.hasLength(key)) {
            redisTemplate.opsForValue().set(key.toLowerCase(), value);
        }
    }

    public void setWithPrefix(String prefix, Object key, Object value) {
        set(prefix + SEPARATE + key, value);
    }

    /**
     * 删除
     *
     * @param key key
     */
    public void del(String key) {
        if (StringUtils.hasLength(key)) {
            redisTemplate.delete(key.toLowerCase());
        }
    }

    public void delWithPrefix(String prefix, Object key) {
        del(prefix + SEPARATE + key);
    }

    /**
     * 递增
     * set name 0
     * get name --> 0
     * incr name --> 1
     * incr name --> 2
     *
     * @param key key
     */
    public void increment(String key) {
        if (StringUtils.hasLength(key)) {
            redisTemplate.opsForValue().increment(key.toLowerCase());
        }
    }

    /**
     * 通过前缀获取值
     *
     * @param prefix
     * @param key
     * @return
     */
    public Object getWithPrefix(String prefix, Object key) {
        return get(prefix + SEPARATE + key);
    }

    /**
     * 获取所有的数据
     *
     * @param key the key
     * @return
     */
    public Set<String> keys(String key) {

        if (StringUtils.hasText(key)) {
            Set<String> set = redisTemplate.keys(key + "*");
            return set;
        }
        return Collections.emptySet();
    }

    public byte[] getByte(String prefix, String key) {
        if (StringUtils.hasLength(key)) {
            String str = (String) redisTemplate.opsForValue().get(prefix.toLowerCase() + SEPARATE + key.toLowerCase());
            try {
                SerializationUtils.serialize(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setByte(String prefix, String key, byte[] bytes) {
        if (StringUtils.hasLength(key)) {
            redisTemplate.opsForValue().set(prefix.toLowerCase() + SEPARATE + key.toLowerCase(), bytes);
        }
    }


    public void dfds() {
        redisTemplate.opsForHash();
//        redisTemplate


    }
}
