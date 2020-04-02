package website.lhc.lspace.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import website.lhc.lspace.system.user.entity.SpUser;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
public interface SpUserMapper extends BaseMapper<SpUser> {

    List<String> getPermission(Integer userId);


}
