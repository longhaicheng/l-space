package website.lhc.lspace.system.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.lhc.lspace.commo.base.AbstractController;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.api.MenuDto;
import website.lhc.lspace.commo.enums.MenuEnums;
import website.lhc.lspace.commo.verify.ValidatorUtil;
import website.lhc.lspace.commo.verify.group.DeleteGroup;
import website.lhc.lspace.commo.verify.group.InsertGroup;
import website.lhc.lspace.commo.verify.group.UpdateGroup;
import website.lhc.lspace.system.menu.entity.Menu;
import website.lhc.lspace.system.menu.service.IMenuService;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.system.menu.controller
 * @ClassName: MenuController
 * @Author: lhc
 * @Description: 前台菜单相关
 * @Date: 2020/4/2 下午 05:22
 */
@RestController
@RequestMapping(value = "/sys/menu")
public class MenuController extends AbstractController {

    @Autowired
    private IMenuService menuService;

    @PostMapping(value = "/add")
    @PreAuthorize(value = "hasAnyAuthority('sys:menu:add')")
    public Resp addMenu(@RequestBody MenuDto menuDto) {
        ValidatorUtil.verify(menuDto, InsertGroup.class);
        return menuService.insertMenu(menuDto);
    }

    @PostMapping(value = "/getMenus")
    public Resp getMenus() {
        return menuService.listMenus();
    }


    @PreAuthorize(value = "hasAuthority('sys:menu:alter')")
    @PostMapping(value = "/update")
    public Resp updateMenu(@RequestBody MenuDto dto) {
        ValidatorUtil.verify(dto, UpdateGroup.class);
        Menu menu = new Menu();
        menu.setMenuId(dto.getMenuId());
        menu.setUrl(dto.getUrl());
        menu.setDisplay(dto.getDisplay());
        menu.setMenuName(dto.getMenuName());
        menuService.updateById(menu);
        return Resp.ok();
    }

    @PreAuthorize(value = "hasAuthority('sys:menu:del')")
    @PostMapping(value = "/delete")
    public Resp deleteMenu(@RequestBody MenuDto dto) {
        ValidatorUtil.verify(dto, DeleteGroup.class);
        Menu menu = new Menu();
        menu.setDisplay(MenuEnums.DISABLE.getStatus());
        menu.setMenuId(dto.getMenuId());
        menuService.updateById(menu);
        return Resp.ok();
    }

}
