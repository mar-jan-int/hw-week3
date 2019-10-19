package pl.akademiaspring.hwweek3.service;

import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek3.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static long count=3;
    private List<Car> cars;


    public CarService() {
        this.cars = new ArrayList<>();
        cars.add(new Car(1L, "Fiat", "Doblo", "red"));
        cars.add(new Car(2L, "Volvo", "V90", "grey"));
        cars.add(new Car(3L, "Ford", "Mondeo", "red"));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar(int id) {
        return cars.get(id);
    }

    public void addCar(Car newCar){
        cars.add(new Car(count++, newCar.getMark(), newCar.getModel(), newCar.getColor()));
    }
}
