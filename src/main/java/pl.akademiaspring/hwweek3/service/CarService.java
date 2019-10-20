package pl.akademiaspring.hwweek3.service;

import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private static long count = 3;
    private List<Car> cars;


    public CarService() {
        this.cars = new ArrayList<>();
        cars.add(new Car(1L, "Fiat", "Doblo", "red"));
        cars.add(new Car(2L, "Volvo", "V90", "grey"));
        cars.add(new Car(5L, "Ford", "Mondeo", "red"));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar(int id) {
        Optional<Car> first = cars.stream().filter(car -> car.getId() == id).findFirst();
        return first.get();
    }

    public void addCar(Car newCar) {
        cars.add(new Car(++count, newCar.getMark(), newCar.getModel(), newCar.getColor()));
    }

    public void removeCar(Long id) {
        Optional<Car> first = cars.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            cars.remove(first.get());
        }
    }

    public void modCar(Car modCar) {
        for (Car car : cars) {
            if (car.getId() == modCar.getId()) {
                car.setMark(modCar.getMark());
                car.setModel(modCar.getModel());
                car.setColor(modCar.getColor());
            }
        }
    }

}
