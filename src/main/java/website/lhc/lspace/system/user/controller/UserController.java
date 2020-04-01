package website.lhc.lspace.system.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.LoginDto;
import website.lhc.lspace.commo.verify.ValidatorUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.system.user.controller
 * @ClassName: UserController
 * @Author: lhc
 * @Description: 用户登录
 * @Date: 2020/4/1 上午 10:11
 */
@RequestMapping(value = "/sys/user")
public class UserController {

    @GetMapping(value = "/login")
    public Resp login(HttpServletRequest request, HttpServletResponse response) {
        return Resp.ok("login");
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public Resp login(@RequestBody LoginDto loginDto) {
        ValidatorUtil.verify(loginDto);
        UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getUserAccount(), loginDto.getUserPasswd());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Resp.ok();
        } catch (AuthenticationException e) {
            return StringUtils.hasLength(e.getMessage()) ? Resp.error(e.getMessage()) : Resp.error("用户名或密码错误");
        }
    }
}
