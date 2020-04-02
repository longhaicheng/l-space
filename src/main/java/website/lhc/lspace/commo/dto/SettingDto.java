package website.lhc.lspace.commo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.dto
 * @ClassName: SettingDto
 * @Author: lhc
 * @Description: SettingDto
 * @Date: 2020/4/2 下午 04:19
 */
@Getter
@Setter
public class SettingDto {

    @Size(min = 0, max = 10, message = "名称不合法")
    @NotBlank(message = "名称不可为空")
    private String Name;
    @Size(min = 0, max = 10, message = "键不合法")
    @NotBlank(message = "键不可为空")
    private String key;

    @Size(min = 0, max = 20, message = "值不合法")
    @NotBlank(message = "值不可为空")
    private String value;

    @Size(min = 0, max = 10, message = "备注不合法")
    private String remark;
}
