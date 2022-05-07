package d2_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ Classname demo02
 * @ Description TODO
 * @ Date 2022/5/7 17:33
 * @ Created by 落尘
 */
public class demo02 {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        Class c1 = s.getClass();

        //获取成员变量
        Field[] fields = c1.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }

        //赋值、取值
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);   //暴力反射
        name.set(s,"张三");
        System.out.println(name.get(s));


        System.out.println("===================");
        //获取方法
        Method[] methods = c1.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Method method = c1.getDeclaredMethod("study");
        method.setAccessible(true);
        method.invoke(s,args);

        System.out.println("===============================");
        //获取构造器
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        //创建构造器对象
        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructor);
        Object student = constructor.newInstance("李四",18);
        System.out.println(student);

    }
}
