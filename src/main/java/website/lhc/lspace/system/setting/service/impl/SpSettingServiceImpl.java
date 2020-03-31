package website.lhc.lspace.system.setting.service.impl;

import website.lhc.lspace.system.setting.entity.SpSetting;
import website.lhc.lspace.system.setting.mapper.SpSettingMapper;
import website.lhc.lspace.system.setting.service.ISpSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统功能配置表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Service
public class SpSettingServiceImpl extends ServiceImpl<SpSettingMapper, SpSetting> implements ISpSettingService {

}
