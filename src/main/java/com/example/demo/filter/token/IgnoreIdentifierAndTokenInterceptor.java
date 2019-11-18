package com.example.demo.filter.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interface responsible for ignoring the identifier and authorization interceptor.
 * 
 * @author cesar.fagundes
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreIdentifierAndTokenInterceptor {

}
