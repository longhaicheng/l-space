package website.lhc.lspace.commo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.dto
 * @ClassName: LoginDto
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/1 上午 10:29
 */
@Getter
@Setter
public class LoginDto {

    @NotBlank(message = "用户名不可为空")
    private String userAccount;
    @NotBlank(message = "密码不可为空")
    private String userPasswd;
}
