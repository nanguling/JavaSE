package homework;


import java.util.Arrays;
import java.util.Scanner;

class UserNameException extends RuntimeException {
    public UserNameException() {
    }

    public UserNameException(String message) {
        super(message);
    }
}
class PassWordsException extends RuntimeException {
    public PassWordsException() {
    }

    public PassWordsException(String message) {
        super(message);
    }
}

public class HomeWork {
    public static void main10(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的用户名和密码:");
        String userName = scanner.nextLine();
        String passWords = scanner.nextLine();
        try {
            func(userName,passWords);
        }catch (UserNameException e) {
            e.printStackTrace();
        }catch (PassWordsException e) {
            e.printStackTrace();
        }
    }
    public static void func(String username,String passwords) throws UserNameException,PassWordsException {
        String name = "12345678";
        String pw = "mmp321!";
        if (!username.equals(name)) {
            throw new UserNameException("用户名错误!");
        }
        if (!passwords.equals(pw)) {
            throw new PassWordsException("密码错误！");
        }
        System.out.println("登陆成功！");
    }

    public static void main8(String[] args) {
        String s = "hello";
        System.out.println(MyContains(s,"lo"));
    }
    public static boolean MyContains(String str,String hav) {
        if (str.indexOf(hav) == -1) {
            return false;
        }else {
            return true;
        }
    }

    public static void main7(String[] args) {
        String s1 = "Hello";
        String s2 = "hello";
        System.out.println(MyCompareTo(s1,s2));
    }
    public static int MyCompareTo(String str1,String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int mid = Math.min(len1,len2);
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < mid; i++) {
            char c1 = chars1[i];
            char c2 = chars2[i];
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
    }

    public static void main(String[] args) {
        String str = "sssloss";
        System.out.println(MyIndexOf(str, "lss"));
    }
    public static int MyIndexOf(String str,String sc) {
        char[] arr = sc.toCharArray();
        if (str.contains(sc)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == arr[0]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main5(String[] args) {
        String s = "helloworld";
        System.out.println(MyReplace(s,"owo","ppp"));
    }
    public static String MyReplace(String str,String get,String rep) {
        int val = str.indexOf(get);
        String str2 = str.substring(0,val-1);
        String newstr = str2 + rep + str.substring(val + rep.length(),str.length());
        return newstr;
    }

    public static void main4(String[] args) {
        String str = "hooooolooo";
        String[] a = Mysplit(str,"o");
        for (String s:a) {
            System.out.print(s);
        }
    }
    public static String[] Mysplit(String strInfo, String strSplit) {
        //计算数组大小
        int size    = 0;
        int index = 0;
        do{
            size++;
            index++;
            index = strInfo.indexOf(strSplit ,index);
        }while(index!=-1);
        String[] arrRtn    = new String[size]; //返回数组
        //给数组赋值
        int startIndex = 0;
        int endIndex     = 0;
        for(int i = 0; i < size; i++){
            endIndex = strInfo.indexOf(strSplit, startIndex);
            if(endIndex == -1) {
                arrRtn[i] = strInfo.substring(startIndex);
            } else {
                arrRtn[i] = strInfo.substring(startIndex, endIndex);
            }
            startIndex = endIndex+1;
        }
        return arrRtn;
    }

    private static void testMethod(){

        System.out.println("testMethod");

    }

    public static void main3(String[] args) {

        ((HomeWork)null).testMethod();

    }

    public static boolean isAdmin(String userId){
        //该方法是转换成小写
        return userId.toLowerCase()=="admin";
    }
    public static void main2(String[] args){
        System.out.println(isAdmin("Admin"));
    }

    String str = new String("good");
    char[] ch = { 'a' , 'b' , 'c' };
    public static void main1(String args[]){
        HomeWork ex = new HomeWork();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }
}
