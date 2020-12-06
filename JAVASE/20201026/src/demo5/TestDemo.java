package demo5;

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 = (Person) person.clone();
        System.out.println(person.b.book);
        System.out.println(person1.b.book);
        System.out.println("-------------------");
        person1.b.book = "水浒";
        System.out.println(person.b.book);
        System.out.println(person1.b.book);
    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 = (Person) person.clone();
        System.out.println(person.name);
        System.out.println(person1.name);
        System.out.println("-------------------");
        person1.name = "sfs";
        System.out.println(person.name);
        System.out.println(person1.name);
    }
}
class Book implements Cloneable {
    public String book = "三国";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable {
    public String name = "sss";
    public Book b = new Book();
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.b = (Book) p.b.clone();
        return p;
    }
}