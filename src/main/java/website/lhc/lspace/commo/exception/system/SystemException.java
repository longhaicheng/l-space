package website.lhc.lspace.commo.exception.system;


import website.lhc.lspace.commo.exception.SpaceException;

/**
 * @ProjectName: myspace
 * @Package: website.lhc.space.commo.exception.system
 * @ClassName: SystemException
 * @Author: lhc
 * @Description: 系统模块异常
 * @Date: 2020/3/24 上午 12:13
 */
public class SystemException extends SpaceException {

    private static final long serialVersionUID = 1L;

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
