package com.ebuy.tax.common.annotations;

import com.ebuy.tax.common.enums.RegexEnum;

import java.lang.annotation.*;

/**
 * @author hdq
 * @date 2018/9/7 11:28
 * @desc 参数校验
 * 自定义注解，因各个接口都需要参数校验，减少代码量，紧耦合
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public  @interface Validator {

    //是否为空, 默认true可以为空， false 不能为空
    boolean isEmpty() default true;
    //最大长度
    int maxLength() default 0;
    //最小长度
    int minLength() default 0;
    //提供几种常用的正则验证
    RegexEnum regexType() default RegexEnum.NONE;
    //自定义正则验证
    String regexExpression() default "";
    //参数或者字段描述,这样能够显示友好的异常信息
    String description() default "";

}
