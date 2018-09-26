package be.laretor.carpark.controller;

import be.laretor.carpark.controller.dto.CarDetailDto;
import be.laretor.carpark.controller.dto.CarOverviewDto;
import be.laretor.carpark.controller.factory.CarDetailDtoFactory;
import be.laretor.carpark.controller.factory.CarOverviewDtoFactory;
import be.laretor.carpark.service.CarService;
import be.laretor.carpark.service.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    private final CarOverviewDtoFactory carOverviewDtoFactory;
    private final CarDetailDtoFactory carDetailDtoFactory;

    public CarController(CarService carService,
                         CarOverviewDtoFactory carOverviewDtoFactory,
                         CarDetailDtoFactory carDetailDtoFactory){
        this.carService = carService;
        this.carOverviewDtoFactory = carOverviewDtoFactory;
        this.carDetailDtoFactory = carDetailDtoFactory;
    }

    @GetMapping("/cars")
    public ResponseEntity<CarOverviewDto> getCars(){
        return ResponseEntity.ok(carOverviewDtoFactory.createFromCarList(carService.getCars()));
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDetailDto> registerCar(@RequestBody CarDetailDto carDetailDto){
        return ResponseEntity.ok(carDetailDtoFactory.createFromCar(carService.registerCar(carDetailDto)));
    }

    @GetMapping("/cars/id/{id}")
    public ResponseEntity<CarDetailDto> getCarDetail(@PathVariable("id") String id){
        Car car = carService.getCar(id);
        if (car == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carDetailDtoFactory.createFromCar(car));
    }

    @DeleteMapping("/cars/id/{id}")
    public ResponseEntity<Void> sellCar(@PathVariable("id") String id){
        carService.sellCar(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/cars/id/{id}/test")
    public ResponseEntity<CarDetailDto> testDrive(@PathVariable("id") String id,
                                          @RequestParam("miles") double miles){
        carService.testDrive(id, miles);
        return getCarDetail(id);
    }

    @PutMapping("/cars/id/{id}/repair")
    public ResponseEntity<CarDetailDto> repair(@PathVariable("id") String id){
        carService.fixCar(id);
        return getCarDetail(id);
    }

    @DeleteMapping("exit")
    public ResponseEntity<Void> exit(){
        //will not reply since it exists
        System.exit(0);
        return ResponseEntity.ok().build(); //pointless but besides the point
    }
}
