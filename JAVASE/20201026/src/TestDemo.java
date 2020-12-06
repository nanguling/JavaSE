public class TestDemo {
    public void drow(Shape shape) {
        shape.func();
    }
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.drow(new Cycle());
        testDemo.drow(new Flower());
    }
}
abstract class Shape {
    public abstract void func();
}
class Cycle extends Shape {
    @Override
    public void func() {
        System.out.println("⚪");;
    }
}
class Flower extends Shape {
    @Override
    public void func() {
        System.out.println("❀");;
    }
}
abstract class A extends Shape {

}
class B extends A {
    @Override
    public void func() {

    }
}