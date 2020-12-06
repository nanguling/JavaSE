package demo2;

public class TestDemo {
    public static void draw(Shape shape) {
        shape.func();
    }
    public static void main(String[] args) {
        Shape shape = new Cycle();
        shape.func();
        Shape shape1 = new Flower();
        shape1.func();
        draw(new Cycle());
        Flower flower = new Flower();
        draw(flower);
    }
}
interface Shape {
    public int a = 10;
    public static final int x = 10;
    public abstract void func();
    /*default public void doSome() {

    }*/
}
class Cycle implements Shape {
    public void func() {
        System.out.println("⚪");
    }
}
class Flower implements Shape {
    @Override
    public void func() {
        System.out.println("❀");
    }
}
