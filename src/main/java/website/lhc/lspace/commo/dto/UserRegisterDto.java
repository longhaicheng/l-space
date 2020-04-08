package website.lhc.lspace.commo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.dto
 * @ClassName: UserRegister
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/7 下午 02:59
 */
public class UserRegisterDto {

    @Size(min = 5, max = 20, message = "用户名输入不合规")
    @NotBlank(message = "用户名不可为空")
    private String userName;

    @Size(min = 5, max = 20, message = "账户名输入不合规")
    @NotBlank(message = "账户名不可为空")
    private String account;

    @Size(min = 5, max = 20, message = "密码输入不合规")
    @NotBlank(message = "密码不可为空")
    private String password;

    @Size(min = 2, max = 10, message = "角色名称不合规")
    @NotBlank(message = "角色名称不可为空")
    private String roleName;

    private String remarkForaRole;

    @Size(min = 1, max = 10)
    @NotBlank(message = "岗位名称不可为空")
    private String postName;

    private String remarkForPost;

    @NotBlank(message = "联系方式不可为空")
    private String phone;


    @NotBlank
    @Email
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemarkForaRole() {
        return remarkForaRole;
    }

    public void setRemarkForaRole(String remarkForaRole) {
        this.remarkForaRole = remarkForaRole;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRemarkForPost() {
        return remarkForPost;
    }

    public void setRemarkForPost(String remarkForPost) {
        this.remarkForPost = remarkForPost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
