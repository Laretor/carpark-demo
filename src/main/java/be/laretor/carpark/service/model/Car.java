package be.laretor.carpark.service.model;

public class Car {

    private String id;
    private String brand;
    private String type;
    private double price;
    private double mileage;
    private double currentFuel;
    private double maxFuel;
    private double fuelEconomy;
    private boolean broken;

    public Car(String id, String brand, String type, double price, double mileage, double maxFuel, double fuelEconomy, boolean broken) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.mileage = mileage;
        this.maxFuel = maxFuel;
        this.fuelEconomy = fuelEconomy;
        this.broken = broken;

        currentFuel = maxFuel;
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

    public void drive(double miles){
        mileage += miles;
        currentFuel -= (miles / 100) * fuelEconomy;
    }

    public void breakDown(){
        broken = false;
    }

    public void fix(){
        broken = true;
    }

    public double refuel(){
        double fuel = maxFuel - currentFuel;
        currentFuel = maxFuel;
        return fuel;
    }
}
