package d3_annotation;

/**
 * @ Classname demo01
 * @ Description TODO JDK中预定义的注解
 * @ Date 2022/5/7 19:21
 * @ Created by 落尘
 */

//@SuppressWarnings 压制警告
@SuppressWarnings("all")
public class demo01 {
    //@Override 方法重写
    @Override
    public String toString() {
        return super.toString();
    }

    //Deprecated 方法过时
    @Deprecated
    public void show1(){
        //有缺陷
    }

    public void show2(){
        //替代show1方法
    }
}
