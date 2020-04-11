package website.lhc.lspace.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.UserRegisterDto;
import website.lhc.lspace.commo.enums.SpPostStatusEnum;
import website.lhc.lspace.commo.enums.UserEnum;
import website.lhc.lspace.commo.enums.UserStatus;
import website.lhc.lspace.commo.util.TokenUtil;
import website.lhc.lspace.system.post.entity.SpPost;
import website.lhc.lspace.system.post.mapper.SpPostMapper;
import website.lhc.lspace.system.role.mapper.UserRoleMapper;
import website.lhc.lspace.system.user.entity.SpUser;
import website.lhc.lspace.system.user.mapper.SpUserMapper;
import website.lhc.lspace.system.user.service.ISpUserService;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Service
public class SpUserServiceImpl extends ServiceImpl<SpUserMapper, SpUser> implements ISpUserService {

    private static final Logger log = LoggerFactory.getLogger(SpUserServiceImpl.class);


    /**
     * 签名有效期
     * 一小时
     */
    private static final Date EXPIRATION_TIME = new Date(System.currentTimeMillis() + 1000 * 60 * 60);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SpUserMapper userMapper;

    @Autowired
    private SpPostMapper postMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

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
        String generateToken = TokenUtil.generateToken(account, EXPIRATION_TIME);
        return Resp.ok(generateToken, EXPIRATION_TIME.getTime());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Resp register(UserRegisterDto dto) {
        // 判断是否存在同账户名
        QueryWrapper<SpUser> accountQueryWrapper = new QueryWrapper<>();
        accountQueryWrapper.eq("user_account", dto.getAccount());
        int getSameAccountUser = userMapper.selectCount(accountQueryWrapper);
        if (getSameAccountUser > 0) {
            return Resp.error("该账户名已存在");
        }

        // 判断是否存在同用户名
        QueryWrapper<SpUser> nameQueryWrapper = new QueryWrapper<>();
        nameQueryWrapper.eq("user_name", dto.getUserName());
        int getSameNameUser = userMapper.selectCount(nameQueryWrapper);
        if (getSameNameUser > 0) {
            return Resp.error("该用户名称已存在");
        }

        try {
            // 插入用户表
            SpUser insertUser = new SpUser();
            insertUser.setUserName(dto.getUserName());
            insertUser.setUserAccount(dto.getAccount());
            insertUser.setUserPasswd(dto.getPassword());
            insertUser.setPhone(dto.getPhone());
            insertUser.setCreateTime(LocalDateTime.now());
            insertUser.setStatus(UserStatus.ACTIVE.getStatus());
            userMapper.insert(insertUser);

            // 插入岗位表
            SpPost spPost = new SpPost(dto.getPostName(), SpPostStatusEnum.ACTIVE.getStatus(), "admin", LocalDateTime.now(), "无");
            postMapper.insert(spPost);

            // 插入用户角色关系表
            userRoleMapper.insertUserRole(insertUser.getUserId(), UserEnum.COMMO.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
            return Resp.error();
        }
        return Resp.ok();
    }
}
