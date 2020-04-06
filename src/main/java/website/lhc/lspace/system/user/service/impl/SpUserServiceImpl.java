package website.lhc.lspace.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.util.TokenUtil;
import website.lhc.lspace.system.role.mapper.SpRoleMapper;
import website.lhc.lspace.system.user.entity.SpUser;
import website.lhc.lspace.system.user.mapper.SpUserMapper;
import website.lhc.lspace.system.user.service.ISpUserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Slf4j
@Service
public class SpUserServiceImpl extends ServiceImpl<SpUserMapper, SpUser> implements ISpUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SpUserMapper userMapper;

    @Autowired
    private SpRoleMapper roleMapper;

    @Override
    public Resp login(String account, String passwd) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(account, passwd, null);
        try {
            authenticationManager.authenticate(token);
        } catch (BadCredentialsException e) {
            return Resp.error("用户名或密码错误");
        } catch (InternalAuthenticationServiceException e) {
            return Resp.error(e.getMessage());
        } catch (Exception e) {
            return Resp.error();
        }


        QueryWrapper<SpUser> userWrapper = new QueryWrapper<>();
        userWrapper.eq("user_account", account);
        SpUser spUser = userMapper.selectOne(userWrapper);
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<String> roles = roleMapper.getRoles(spUser.getUserId());
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        long exTime = System.currentTimeMillis() + 1000 * 60 * 3;
        Date date = new Date(exTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        String generateToken = TokenUtil.generateToken(account, authorities, date);
        return Resp.ok(generateToken, exTime);
    }
}
