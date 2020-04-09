package website.lhc.lspace.commo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.util
 * @ClassName: TokenUtil
 * @Author: lhc
 * @Description: token工具类
 * @Date: 2020/4/6 下午 02:44
 */
public class TokenUtil implements Serializable {
    /**
     * 密钥
     */
    private static final String KEY = "2611951083039002ba5955e-0d5a-3c81-c665-cb87f117bba3";

    /**
     * 签名算法
     */
    private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS512;

    /**
     * token类型
     */
    private static final String TYPE = "JWT";

    /**
     * 签发主题
     */
    private static final String ISSUER = "l-space";


    private static final long serialVersionUID = 1L;

    /**
     * 创建token
     *
     * @param userName userName 用户名
     * @param roleList roleList 角色
     * @return String token
     */
    public static String generateToken(String userName, Collection<? extends GrantedAuthority> roleList, Date expiration) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("typ", TYPE);
        map.put("alg", "HS512");

        Map<String, Object> info = new HashMap<>(2);
        info.put("account", userName);
        List<String> list = new ArrayList<>(roleList.size());
        for (GrantedAuthority grantedAuthority : roleList) {
            list.add(grantedAuthority.getAuthority());
        }
        info.put("role", list);
        String s = Jwts.builder()
                .setClaims(info)
                .setExpiration(expiration)
                .setId(new AlternativeJdkIdGenerator().generateId().toString())
                .setIssuedAt(new Date())
                .setIssuer(ISSUER)
                .setHeaderParams(map)
                .signWith(ALGORITHM, KEY)
                .compact();
        return s;
    }

    /**
     * 获取接收后的签名
     *
     * @param token token
     * @return Claims
     */
    public static Claims getClaimsFromToken(String token) {
        if (StringUtils.hasLength(token)) {
            return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        }
        return null;
    }

    /**
     * 获取所有人
     *
     * @param token token
     * @return String
     */
    public static String getSubjectFromToken(String token) {
        return getClaimsFromToken(token).get("account", String.class);
    }

    /**
     * token是否过期
     *
     * @param token token
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        Claims claims = getClaimsFromToken(token);
        Date date = claims.getExpiration();
        return date.before(new Date());
    }

    public static String refreshToken(String toke, Date expiration) {
        String subject = getSubjectFromToken(toke);
        if (StringUtils.hasLength(subject)) {
            Map<String, Object> map = new HashMap<>(2);
            map.put("typ", "JWT");
            map.put("alg", "HS256");
            return Jwts.builder()
                    .setSubject(subject)
                    .setExpiration(expiration)
                    .setId(new AlternativeJdkIdGenerator().generateId().toString())
                    .setIssuedAt(new Date())
                    .setIssuer(ISSUER)
                    .setHeaderParams(map)
                    .signWith(ALGORITHM, KEY)
                    .compact();
        }
        return null;
    }


}
