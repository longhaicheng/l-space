package website.lhc.lspace.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import website.lhc.lspace.commo.enums.UserEnum;
import website.lhc.lspace.commo.enums.UserStatus;
import website.lhc.lspace.commo.util.MD5Util;
import website.lhc.lspace.commo.util.RedisUtil;
import website.lhc.lspace.system.menu.service.ISpMenuService;
import website.lhc.lspace.system.role.mapper.SpRoleMapper;
import website.lhc.lspace.system.user.entity.SpUser;
import website.lhc.lspace.system.user.mapper.SpUserMapper;
import website.lhc.lspace.system.user.service.ISpUserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.shiro
 * @ClassName: UserRealm
 * @Author: lhc
 * @Description: UserRealm
 * @Date: 2020/3/31 下午 11:46
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private ISpUserService userService;

    @Autowired
    private SpUserMapper userMapper;

    @Autowired
    private SpRoleMapper roleMapper;

    @Autowired
    private ISpMenuService menuService;

    @Autowired
    private RedisUtil redisTemplate;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SpUser spUser = (SpUser) principalCollection.getPrimaryPrincipal();
        Integer userId = spUser.getUserId();


        Set<String> roles = null;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> perms = null;
        if (UserEnum.ADMIN.getUserId().equals(userId)) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        } else {
            // 其他用户获取权限
            perms = userMapper.getPermission(userId);
            roles = roleMapper.getRoles(userId);
        }

        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (!StringUtils.hasLength(perm)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
        }
        info.setRoles(roles);
        info.addStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        String passWd = "";
        if (token.getPassword() != null) {
            passWd = new String(token.getPassword());
        }
        QueryWrapper<SpUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", userName);
        SpUser user = userService.getOne(queryWrapper);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        if (UserStatus.LOCKED.getStatus() == user.getStatus()) {
            throw new LockedAccountException("账户被冻结");
        }

        if (UserStatus.DISABLE.getStatus() == user.getStatus()) {
            throw new DisabledAccountException("账户被禁用");
        }

        // 限制登录次数 3次
        validate(user, passWd);
        return new SimpleAuthenticationInfo(user, passWd, getName());
    }

    /**
     * 密码匹配
     *
     * @param passWordFromDb
     * @param passwd
     * @param salt
     * @return
     */
    public boolean matchPassword(String passWordFromDb, String passwd, String salt) {
        return passWordFromDb.equals(MD5Util.encryptPassWord(passwd, salt));
    }

    /**
     * 密码输错三次即冻结账户
     *
     * @param user   user
     * @param passWd passwd
     */
    private void validate(SpUser user, String passWd) {
        Object count = redisTemplate.get(user.getUserAccount());

        if (count == null) {
            redisTemplate.set(user.getUserAccount(), 0);
            if (!matchPassword(user.getUserPasswd(), passWd, user.getSalt())) {
                throw new IncorrectCredentialsException("用户名或密码错误");
            } else {
                redisTemplate.del(user.getUserAccount());
            }
        } else {
            redisTemplate.increment(user.getUserAccount());
            if ((int) count == 1) {
                SpUser spUser = new SpUser();
                spUser.setUserId(user.getUserId());
                spUser.setStatus(UserStatus.LOCKED.getStatus());
                userService.updateById(spUser);
                redisTemplate.del(user.getUserAccount());
            }
            if (!matchPassword(user.getUserPasswd(), passWd, user.getSalt())) {
                throw new IncorrectCredentialsException("用户名或密码错误");
            }
        }
    }
}
