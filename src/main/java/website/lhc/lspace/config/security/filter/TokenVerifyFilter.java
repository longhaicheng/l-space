package website.lhc.lspace.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
import website.lhc.lspace.commo.util.TokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.security
 * @ClassName: SpaceFilter
 * @Author: lhc
 * @Description: token验证过滤器
 * @Date: 2020/4/5 下午 09:07
 */
@Slf4j
public class TokenVerifyFilter extends BasicAuthenticationFilter {
    public TokenVerifyFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorizationHead = request.getHeader("Authorization");
        if (!StringUtils.hasLength(authorizationHead) || !authorizationHead.startsWith("Bearer ")) {
            chain.doFilter(request, response);
        }
        String message = "";
        UsernamePasswordAuthenticationToken token = null;
        token = getAuthentication(authorizationHead);

        SecurityContextHolder.getContext().setAuthentication(token);
        super.doFilterInternal(request, response, chain);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (StringUtils.hasLength(token)) {
            String tokenInfo = token.replace("Bearer ", "");
            String userAccount = null;
            userAccount = TokenUtil.getSubjectFromToken(tokenInfo);
            if (userAccount != null) {
                return new UsernamePasswordAuthenticationToken(userAccount, null, null);
            }
        }
        return null;
    }
}
