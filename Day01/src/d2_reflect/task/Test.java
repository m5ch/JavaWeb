package d2_reflect.task;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ Classname Test
 * @ Description TODO 框架类
 * @ Date 2022/5/7 18:28
 * @ Created by 落尘
 */
public class Test {
    public static void main(String[] args) throws Exception {
    /*
        前提：不能改变该类的任何代码，可以创建任意类的对象，可以执行任意方法
     */

        //1.加载配置文件
        Properties pro = new Properties();      //创建Properties对象
        ClassLoader classLoader = Test.class.getClassLoader();      //获取class目录下的配置文件
        InputStream is = classLoader.getResourceAsStream("d2_reflect/task/pro.properties");
        pro.load(is);   //加载配置文件，转换为一个集合

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进入内存
        Class cls = Class.forName(className);
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        //4.创建对象
        Object obj = cls.getDeclaredConstructor().newInstance();
        System.out.println(obj);

        //5. 获取方法对象
        Method method = cls.getDeclaredMethod(methodName);

        method.invoke(obj);

    }
}
