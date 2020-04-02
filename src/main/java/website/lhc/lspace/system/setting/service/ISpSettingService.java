package website.lhc.lspace.system.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import website.lhc.lspace.commo.dto.SettingDto;
import website.lhc.lspace.system.setting.entity.SpSetting;

/**
 * <p>
 * 系统功能配置表 服务类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
public interface ISpSettingService extends IService<SpSetting> {
    void addSetting(SettingDto dto);
}
