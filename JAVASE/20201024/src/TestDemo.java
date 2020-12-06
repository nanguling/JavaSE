import java.util.*;//导入java.util包底下所有的java文件,用谁取谁
import java.sql.*;

public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        //util和sql包下都有Date，此时可以这样导入
        java.util.Date date = new java.util.Date();
        // 得到一个毫秒级别的时间戳
        System.out.println(date.getTime());
    }
}
