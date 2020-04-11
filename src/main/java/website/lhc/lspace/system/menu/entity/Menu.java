package website.lhc.lspace.system.menu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import website.lhc.lspace.commo.base.AbstractToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前台菜单表
 * </p>
 *
 * @author 龙海成
 * @since 2020-04-09
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Menu extends AbstractToString implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 地址
     */
    private String url;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 是否显示；0：显示；1：不显示
     */
    private Integer display;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private List<Menu> childMens;

    /**
     * 创建人
     */
    private String createBy;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public List<Menu> getChildMens() {
        return childMens;
    }

    public void setChildMens(List<Menu> childMens) {
        this.childMens = childMens;
    }
}
