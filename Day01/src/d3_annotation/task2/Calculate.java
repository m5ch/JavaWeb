package d3_annotation.task2;

/**
 * @ Classname Calculate
 * @ Description TODO
 * @ Date 2022/5/7 20:37
 * @ Created by 落尘
 */
public class Calculate {
    @Check
    public void plus(){
        System.out.println(1 + 0);
    }
    @Check
    public void sub(){
        System.out.println(1 - 0);
    }
    @Check
    public void mul(){
        System.out.println(1 * 0);
    }

    @Check
    public void div(){
        System.out.println(1 / 0);
    }

    public void bug(){
        System.out.println("永无bug");
    }

}
