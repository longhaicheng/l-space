package website.lhc.lspace.commo.enums;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.enums
 * @ClassName: MenuEnums
 * @Author: lhc
 * @Description: 按钮显示枚举类
 * @Date: 2020/4/10 下午 02:26
 */
public enum MenuEnums {
    /**
     * 显示
     */
    ACTIVE(0),
    /**
     * 不显示
     */
    DISABLE(1);
    private Integer status;

    MenuEnums(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
