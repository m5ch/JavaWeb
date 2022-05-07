package d3_annotation.task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ Classname CalculateTest
 * @ Description TODO
 * @ Date 2022/5/7 20:40
 * @ Created by 落尘
 */
public class CalculateTest {
    public static void main(String[] args){
        Calculate c = new Calculate();

        Class cls = c.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)){
                try {
                    System.out.println(method.getName());
                    method.invoke(c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
