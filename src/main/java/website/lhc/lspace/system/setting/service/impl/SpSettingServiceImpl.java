package website.lhc.lspace.system.setting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import website.lhc.lspace.commo.dto.SettingDto;
import website.lhc.lspace.system.setting.entity.SpSetting;
import website.lhc.lspace.system.setting.mapper.SpSettingMapper;
import website.lhc.lspace.system.setting.service.ISpSettingService;

import java.time.LocalDateTime;

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

    @Autowired
    private SpSettingMapper settingMapper;

    @Override
    public void addSetting(SettingDto dto) {
        SpSetting s = new SpSetting();
        s.setCreateTime(LocalDateTime.now());
        s.setConfigValue(dto.getValue());
        s.setConfigName(dto.getName());
        s.setConfigKey(dto.getKey());
        s.setStatus(0);
        if (StringUtils.hasLength(dto.getRemark())) {
            s.setRemark(dto.getRemark());
        }
//        s.setCreateBy(SubjectUtil.getModel().getUserName());
        settingMapper.insert(s);
    }
}
