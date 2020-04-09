package website.lhc.lspace.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import website.lhc.lspace.commo.enums.UserStatus;
import website.lhc.lspace.system.role.mapper.SpRoleMapper;
import website.lhc.lspace.system.user.entity.SpUser;
import website.lhc.lspace.system.user.mapper.SpUserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.security
 * @ClassName: SpaceUserDetails
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/5 下午 12:09
 */
@Component
public class SpaceUserDetailsImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(SpaceUserDetailsImpl.class);


    @Autowired
    private SpUserMapper userMapper;

    @Autowired
    private SpRoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException("[username]为空");
        }

        SpUser spUser = userMapper.getUserByAccount(username);
        if (spUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (spUser.getStatus() == UserStatus.LOCKED.getStatus()) {
            throw new LockedException("账户已冻结");
        }
        if (spUser.getStatus() == UserStatus.DISABLE.getStatus()) {
            throw new DisabledException("账户已禁用");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<String> roles = roleMapper.getRoles(spUser.getUserId());
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        log.info("user:{}; roles:{}", spUser.toString(), authorities.toString());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String bCryptPassword = passwordEncoder.encode(spUser.getUserPasswd());
        return new SpaceUserDetail(spUser.getUserAccount(), bCryptPassword, spUser.getStatus(), authorities);
    }
}
