package book;

//图书类
public class Book {
    private String name;//书名
    private String auther;//作者
    private double price;//价格
    private String type;//类型
    private boolean isBorrowed;//是否被借出

    public Book(String name, String auther, double price, String type) {
        this.name = name;
        this.auther = auther;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", auther='" + auther + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                (isBorrowed == false ? "未借出" : "已借出") +
                '}';
    }
}
