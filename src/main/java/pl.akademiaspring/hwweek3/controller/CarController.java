package pl.akademiaspring.hwweek3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspring.hwweek3.model.Car;
import pl.akademiaspring.hwweek3.service.CarService;

@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService= carService;
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getCars());
        model.addAttribute("newCar", new Car());
        return "index";
    }

    @GetMapping("/cars/{id}")
    public String getCarById(@PathVariable int id, Model model) {
            Car car = carService.getCar(id);
            model.addAttribute("car", car);
        return "car-edit";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car newCar) {
        carService.addCar(newCar);
        return "redirect:/cars";
    }

    @PostMapping("/mod-car")
    public String modCar(@ModelAttribute Car car) {
        carService.modCar(car);
        return "redirect:/cars";
    }

    @DeleteMapping("/delete/{id}")
    public String removeCarById(@PathVariable long id) {
        carService.removeCar(id);
        return "redirect:/cars";
    }
}
