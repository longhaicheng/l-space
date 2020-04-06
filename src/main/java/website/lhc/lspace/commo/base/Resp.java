package website.lhc.lspace.commo.base;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.base
 * @ClassName: Resp
 * @Author: lhc
 * @Description: Resp
 * @Date: 2020/4/1 上午 10:14
 */
public class Resp extends HashMap<String, Object> {

    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";
    private static final long serialVersionUID = 1L;

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }


    public Resp() {
        put(CODE, HttpStatus.OK.value());
        put(MESSAGE, "success");
    }

    public static Resp ok() {
        return new Resp();
    }

    public static Resp ok(Object data) {
        Resp resp = new Resp();
        resp.put(DATA, data);
        return resp;
    }

    public static Resp ok(Map<String, Object> data) {
        Resp resp = new Resp();
        resp.putAll(data);
        return resp;
    }

    public static Resp error(int code, String message) {
        Resp resp = new Resp();
        resp.put(CODE, code);
        resp.put(MESSAGE, message);
        return resp;
    }

    /**
     * 针对token
     *
     * @param token      token
     * @param expiration 有效期
     * @return Resp
     */
    public static Resp ok(String token, long expiration) {
        Resp resp = new Resp();
        resp.put("token", token);
        resp.put("expiration", expiration);
        return resp;
    }

    public static Resp error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "error");
    }

    public static Resp error(String message) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);

    }
}
