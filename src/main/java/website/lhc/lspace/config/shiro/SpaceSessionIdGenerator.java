package website.lhc.lspace.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.io.Serializable;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.shiro
 * @ClassName: SpaceSessionIdGenerator
 * @Author: lhc
 * @Description: 自定义SessionId生成器
 * @Date: 2020/4/1 下午 11:25
 */
public class SpaceSessionIdGenerator implements SessionIdGenerator {

    @Override
    public Serializable generateId(Session session) {
        return new AlternativeJdkIdGenerator().generateId();
    }
}
