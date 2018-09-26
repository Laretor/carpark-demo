package be.laretor.carpark.controller.factory;

import be.laretor.carpark.controller.dto.CarDetailDto;
import be.laretor.carpark.service.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarDetailDtoFactory {

    public CarDetailDto createFromCar(Car car){
        return CarDetailDto.create(car.getId(),
                car.getBrand(),
                car.getType(),
                car.getPrice(),
                car.getMileage(),
                car.getCurrentFuel(),
                car.getMaxFuel(),
                car.getFuelEconomy(),
                car.isBroken());
    }
}
