package website.lhc.lspace.system.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import website.lhc.lspace.system.role.entity.SpRole;

import java.util.Set;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
public interface SpRoleMapper extends BaseMapper<SpRole> {

    Set<String> getRoles(Integer userId);

}
