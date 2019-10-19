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

//    @GetMapping("/{id}")
//    public String getCarById(@PathVariable int id, Model model) {
//            Car car = carService.getCar(id);
//            model.addAttribute("car", car);
//        return "car";
//    }
//
//    @GetMapping("/{color}")
////    public ResponseEntity<Car> getCarByColor(@PathVariable String color) {
////        Optional<Car> first = cars.stream().filter(car -> car.getColor().equals(color)).findFirst();
////        if (first.isPresent()) {
////            return new ResponseEntity<>(first.get(), HttpStatus.OK);
////        }
////        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////    }
//
    @PostMapping("/add")
    public String addCar(@ModelAttribute Car newCar) {
        carService.addCar(newCar);
        return "redirect:/cars";
    }
//
//    @PutMapping
//    public ResponseEntity<Car> modCar(@RequestBody Car newCar) {
//        Optional<Car> first = cars.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
//        if (first.isPresent()) {
//            cars.remove(first.get());
//            cars.add(newCar);
//            return new ResponseEntity<>(first.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
    @DeleteMapping("/delete")
    public void removeCarById(@ModelAttribute Car car) {
        Optional<Car> first = cars.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            cars.remove(first.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Car> modFieldInCar(@PathVariable long id,
//                                             @RequestParam(required = false, defaultValue = "") String mark,
//                                             @RequestParam(required = false, defaultValue = "") String model,
//                                             @RequestParam(required = false, defaultValue = "") String color) {
//        Optional<Car> first = cars.stream().filter(car -> car.getId() == id).findFirst();
//        if (first.isPresent()) {
//            if(mark != ""){
//                first.get().setMark(mark);
//            }
//
//            if(model != ""){
//                first.get().setMark(model);
//            }
//
//            if(color != "") {
//                first.get().setMark(color);
//            }
//            return new ResponseEntity<>(HttpStatus.OK);
//         }
////            return new ResponseEntity<>(HttpStatus.OK)
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
