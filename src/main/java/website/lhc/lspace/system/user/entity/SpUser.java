package website.lhc.lspace.system.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 账号名称
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPasswd;

    /**
     * 盐
     */
    private String salt;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户状态
     */
    private Boolean status;

    /**
     * 电子邮件
     */
    private String userMail;

    /**
     * 账户创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后一次登录时间
     */
    private LocalDateTime lastLoginTime;


}
