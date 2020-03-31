package website.lhc.lspace.system.loginlog.service.impl;

import website.lhc.lspace.system.loginlog.entity.SpLoginInfo;
import website.lhc.lspace.system.loginlog.mapper.SpLoginInfoMapper;
import website.lhc.lspace.system.loginlog.service.ISpLoginInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Service
public class SpLoginInfoServiceImpl extends ServiceImpl<SpLoginInfoMapper, SpLoginInfo> implements ISpLoginInfoService {

}
