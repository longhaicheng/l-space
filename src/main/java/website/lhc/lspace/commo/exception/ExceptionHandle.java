package website.lhc.lspace.commo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import website.lhc.lspace.commo.base.Resp;
import website.lhc.lspace.commo.exception.commo.ConstraintNotMatchException;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.exception
 * @ClassName: ExceptionHandle
 * @Author: lhc
 * @Description: 统一异常处理
 * @Date: 2020/4/2 上午 09:28
 */
@RestControllerAdvice
public class ExceptionHandle {

    /**
     * 约束不匹配异常
     *
     * @param e ConstraintNotMatchException
     * @return Resp
     */
    @ExceptionHandler(value = {ConstraintNotMatchException.class})
    public Resp handleConstraintNotMatchException(ConstraintNotMatchException e) {
        return Resp.error(e.getMessage());
    }
}
