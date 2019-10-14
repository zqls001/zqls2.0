package com.duanxin.zqls.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 校验数字大小
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 9:31
 */
public class SizeValidator extends ValidatorHandler<Integer> implements Validator<Integer> {

    private int min;

    private int max;

    private String fieldName;

    public SizeValidator(int min, int max, String fieldName) {
        this.min = min;
        this.max = max;
        this.fieldName = fieldName;
    }

    @Override
    public boolean validate(ValidatorContext context, Integer integer) {

        if (null == integer || integer.intValue() < min || integer.intValue() > max) {
            context.addError(ValidationError.create(String.format("%s必须大于%s，小于%s",
                    fieldName, min, max))
                    .setErrorCode(-1)
                    .setField(fieldName)
                    .setInvalidValue(integer));

            return false;
        }

        return true;
    }
}
