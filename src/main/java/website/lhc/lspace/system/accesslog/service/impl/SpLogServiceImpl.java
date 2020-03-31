package website.lhc.lspace.system.accesslog.service.impl;

import website.lhc.lspace.system.accesslog.entity.SpLog;
import website.lhc.lspace.system.accesslog.mapper.SpLogMapper;
import website.lhc.lspace.system.accesslog.service.ISpLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Service
public class SpLogServiceImpl extends ServiceImpl<SpLogMapper, SpLog> implements ISpLogService {

}
