package be.laretor.carpark.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDetailDto {

    private final String id;
    private final String brand;
    private final String type;
    private final double price;
    private final double mileage;
    private final double currentFuel;
    private final double maxFuel;
    private final double fuelEconomy;
    private final boolean broken;

    private CarDetailDto(String id, String brand, String type, double price, double mileage, double currentFuel, double maxFuel, double fuelEconomy, boolean broken) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.mileage = mileage;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
        this.fuelEconomy = fuelEconomy;
        this.broken = broken;
    }

    @JsonCreator
    public static CarDetailDto create(@JsonProperty("id") String id,
                         @JsonProperty("brand") String brand,
                         @JsonProperty("type") String type,
                         @JsonProperty("price") double price,
                         @JsonProperty("mileage") double mileage,
                         @JsonProperty("currentFuel") double currentFuel,
                         @JsonProperty("maxFuel") double maxFuel,
                         @JsonProperty("fuelEconomy") double fuelEconomy,
                         @JsonProperty("broken") boolean broken){
        return new CarDetailDto(id,
                brand,
                type,
                price,
                mileage,
                currentFuel,
                maxFuel,
                fuelEconomy,
                broken);
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

    public double getMileage() {
        return mileage;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public double getFuelEconomy() {
        return fuelEconomy;
    }

    public boolean isBroken() {
        return broken;
    }
}
