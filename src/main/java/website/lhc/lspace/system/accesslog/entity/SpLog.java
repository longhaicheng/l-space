package website.lhc.lspace.system.accesslog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author 龙海成
 * @since 2020-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志编号
     */
    @TableId(type = IdType.AUTO)
    private Integer logId;

    /**
     * 日志类型
     */
    private Boolean type;

    /**
     * 操作人员
     */
    private String userAccount;

    /**
     * 操作
     */
    private String operation;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 操作时间
     */
    private LocalDateTime createTime;


}
