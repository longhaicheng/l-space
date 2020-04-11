package website.lhc.lspace.commo.exception.commo;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.exception.commo
 * @ClassName: TokenException
 * @Author: lhc
 * @Description: jjwt相关异常
 * @Date: 2020/4/10 上午 10:22
 * @see io.jsonwebtoken.JwtException
 */
public class TokenException extends CommoException {
    private static final long serialVersionUID = 1L;

    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
