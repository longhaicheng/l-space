package website.lhc.lspace.config.security.filter;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.JwtException;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import website.lhc.lspace.commo.base.Resp;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.security.filter
 * @ClassName: ExceptionFilter
 * @Author: lhc
 * @Description: 异常过滤器，现阶段只捕获JWT相关异常
 * @Date: 2020/4/6 下午 06:33
 */
public class ExceptionFilter extends OncePerRequestFilter {

    public ExceptionFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        String msg = "";
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            if (e instanceof JwtException) {
                msg = e.getMessage();
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType(MediaType.APPLICATION_JSON.getType());
            response.getWriter().write(JSON.toJSONString(Resp.error(msg)));
            return;
        }
    }
}
