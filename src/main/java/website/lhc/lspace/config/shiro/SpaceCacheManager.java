package website.lhc.lspace.config.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import website.lhc.lspace.commo.util.RedisUtil;

import java.util.Collection;
import java.util.Set;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.shiro
 * @ClassName: SpaceCacheManager
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/2 上午 11:14
 */
public class SpaceCacheManager implements CacheManager {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return null;
    }
}

class RedisCacha<K, V> implements Cache<K, V> {

    private static final String SPACE_CACHE = "space_cache";

    @Override
    public V get(K k) throws CacheException {
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
