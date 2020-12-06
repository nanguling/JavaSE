import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        System.out.println(sb);
        sb.append("ef");
        System.out.println(sb);
    }

    public static void main3(String[] args) {
        String s = "abcdef";
        System.out.println(reverseK(s,2));
    }
    public static String reverse2(String str,int start,int end) {
        char[] chars = str.toCharArray();
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        return new String(chars);
    }
    public static String reverseK(String str,int k) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0 || k < 0 || k > len) {
            return null;
        }
        str = reverse2(str,0,k-1);
        str = reverse2(str,k,len-1);
        str = reverse2(str,0,len-1);
        //return new String(chars);
        return str;
        //return String.copyValueOf(chars);
    }

    public static void main2(String[] args) {
        String s = "hello";
        System.out.println(reverse(s));
    }
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char tmp = chars[j];
            chars[j] = chars[i];
            chars[i] = tmp;
            i++;
            j--;
        }
        //return new String(chars);
        return String.valueOf(chars);
        //return String.copyValueOf(chars);
    }

    public static void main1(String[] args) {
        String s = " hello world ";
        System.out.println(s.substring(5));
        System.out.println(s.substring(0,4));
        //去掉前后多余的空格
        System.out.println(s.trim());
        //转成大写
        System.out.println(s.toUpperCase());
        String s1 = "HELLO WORLD";
        System.out.println(s1.toLowerCase());
        //字符串拼接
        System.out.println(s1.concat("lll"));
    }
}
