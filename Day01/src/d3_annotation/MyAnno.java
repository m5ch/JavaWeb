package d3_annotation;

/**
 * @ Classname MyAnno
 * @ Description TODO
 * @ Date 2022/5/7 19:46
 * @ Created by 落尘
 */
public @interface MyAnno {
    int age = 0;

    String name = null;

    String show();

    String run() default "很快啊";


}
