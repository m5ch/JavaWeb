package d3_annotation.task;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @ Classname Test
 * @ Description TODO
 * @ Date 2022/5/7 20:15
 * @ Created by 落尘
 */
@Anno(className="d3_annotation.task.Student",methodName = "run")
public class Test {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        Class testClass = Test.class;   //获取该类的字节码文件对象

        //2. 获取注解对象
        Anno an = (Anno) testClass.getAnnotation(Anno.class);

        //3. 调用注解对象中定义的抽象方法，获取返回值
        String naem = an.className();
        String method = an.methodName();
        System.out.println(naem);
        System.out.println(method);

        Class cls = Class.forName(an.className());
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method1 = cls.getDeclaredMethod(method);

        method1.invoke(obj);


    }
}
