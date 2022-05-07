package d3_annotation.task;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Classname Anno
 * @ Description TODO
 * @ Date 2022/5/7 20:13
 * @ Created by 落尘
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Anno {
    String name = "";
    int age = 0;

    String className();
    String methodName();
}
