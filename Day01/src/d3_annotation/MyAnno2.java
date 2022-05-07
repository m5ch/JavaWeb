package d3_annotation;

import java.lang.annotation.*;

/**
 * @ Classname MyAnno2
 * @ Description TODO
 * @ Date 2022/5/7 20:03
 * @ Created by 落尘
 */

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno2 {
}
