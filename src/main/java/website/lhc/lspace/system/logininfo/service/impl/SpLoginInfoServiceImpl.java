package website.lhc.lspace.system.logininfo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import website.lhc.lspace.system.logininfo.entity.SpLoginInfo;
import website.lhc.lspace.system.logininfo.mapper.SpLoginInfoMapper;
import website.lhc.lspace.system.logininfo.service.ISpLoginInfoService;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-04-02
 */
@Service
public class SpLoginInfoServiceImpl extends ServiceImpl<SpLoginInfoMapper, SpLoginInfo> implements ISpLoginInfoService {

}
