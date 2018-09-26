package be.laretor.carpark.controller.dto;

public class CarDto {

    private final String id;
    private final String brand;
    private final String type;
    private final double price;

    public CarDto(String id, String brand, String type, double price) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
