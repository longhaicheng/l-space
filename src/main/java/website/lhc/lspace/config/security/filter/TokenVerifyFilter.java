package website.lhc.lspace.config.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import website.lhc.lspace.commo.exception.commo.TokenException;
import website.lhc.lspace.commo.util.TokenUtil;
import website.lhc.lspace.system.menu.mapper.SpMenuMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.security
 * @ClassName: SpaceFilter
 * @Author: lhc
 * @Description: token过滤器：检查token是否存在，token校验过程中的异常处理
 * @Date: 2020/4/5 下午 09:07
 */
@Component
public class TokenVerifyFilter extends BasicAuthenticationFilter {

    @Autowired
    private SpMenuMapper menuMapper;

    private static final Logger log = LoggerFactory.getLogger(TokenVerifyFilter.class);


    public TokenVerifyFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorizationHead = request.getHeader("Authorization");
        if (authorizationHead == null || !authorizationHead.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken token;
        token = getAuthentication(authorizationHead);

        SecurityContextHolder.getContext().setAuthentication(token);
        super.doFilterInternal(request, response, chain);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String requestToken) {
        if (StringUtils.hasLength(requestToken)) {
            String token = requestToken.replace("Bearer ", "");

            String account = null;
            try {
                account = TokenUtil.getSubjectFromToken(token);
            } catch (ExpiredJwtException e) {
                log.error("ExpiredJwtException:{}", e.getMessage());
                throw new TokenException("Token过期");
            } catch (JwtException e) {
                log.error("JwtException:{}", e.getMessage());
                throw new TokenException("token错误");
            }
            if (!StringUtils.hasText(account)) {
                throw new TokenException("token异常，sub为空");
            }

            List<GrantedAuthority> authorities = new ArrayList<>();
            Set<String> permissionSet = menuMapper.listPermissionByUserAccount(account);
            permissionSet.forEach(item -> {
                if (StringUtils.hasText(item)) {
                    authorities.add(new SimpleGrantedAuthority(item));
                }
            });
            if (account != null) {
                return new UsernamePasswordAuthenticationToken(account, null, authorities);
            }
        }
        return null;
    }
}
