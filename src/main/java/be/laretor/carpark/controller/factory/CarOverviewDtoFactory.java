package be.laretor.carpark.controller.factory;

import be.laretor.carpark.controller.dto.CarDto;
import be.laretor.carpark.controller.dto.CarOverviewDto;
import be.laretor.carpark.service.model.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarOverviewDtoFactory {

    public CarOverviewDto createFromCarList(List<Car> cars){
        return new CarOverviewDto(cars.stream()
                .map(car -> new CarDto(car.getId(),
                        car.getBrand(),
                        car.getType(),
                        car.getPrice()))
                .collect(Collectors.toList()));
    }
}
