package Annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Retention(RetentionPolicy.CLASS)
//@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PARAMETER})
@Documented
@Repeatable(Authors.class)
public @interface Author {
    String   value() default "";
    String   name();
    int      age() default 30;
    String[] nickNames();
}

@Target({ElementType.LOCAL_VARIABLE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Authors {
    Author[] value();
}
