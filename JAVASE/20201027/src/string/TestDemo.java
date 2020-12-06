package string;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        String str = "hello.world.!";
        //分割
        String[] arr = str.split("\\.");
        for (String s : arr) {
            System.out.println(s);
        }
    }

    public static void main9(String[] args) {
        String str = "hellollollollollo";
        //是否包含
        System.out.println(str.contains("llo"));
        //返回下标第一次出现
        System.out.println(str.indexOf("llo",6));
        //返回下标最后一次出现
        System.out.println(str.lastIndexOf("llo",6));
        //是否从该字符串开头
        System.out.println(str.startsWith("lo",5));
        //替换
        System.out.println(str.replace("lo", "pp"));
    }

    public static void main8(String[] args) {
        String str = "Abcde";
        String str2 = "abcde";
        System.out.println(str.equals(str2));
        //忽略大小写比较
        System.out.println(str.equalsIgnoreCase(str2));
        System.out.println(str.compareTo(str2));
    }

    public static void main7(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes);
        System.out.println(str);

        String str2 = "abcde";
        byte[] bytes1 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));
    }

    public static void main6(String[] args) {
        char[] array = {'a','b','c'};
        String str = new String(array,1,2);
        System.out.println(str);

        String str2 = "asdad";
        char ch = str2.charAt(0);
        System.out.println(ch);
        System.out.println(str2.length());

        char[] arr = str2.toCharArray();
        System.out.println(Arrays.toString(arr));
    }

    public static void main5(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hello";
         Class cl = String.class;
         Field field = cl.getDeclaredField("value");
         field.setAccessible(true);
         char[] value = (char[])field.get(str);
         //修改value的值
        value[0] = 'H';
        System.out.println(str);
    }

    public static void main4(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1.equals(str2));
    }

    public static void main3(String[] args) {
        String str = "hello";
        String str2 = new String("hello").intern();

        System.out.println(str == str2);
    }

    public static void main2(String[] args) {
        String str = "hello";
        String str2 = new String("hello");
        System.out.println(str == str2);

        String str3 = "he" + "llo";
        System.out.println(str == str3);
        String str5 = "he";
        String str6 = str5 + "llo";
        System.out.println(str == str6);

        String str4 = new String("he") + "llo";
        System.out.println(str == str4);
    }

    public static void main1(String[] args) {
        String str = "hello";
        String str2 = new String("hello");
        char[] array = {'h','e','l','l','o'};
        String str3 = new String(array);
    }
}
