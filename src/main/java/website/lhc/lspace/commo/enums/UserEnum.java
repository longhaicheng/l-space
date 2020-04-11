package website.lhc.lspace.commo.enums;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.enums
 * @ClassName: UserEnums
 * @Author: lhc
 * @Description: 用户角色枚举
 * @Date: 2020/4/2 下午 02:47
 */
public enum UserEnum {

    /**
     * 超级管理员
     */
    ADMIN(1),

    /**
     * 普通用户
     */
    COMMO(2);

    private Integer userId;


    UserEnum(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
