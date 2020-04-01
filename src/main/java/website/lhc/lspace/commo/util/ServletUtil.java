package website.lhc.lspace.commo.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.util
 * @ClassName: ServletUtil
 * @Author: lhc
 * @Description: servlet工具类
 * @Date: 2020/4/1 上午 10:44
 */
public class ServletUtil {

    public ServletRequestAttributes getAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    public HttpServletRequest getRequest() {
        return getAttributes().getRequest();
    }

    public HttpServletResponse getResponse() {
        return getAttributes().getResponse();
    }

    public HttpSession getSession() {
        return getRequest().getSession();
    }
}
