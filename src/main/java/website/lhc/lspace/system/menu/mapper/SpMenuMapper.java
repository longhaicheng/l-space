package website.lhc.lspace.system.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import website.lhc.lspace.system.menu.entity.SpMenu;

import java.util.Set;

/**
 * <p>
 * 菜单管理表
 Mapper 接口
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
public interface SpMenuMapper extends BaseMapper<SpMenu> {

    Set<String> listPermissionByUserId(Integer userId);

    Set<String> listPermissionByUserAccount(String userAccount);
}
