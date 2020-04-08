package website.lhc.lspace.commo.enums;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.enums
 * @ClassName: SpPostStatusEnum
 * @Author: lhc
 * @Description: 岗位状态枚举
 * @Date: 2020/4/7 下午 03:34
 */
public enum SpPostStatusEnum {
    /**
     * 正常
     */
    ACTIVE(0),
    /**
     * 停用
     */
    DISABLE(1);

    private Integer status;

    SpPostStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
