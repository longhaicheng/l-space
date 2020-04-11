package website.lhc.lspace.commo.exception;

/**
 * @ProjectName: myspace
 * @Package: website.lhc.space.commo.exception
 * @ClassName: SpaceException
 * @Author: lhc
 * @Description: 项目总异常，不可直接抛出
 * @Date: 2020/3/24 上午 12:10
 */
public abstract class SpaceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SpaceException() {
    }

    public SpaceException(String message) {
        super(message);
    }

    public SpaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
