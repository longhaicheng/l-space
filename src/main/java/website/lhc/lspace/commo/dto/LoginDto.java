package website.lhc.lspace.commo.dto;

import website.lhc.lspace.commo.base.AbstractToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.dto
 * @ClassName: LoginDto
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/1 上午 10:29
 */
public class LoginDto extends AbstractToString {

    @Size(min = 0, max = 20, message = "用户名不合法")
    @NotBlank(message = "用户名不可为空")
    private String userAccount;

    @Size(min = 0, max = 20, message = "密码不合法")
    @NotBlank(message = "密码不可为空")
    private String userPasswd;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
}
