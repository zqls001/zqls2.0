package com.duanxin.zqls.web.validate;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 校验不为null
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 9:20
 */
public class NotNullValidator extends ValidatorHandler<Object> implements Validator<Object> {

    private String fieldName;

    public NotNullValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean validate(ValidatorContext context, Object s) {
        if (null == s) {
            context.addError(ValidationError.create(String.format("%s不能为空", fieldName))
                    .setErrorCode(-1)
                    .setField(fieldName)
                    .setInvalidValue(s));

            return false;
        }

        return true;
    }
}
