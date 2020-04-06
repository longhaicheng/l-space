//package website.lhc.lspace.config.security.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import website.lhc.lspace.commo.util.TokenUtil;
//import website.lhc.lspace.config.security.SpaceUserDetail;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.Collection;
//
///**
// * @ProjectName: l-space
// * @Package: website.lhc.lspace.config.security
// * @ClassName: Jwtfilter
// * @Author: lhc
// * @Description: 登录过滤器：1. 认证；2. 生成token
// * @Date: 2020/4/5 下午 06:34
// */
//@Slf4j
//public class LoginFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authenticationManager;
//
//    public LoginFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
////        super.setFilterProcessesUrl("/sys/user/login");
//    }
//
//    /**
//     * 开始认证
//     *
//     * @param request  HttpServletRequest
//     * @param response HttpServletResponse
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        JSONObject jsonObject = getRequestUser(request);
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(jsonObject.getString("username"), jsonObject.getString("password"));
//        return authenticationManager.authenticate(token);
//    }
//
//    /**
//     * 登录成功
//     *
//     * @param request    HttpServletRequest
//     * @param response   HttpServletResponse
//     * @param chain      FilterChain
//     * @param authResult Authentication
//     * @throws IOException
//     */
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
//        SpaceUserDetail userDetail = (SpaceUserDetail) authResult.getPrincipal();
//        String account = userDetail.getUserAccount();
//        Collection<? extends GrantedAuthority> list = userDetail.getAuthorities();
//        String token = TokenUtil.generateToken(account, list);
//        if (log.isDebugEnabled()) {
//           log.debug("token Claims:{}", TokenUtil.getClaimsFromToken(token));
//        }
//        JSONObject jsonObject = new JSONObject(2);
//        jsonObject.put("code", HttpStatus.OK.value());
//        jsonObject.put("token", token);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType(MediaType.APPLICATION_JSON.getType());
//        response.getWriter().write(jsonObject.toJSONString());
//    }
//
//    private JSONObject getRequestUser(HttpServletRequest request) {
//        String data = "";
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
//            String line;
//            StringBuilder stringBuilder = new StringBuilder();
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//            data = stringBuilder.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return JSON.parseObject(data);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        JSONObject jsonObject = new JSONObject(2);
//        jsonObject.put("code", HttpStatus.UNAUTHORIZED.value());
//        jsonObject.put("message", "authentication failed, reason: " + failed.getMessage());
//        response.getWriter().write(jsonObject.toJSONString());
//    }
//}
