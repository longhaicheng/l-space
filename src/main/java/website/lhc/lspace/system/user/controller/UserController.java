package website.lhc.lspace.system.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.LoginDto;
import website.lhc.lspace.commo.verify.ValidatorUtil;
import website.lhc.lspace.system.user.service.ISpUserService;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.system.user.controller
 * @ClassName: UserController
 * @Author: lhc
 * @Description: 用户登录
 * @Date: 2020/4/1 上午 10:11
 */
@Slf4j
@Controller
@RequestMapping(value = "/sys/user")
public class UserController {

    @Autowired
    private ISpUserService spUserService;


    @ResponseBody
    @PostMapping(value = "/login")
    public Resp login(@RequestBody LoginDto loginDto) {
        ValidatorUtil.verify(loginDto);
        return spUserService.login(loginDto.getUserAccount(), loginDto.getUserPasswd());
    }
}
