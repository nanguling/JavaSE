package demo4;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;

class Student implements Comparable<Student> {
    public int age;
    String name;
    public int score;

    public Student(int age, String name, int score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.score > o.score) {
            return 1;
        }else if (this.score < o.score) {
            return -1;
        }else {
            return 0;
        }
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(12,"张三",92);
        students[1] = new Student(32,"李四",98);
        students[2] = new Student(22,"王五",95);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
