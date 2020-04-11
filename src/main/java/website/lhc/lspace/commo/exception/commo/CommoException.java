package website.lhc.lspace.commo.exception.commo;


import website.lhc.lspace.commo.exception.SpaceException;

/**
 * @ProjectName: myspace
 * @Package: website.lhc.space.commo.exception.commo
 * @ClassName: CommoException
 * @Author: lhc
 * @Description: commo模块异常，不可直接抛出
 * @Date: 2020/3/24 上午 12:10
 */
public abstract class CommoException extends SpaceException {
    private static final long serialVersionUID = 1L;

    public CommoException() {
    }

    public CommoException(String message) {
        super(message);
    }

    public CommoException(String message, Throwable cause) {
        super(message, cause);
    }
}
