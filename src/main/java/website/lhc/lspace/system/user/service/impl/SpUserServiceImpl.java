package website.lhc.lspace.system.user.service.impl;

import website.lhc.lspace.system.user.entity.SpUser;
import website.lhc.lspace.system.user.mapper.SpUserMapper;
import website.lhc.lspace.system.user.service.ISpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Service
public class SpUserServiceImpl extends ServiceImpl<SpUserMapper, SpUser> implements ISpUserService {

}
