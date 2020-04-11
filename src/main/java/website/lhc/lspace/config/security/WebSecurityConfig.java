package website.lhc.lspace.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import website.lhc.lspace.config.security.filter.ExceptionFilter;
import website.lhc.lspace.config.security.filter.TokenVerifyFilter;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.security
 * @ClassName: WebSecurityConfig
 * @Author: lhc
 * @Description: SpringSecurity配置类
 * @Date: 2020/4/5 上午 11:32
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpaceUserDetailsImpl userDetails;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 注入自定义过滤器
     *
     * @param authenticationManager authenticationManager
     * @return TokenVerifyFilter
     * @throws Exception
     */
    @Bean
    public TokenVerifyFilter tokenFilter(AuthenticationManager authenticationManager) throws Exception {
        return new TokenVerifyFilter(authenticationManagerBean());
    }

    /**
     * 用户认证
     *
     * @param auth AuthenticationManagerBuilder
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 安全配置
     *
     * @param http HttpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/sys/user/authenticate").permitAll()
                .antMatchers(HttpMethod.POST, "/sys/menu/getMenus").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
//                .addFilter(new TokenVerifyFilter(authenticationManager()))
                .addFilter(tokenFilter(authenticationManager()))

                .addFilterBefore(new ExceptionFilter(), TokenVerifyFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
