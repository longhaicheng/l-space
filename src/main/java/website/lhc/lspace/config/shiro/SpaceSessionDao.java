package website.lhc.lspace.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import website.lhc.lspace.commo.util.RedisUtil;

import java.io.Serializable;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.shiro
 * @ClassName: SpaceSessionDao
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/1 下午 11:21
 */
public class SpaceSessionDao extends EnterpriseCacheSessionDAO {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 创建session
     *
     * @param session session
     * @return Serializable
     */
    @Override
    protected Serializable doCreate(Session session) {
        SessionIdGenerator idGenerator = new SpaceSessionIdGenerator();
        return idGenerator.generateId(session);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return super.doReadSession(sessionId);
    }

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
    }

    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
    }
}
