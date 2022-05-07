package d2_reflect;

import org.junit.Test;

/**
 * @ Classname demo01
 * @ Description TODO 三种获取Class对象的方法
 * @ Date 2022/5/7 14:31
 * @ Created by 落尘
 */
public class demo01 {

    @Test
    public void fun1() throws Exception {
        /*
            1.Class.forName("...")
         */
        Class c1 = Class.forName("d2_reflect.Student");
        System.out.println(c1);
        /*
            2. 类名.class
         */
        Class c2 = Student.class;
        System.out.println(c2);

        /*
            3.对象.getClass()
         */
        Student student = new Student();
        Class c3 = student.getClass();
        System.out.println(c3);

        System.out.println("===================");
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));

    }
}
