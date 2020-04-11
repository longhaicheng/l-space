package website.lhc.lspace.commo.dto.api;

import org.hibernate.validator.constraints.Range;
import website.lhc.lspace.commo.verify.group.DeleteGroup;
import website.lhc.lspace.commo.verify.group.InsertGroup;
import website.lhc.lspace.commo.verify.group.UpdateGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.dto.api
 * @ClassName: MenuDto
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/10 上午 12:11
 */
public class MenuDto {

    @NotNull(groups = {UpdateGroup.class, DeleteGroup.class})
    private Integer menuId;

    @Size(min = 2, max = 10, message = "菜单名称不合规", groups = {InsertGroup.class, UpdateGroup.class})
    @NotBlank(message = "菜单名称不可为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String menuName;

    @Range(min = 0, max = 1, groups = {InsertGroup.class})
    @NotNull(groups = {InsertGroup.class})
    private Integer parentId;

    @NotBlank(message = "地址不可为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String url;

    @Range(min = 0, max = 1, groups = {InsertGroup.class, UpdateGroup.class})
    @NotNull(groups = {InsertGroup.class, UpdateGroup.class})
    private Integer display;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
