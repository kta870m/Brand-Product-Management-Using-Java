package Entity;

public class Product {
    private String id;
    private String name;
    private String brandId;
    private double baseCost;
    private double price;
    private int quantity;
    private Status status;

    public Product(String id, String name, String brandId, double baseCost, double price,int quantity,Status status) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
        this.baseCost = baseCost;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandId='" + brandId + '\'' +
                ", baseCost=" + baseCost +
                ", price=" + price +
                ", quantity=" + quantity +
                ", status=" + status.getStatus() +
                '}';
    }
}
