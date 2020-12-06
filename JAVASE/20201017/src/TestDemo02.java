public class TestDemo02 {
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args) {
        System.out.println("cnt =" + cnt);
    }
    static{
        cnt /=3;
    };

    public static void main4(String[] args) {
        Person2 p = new Person2();
        System.out.println(p.count);//两个静态代码块按顺序只执行一次
    }

    public static void main3(String[] args) {
        Person2 p = new Person2();
        Person2 p1 = new Person2();
    }

    public static void main2(String[] args) {
        Person2 p = new Person2();
        /*Person2 p2 = new Person2("sss");
        Person2 p3 = new Person2("sss",20);*/
        System.out.println(p.toString());

    }

    public static void main1(String[] args) {
        Person2 p = new Person2();
        p.setAge(20);
        p.setName("sss");
        System.out.println(p.getAge());
        System.out.println(p.getName());
        p.func2();//调用被封装的func方法
    }
}
class Person2 {
    //只能在当前类中被访问
    private String name;
    private int age;

    //无参构造方法
    public Person2() {
        this("sss");//调用当前方法
        System.out.println("Person2()");
    }
    //有参构造方法
    public Person2(String name){
        this.name = name;
        System.out.println(name);
    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(name);
        System.out.println(age);
    }
    public static int count = 100;
    {
        System.out.println("实例代码块");
    }
    static {
        count = 99;
        System.out.println("静态代码块");//只执行一次
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    private void func() {
        System.out.println("func");
    }
    public void func2() {
        //func();
        this.func();//调用func方法
    }
    public static void func3() {
        //this.name;  静态方法不能用this
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
