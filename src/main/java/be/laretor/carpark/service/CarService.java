package be.laretor.carpark.service;

import be.laretor.carpark.controller.dto.CarDetailDto;
import be.laretor.carpark.service.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final List<Car> cars;

    public CarService(){
        cars = new ArrayList<>();
    }

    public Car getCar(String carId){
        int index = 0;
        while (index < cars.size() && !carId.equals(cars.get(index).getId())){
            index ++;
        }

        if (index < cars.size()){
            return cars.get(index);
        }

        return null;
    }

    public List<Car> getCars(){
        return cars;
    }

    public Car registerCar(CarDetailDto carDetailDto){
        Car car = new Car(carDetailDto.getId(),
                carDetailDto.getBrand(),
                carDetailDto.getType(),
                carDetailDto.getPrice(),
                carDetailDto.getMileage(),
                carDetailDto.getMaxFuel(),
                carDetailDto.getFuelEconomy(),
                carDetailDto.isBroken());

        cars.add(car);
        return car;
    }

    public void sellCar(String carId){
        Optional.ofNullable(getCar(carId)).ifPresent(cars::remove);
    }

    public void testDrive(String carId, double miles){
        Optional.ofNullable(getCar(carId)).ifPresent(car -> car.drive(miles));
    }

    public void fixCar(String carId){
        Optional.ofNullable(getCar(carId)).ifPresent(Car::fix);
    }

}
