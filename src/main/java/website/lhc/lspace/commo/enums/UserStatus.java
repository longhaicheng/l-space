package website.lhc.lspace.commo.enums;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.enums
 * @ClassName: UserStatus
 * @Author: lhc
 * @Description: 用户状态枚举
 * @Date: 2020/4/1 上午 11:26
 */
public enum UserStatus {
    /**
     * 正常
     */
    ACTIVE(0),
    /**
     * 冻结
     */
    LOCKED(1),
    /**
     * 禁用
     */
    DISABLE(2);

    private int status;

    UserStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
