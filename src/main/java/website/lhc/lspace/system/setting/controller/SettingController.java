package website.lhc.lspace.system.setting.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.dto.SettingDto;
import website.lhc.lspace.commo.verify.ValidatorUtil;
import website.lhc.lspace.system.setting.entity.SpSetting;
import website.lhc.lspace.system.setting.service.ISpSettingService;

import java.util.List;


/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.system.setting.controller
 * @ClassName: SettingController
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/2 下午 04:01
 */
@RestController
@RequestMapping(value = "/sys/setting")
public class SettingController {

    @Autowired
    private ISpSettingService settingService;

    @PostMapping(value = "/list")
    @RequiresPermissions(value = "sys:setting:list")
    public Resp listSetting() {
        QueryWrapper<SpSetting> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        List<SpSetting> settingList = settingService.list(queryWrapper);
        return Resp.ok(settingList);
    }


    @PostMapping(value = "/delete")
    @RequiresPermissions(value = "sys:setting:delete")
    public Resp delSetting(Integer id) {
        SpSetting setting = new SpSetting();
        setting.setId(id);
        setting.setStatus(1);
        settingService.updateById(setting);
        return Resp.ok();
    }


    @PostMapping(value = "/add")
    @RequiresPermissions(value = "sys:setting:add")
    public Resp addSetting(@RequestBody SettingDto dto) {
        ValidatorUtil.verify(dto);
        settingService.addSetting(dto);
        return Resp.ok();
    }
}
