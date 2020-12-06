package demo3;

public class TestDemo {
    public static void func1(IRunning iRunning) {
        iRunning.run();
    }
    public static void func2(ISwimming iSwimming) {
        iSwimming.swim();
    }
    public static void func3(IFlying iFlying) {
        iFlying.fly();
    }
    public static void main(String[] args) {
        func1(new Cat("咪咪"));
        func2(new Frog("哇哇"));
        func3(new Duck("鸭鸭"));
    }
    public static void main1(String[] args) {
        Animal animal = new Duck("鸭鸭");
        IRunning iRunning = new Duck("鸭鸭");
        ISwimming iSwimming = new Duck("鸭鸭");
        IFlying iFlying = new Duck("鸭鸭");
    }
}
class C implements IB {
    @Override
    public void func() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }
}
interface IB extends IA,IC {//接口拓展
    void func2();
}
interface IA {
    void func();
}
interface IC {
    void func3();
}

//---------------------------------------------------------------
class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }
    public void run() {
        System.out.println(this.name + "正在跑");
    }
}
class Duck extends Animal implements IRunning, ISwimming, IFlying {
    public Duck(String name) {
        super(name);
    }
    @Override
    public void fly() {
        System.out.println(this.name + "正在用翅膀飞");
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在用两条腿跑");
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在漂在水上");
    }
}
class Frog extends Animal implements IRunning, ISwimming {
    public Frog(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在往前跳");
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在蹬腿游泳");
    }
}
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}
interface IFlying {
    void fly();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}