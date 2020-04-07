package website.lhc.lspace.commo.dto;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
