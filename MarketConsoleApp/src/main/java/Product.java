import java.math.BigDecimal;
import java.rmi.server.UID;
import java.util.UUID;

public class Product {
    private String name;
    private double price;
    private Category category;
    private long count;
    private long code;
    public static long codeGenerator = 10000;
    private boolean isRemoved = false;

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }
//private String cc = UUID.randomUUID().toString();

    public Product(){
    }

    public Product(String name, double price, Category category, long count) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.count = count;
        this.code = ++codeGenerator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +"code="+ code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", count=" + count +
                '}';
    }
}