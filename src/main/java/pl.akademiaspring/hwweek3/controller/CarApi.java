package pl.akademiaspring.hwweek3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspring.hwweek3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarApi {
    private List<Car> cars;

    public CarApi() {
        this.cars = new ArrayList<>();
        cars.add(new Car(1L, "Fiat", "Doblo", "Red"));
        cars.add(new Car(2L, "Volvo", "V90", "Grey"));
        cars.add(new Car(3L, "Ford", "Mondeo", "Red"));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        Optional<Car> first = cars.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCarsByColor(@RequestHeader String color) {
        List<Car> carsByColor = cars.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
        if (carsByColor.size() > 0) {
            return new ResponseEntity<>(carsByColor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        boolean add = cars.add(car);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity<Car> modCar(@RequestBody Car newCar) {
        Optional<Car> first = cars.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (first.isPresent()) {
            cars.remove(first.get());
            cars.add(newCar);
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> removeCarById(@PathVariable long id) {
        Optional<Car> first = cars.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            cars.remove(first.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> modFieldInCar(@PathVariable long id,
                                             @RequestParam(required = false, defaultValue = "") String mark,
                                             @RequestParam(required = false, defaultValue = "") String model,
                                             @RequestParam(required = false, defaultValue = "") String color) {
        Optional<Car> first = cars.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            if (mark != "") {
                first.get().setMark(mark);
            }

            if (model != "") {
                first.get().setMark(model);
            }

            if (color != "") {
                first.get().setMark(color);
            }
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
