package website.lhc.lspace.commo.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import website.lhc.lspace.system.user.entity.SpUser;

import java.io.Serializable;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.util
 * @ClassName: SubjectUtil
 * @Author: lhc
 * @Description: Subject工具类
 * @Date: 2020/4/2 下午 02:11
 */
public class SubjectUtil {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Session getSession() {
        return getSubject().getSession();
    }

    public static Serializable getSessionId() {
        return getSession().getId();
    }

    public static Object getSessionAttribute(Object key) {
        return getSubject().getSession().getAttribute(key);
    }

    public static SpUser getModel() {
        return (SpUser) getSubject().getPrincipal();
    }

    public int getSpUserId() {
        return getModel().getUserId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }
}
