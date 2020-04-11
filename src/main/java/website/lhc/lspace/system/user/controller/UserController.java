package website.lhc.lspace.system.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.LoginDto;
import website.lhc.lspace.commo.dto.UserRegisterDto;
import website.lhc.lspace.commo.verify.ValidatorUtil;
import website.lhc.lspace.system.user.service.ISpUserService;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.system.user.controller
 * @ClassName: UserController
 * @Author: lhc
 * @Description: 用户相关，
 * @Date: 2020/4/1 上午 10:11
 */
@Controller
@RequestMapping(value = "/sys/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ISpUserService spUserService;


    /**
     * 用户认证并获取token
     *
     * @param loginDto LoginDto
     * @return Resp
     */
    @ResponseBody
    @PostMapping(value = "/authenticate")
    public Resp login(@RequestBody LoginDto loginDto) {
        ValidatorUtil.verify(loginDto);
        return spUserService.login(loginDto.getUserAccount(), loginDto.getUserPasswd());
    }

    /**
     * 用户注册
     *
     * @param registerDto registerDto
     * @return Resp
     */
    @ResponseBody
    @PostMapping(value = "/register")
    @PreAuthorize(value = "hasAnyAuthority('sys:menu:*')")
    public Resp UserRegister(@RequestBody UserRegisterDto registerDto) {
        ValidatorUtil.verify(registerDto);
        return spUserService.register(registerDto);
    }
}
