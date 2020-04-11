package website.lhc.lspace.commo.base;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.base
 * @ClassName: AbstractController
 * @Author: lhc
 * @Description: controller抽象类
 * @Date: 2020/4/10 下午 04:10
 */
public abstract class AbstractController {

    public Authentication getUse() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取账号
     *
     * @return String
     */
    public String getUserAccount() {
        return (String) getUse().getPrincipal();
    }
}
