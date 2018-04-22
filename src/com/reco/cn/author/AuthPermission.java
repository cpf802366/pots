package com.reco.cn.author;

import java.lang.annotation.*;

/**
 * Created by cpf on 2018/4/22.
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPermission {
    //是否要进行权限验证 true是，false 不需要
    boolean validate() default true;
}
