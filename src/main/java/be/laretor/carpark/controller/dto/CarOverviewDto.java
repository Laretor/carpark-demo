package be.laretor.carpark.controller.dto;

import java.util.List;

public class CarOverviewDto {

    private final List<CarDto> cars;

    public CarOverviewDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
