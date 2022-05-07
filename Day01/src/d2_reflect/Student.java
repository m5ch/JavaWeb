package d2_reflect;

/**
 * @ Classname Student
 * @ Description TODO
 * @ Date 2022/5/7 14:30
 * @ Created by 落尘
 */
public class Student {
    private String name;
    private int age;

    void run(){
        System.out.println(name + "跑得快~~");
    }

    private void study(){
        System.out.println(name + "学习很努力~~");
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
