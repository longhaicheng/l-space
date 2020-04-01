package website.lhc.lspace.commo.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.util
 * @ClassName: RedisUtil
 * @Author: lhc
 * @Description: Spring Data Redis工具类
 * @Date: 2020/4/1 下午 03:12
 */
@Component
public class RedisUtil {

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
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    /**
     * 添加值
     *
     * @param key   key
     * @param value value
     */
    public void set(String key, Object value) {
        if (StringUtils.hasLength(key)) {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 删除
     *
     * @param key key
     */
    public void del(String key) {
        if (StringUtils.hasLength(key)) {
            redisTemplate.delete(key);
        }
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
            redisTemplate.opsForValue().increment(key);
        }
    }
}
