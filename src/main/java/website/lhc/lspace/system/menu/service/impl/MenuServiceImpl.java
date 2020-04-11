package website.lhc.lspace.system.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.api.MenuDto;
import website.lhc.lspace.commo.enums.MenuEnums;
import website.lhc.lspace.system.menu.entity.Menu;
import website.lhc.lspace.system.menu.mapper.MenuMapper;
import website.lhc.lspace.system.menu.service.IMenuService;
import website.lhc.lspace.system.user.entity.SpUser;
import website.lhc.lspace.system.user.mapper.SpUserMapper;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 前台菜单表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-04-09
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private SpUserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Resp insertMenu(MenuDto dto) {
        Menu menu = new Menu();
        menu.setParentId(dto.getParentId());
        menu.setMenuName(dto.getMenuName());
        menu.setDisplay(dto.getDisplay());
        menu.setCreateTime(LocalDateTime.now());
        menu.setUrl(dto.getUrl());

        String userAccount = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QueryWrapper<SpUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name");
        queryWrapper.eq("user_account", userAccount);
        SpUser spUser = userMapper.selectOne(queryWrapper);
        if (spUser != null) {
            menu.setCreateBy(spUser.getUserName());
        }
        menuMapper.insert(menu);
        return Resp.ok();
    }

    @Override
    public Resp listMenus() {
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.select("menu_id", "parent_id", "menu_name", "url");
        menuQueryWrapper.eq("display", MenuEnums.ACTIVE.getStatus());
        menuQueryWrapper.eq("parent_id", 0);
        List<Menu> menuList = menuMapper.selectList(menuQueryWrapper);
        listChildMenu(menuList);
        return Resp.ok(menuList);
    }

    private List<Menu> listChildMenu(List<Menu> parentMenus) {
        if (CollectionUtils.isEmpty(parentMenus)) {
            return Collections.emptyList();
        }
        for (Menu parentMenu : parentMenus) {
            System.out.println(parentMenu.toString());
            QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
            menuQueryWrapper.select("menu_id", "parent_id", "menu_name", "url");
            menuQueryWrapper.eq("display", MenuEnums.ACTIVE.getStatus());
            menuQueryWrapper.eq("parent_id", parentMenu.getMenuId());
            parentMenu.setChildMens(listChildMenu(menuMapper.selectList(menuQueryWrapper)));
        }
        return parentMenus;
    }
}
