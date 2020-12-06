import javax.imageio.stream.ImageInputStream;

class MyException extends RuntimeException {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
public class TestDemo {

    public static void main2(String[] args) {
        try{
            func2(10);
        }catch (MyException e) {
            e.printStackTrace();
            System.out.println("x == 10");
        }
    }
    public static void func2(int x) throws MyException {
        if(x == 10) {
            throw new MyException("x == 10");
        }
    }

    public static void main1(String[] args) {
        try{
            System.out.println(func(10,0));;;
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("除数为0");
        }
    }
    public static double func(int x,int y) {
        if (y == 0) {
            throw new ArithmeticException("除数为0");
        }
        return x*1.0 / y;
    }
}
