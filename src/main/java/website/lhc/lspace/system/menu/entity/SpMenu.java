package website.lhc.lspace.system.menu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import website.lhc.lspace.commo.base.AbstractToString;

import java.io.Serializable;

/**
 * <p>
 * 菜单管理表
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpMenu extends AbstractToString implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单编号
     */
    @TableId(type = IdType.AUTO)
    private Integer menuId;

    /**
     * 父编号
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 地址
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，
     * 如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型 0：目录 1：菜
     * 单 2：按钮
     */
    private Boolean type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
