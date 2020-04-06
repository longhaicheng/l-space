package website.lhc.lspace.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.system.user.entity.SpUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
public interface ISpUserService extends IService<SpUser> {

    Resp login(String account, String passwd);
}
