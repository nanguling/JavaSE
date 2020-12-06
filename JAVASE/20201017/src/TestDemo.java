class Test {
    public int a = 10;
    public static int count = 10;
}
public class TestDemo {
    public static void main(String[] args) {

    }

    public static void main7(String[] args) {
        Test t1 = new Test();
        t1.a++;
        Test.count++;
        System.out.println(t1.a);//11
        System.out.println(Test.count);//11
        System.out.println("============");
        Test t2 = new Test();
        t2.a++;
        Test.count++;
        System.out.println(t2.a);//11
        System.out.println(Test.count);//12
    }


    public static void main6(String[] args) {
        Person p = new Person();
        p.name = "sss";
        p.age = 20;
        System.out.println(p);
    }

    public static void main5(String[] args) {
        Person p1 = new Person();
        p1.name = "sss";
        Person p2 = p1;
        System.out.println(p2.name);
    }

    public static void main4(String[] args) {
        Person p = null;
        p.name = "sss";
        System.out.println(p.name);//空指针异常
    }

    public static void main3(String[] args) {
        Person p = new Person();
        p.age = 13;
        p.name = "lisi";
        //对于静态成员变量来说，它不属于对象，属于类本身
        System.out.println(Person.count);
        Person.func();

        System.out.println(p.age);
        System.out.println(p.name);
        Person p1 = new Person();
        p.age = 20;
        p.name = "zhangsan";
        System.out.println(p.age);
        System.out.println(p.name);
    }

    public static void main2(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();

    }

    public static void main1(String[] args) {
        Person p = new Person();//对象的实例化
        System.out.println(p.name);
        System.out.println(p.age);
        p.name = "zhangsan";
        System.out.println(p.name);
        p.age = 20;
        System.out.println(p.age);
        p.eat();
    }
}
//定义一个类
class Person {
    //成员属性
    public String name;//实例成员变量
    public int age;
    public static int count;//静态成员变量,存放到方法区内存
    //对象，和final无关，存在堆内存
    public final int SIZE = 10;
    //静态的常量，存在方法区内存
    public static final int SIZE2 = 11;
    //成员方法
    public void eat() {
        System.out.println("吃饭");
    }
    public static void func() {
        System.out.println("定义一个静态的方法");
    }

    public String getName() {
        return name;
    }

    @Override//注解：重写
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}