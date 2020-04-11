package website.lhc.lspace.oss.qiniu;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.oss.qiniu
 * @ClassName: QiNiuServiceImpl
 * @Author: lhc
 * @Date: 2020/4/11 下午 03:31
 */
@Component
public class QiNiuService {

    @Value(value = "${oss.accessKey}")
    private String accessKey;

    @Value(value = "${oss.secretKey}")
    private String secretKey;

    @Value(value = "${oss.bucket}")
    private String bucket;

    /**
     * 生成客户端所需的文件上传token
     *
     * @return the token
     */
    public String generatorUploadToken() {

        Auth auth = Auth.create(accessKey, secretKey);
        // 上传策略配置
        StringMap policy = new StringMap();
        policy.put("callbackUrl", "http://localhost:8080/qiniu/getCallBackInfo");
        String body = "{\"bucket\":\"$(bucket)\",\"key\":\"$(key)\", \"etag\":\"$(etag)\",\"fname\":\"$(fname)\", \"fsize\":\"$(fsize)\",\"mimeType\":\"$(mimeType)\",\"year\":\"$(year)\", \"mon\":\"$(mon)\", \"day\":\"$(day)\",\"hour\":\"$(hour)\",\"min\":\"$(min)\",\"account\": \"$(x:account)\"}";
        policy.put("callbackBody", body);
        policy.put("callbackBodyType", "application/json");
        return auth.uploadToken(bucket, null, 300, policy, false);
    }
}
