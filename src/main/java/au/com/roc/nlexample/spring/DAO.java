package au.com.roc.nlexample.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * Indicated that the class is a Spring Component of type DAO
 * 
 * @author Roc 29/04/2016
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DAO
{
    /**
     * The value may indicate a suggestion for a logical component name, to be turned into a Spring bean in
     * case of an autodetected component.
     */
    String value() default "";
}
