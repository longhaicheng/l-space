package website.lhc.lspace.commo.verify;

import org.hibernate.validator.HibernateValidator;
import website.lhc.lspace.commo.exception.commo.ConstraintNotMatchException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.verify
 * @ClassName: ValidatorUtil
 * @Author: lhc
 * @Description: ValidatorUtil
 * @Date: 2020/4/1 上午 10:35
 */
public class ValidatorUtil {
    private static Validator initValidator() {
        // 使用HibernateValidator
        Validator validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
        return validator;
    }

    /**
     * 参数校验工具类
     *
     * @param object 对象
     * @param groups 组
     */
    public static void verify(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = initValidator().validate(object, groups);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
                String message = constraintViolation.getMessage();
                throw new ConstraintNotMatchException(message);
            }
        }
    }
}
