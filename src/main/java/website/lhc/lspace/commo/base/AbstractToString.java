package website.lhc.lspace.commo.base;

import com.alibaba.fastjson.JSON;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.base
 * @ClassName: AbstractToString
 * @Author: lhc
 * @Description: 自定义所有实体类的toString()方法
 * @Date: 2020/4/5 下午 07:00
 */
public abstract class AbstractToString {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
