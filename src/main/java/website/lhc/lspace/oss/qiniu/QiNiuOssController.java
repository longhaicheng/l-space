package website.lhc.lspace.oss.qiniu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.lhc.lspace.commo.base.AbstractController;
import website.lhc.lspace.commo.base.Resp;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.oss
 * @ClassName: QiNiuOss
 * @Author: lhc
 * @Description: 七牛云controller;文件下载做自定义域名和文件名的拼接即可
 * @see: https://developer.qiniu.com/kodo/sdk/1239/java#upload-flow
 * @Date: 2020/4/11 下午 03:23
 */

@RestController
@RequestMapping(value = "/qiniu")
public class QiNiuOssController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(QiNiuOssController.class);

    @Autowired
    private QiNiuService qiNiuService;

    /**
     * 客户端获取凭证
     *
     * @return token
     */
    @PreAuthorize(value = "hasAuthority('sys:oss:get')")
    @PostMapping(value = "/getUploadToken")
    public Resp getUploadToken() {
        String token = qiNiuService.generatorUploadToken();
        if (log.isDebugEnabled()) {
            log.debug("token:{}", token);
        }
        return Resp.ok(token);
    }

    /**
     * 文件上传成功之后，七牛云回调接口
     *
     * @param body
     * @return
     */
    @PostMapping(value = "/getCallBackInfo")
    public Resp getCallBackInfo(@RequestBody CallBackBody body) {
        // 先做日志记录，学会了前端再做
        log.info("CallBackBody:{}", body.toString());
        return Resp.ok();
    }
}
