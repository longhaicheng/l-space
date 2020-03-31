package website.lhc.lspace.system.setting.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统功能配置表
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配置名称
     */
    private String configName;

    /**
     * 键
     */
    private String configKey;

    /**
     * 值
     */
    private String configValue;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remark;


}
