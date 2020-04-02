package website.lhc.lspace.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import website.lhc.lspace.commo.util.RedisUtil;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.shiro
 * @ClassName: SpaceSessionDao
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/1 下午 11:21
 */
@Slf4j
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
        Serializable id = idGenerator.generateId(session);
        redisUtil.set(String.valueOf(id), session);
        if (log.isDebugEnabled()) {
            log.debug("创建sessionId:{}; session:{}", id, session);
        }
        return id;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);

        if (session == null) {
            session = (Session) redisUtil.get(session.getId().toString());
            if (session != null) {
                if (log.isDebugEnabled()) {
                    log.debug(" method:doReadSession, get session from redis:{}", session.toString());
                }
                return session;
            }
        }
        if (log.isDebugEnabled()) {
            log.debug("get session from super class:{}", session.toString());
        }
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        redisUtil.set(session.getId().toString(), session, session.getTimeout(), TimeUnit.MICROSECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        redisUtil.del(session.getId().toString());
        super.doDelete(session);
    }


    /**
     * session --> byte
     *
     * @param session Session
     * @return byte[]
     */
    private byte[] sessionToByte(Session session) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = null;

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(session);
            bytes = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }


    /**
     * byte[] --> session
     *
     * @param bytes byte[]
     * @return Session
     */
    private Session byteToSession(byte[] bytes) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        ObjectInputStream in;
        SpaceSession session = null;

        try {
            in = new ObjectInputStream(inputStream);
            session = (SpaceSession) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return session;

    }
}
