package website.lhc.lspace.system.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.api.MenuDto;
import website.lhc.lspace.system.menu.entity.Menu;

/**
 * <p>
 * 前台菜单表 服务类
 * </p>
 *
 * @author 龙海成
 * @since 2020-04-09
 */
public interface IMenuService extends IService<Menu> {

    Resp insertMenu(MenuDto dto);

    Resp listMenus();
}
