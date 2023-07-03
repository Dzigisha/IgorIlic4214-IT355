package pz.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pz.dto.OrderDto;
import pz.dto.OwnedDto;
import pz.entity.Car;
import pz.entity.OrderCar;
import pz.entity.OwnedCar;
import pz.entity.User;
import pz.service.CarService;
import pz.service.OrderService;
import pz.service.OwnedService;
import pz.service.UserService;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    OwnedService ownedService;


    @PostMapping(path = "/addCar")//
    public ResponseEntity insertCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.insertCar(car));
    }


    //Owner
    @PostMapping("/addOwner")
    public ResponseEntity addOwner(@RequestBody OwnedDto addOwnedDto) {

        Car car = carService.getCar(addOwnedDto.getCar_id());
        User user = userService.findUser(addOwnedDto.getUser_id());

        OwnedCar pore = new OwnedCar();
        pore.setCar(car);
        pore.setUser(user);

        if (pore == null) {
            return (ResponseEntity) ResponseEntity.badRequest();
        }

        return ResponseEntity.ok(ownedService.insertOwned(pore));
    }


    @DeleteMapping ("/deleteOwner/{id}")
    public boolean deleteOwned(@PathVariable("id") Integer id) {

        System.out.println(ownedService.findOwnedByCarID(id).getOwned_id());
        ownedService.deleteById(ownedService.findOwnedByCarID(id).getOwned_id());
        return true;
    }

    @GetMapping(path = "/ownedCars/{id}")//
    public ResponseEntity getOwnedCars(@PathVariable int id) {
        return ResponseEntity.ok(ownedService.fetchAllOwned(id));
    }

/*
    @GetMapping(path = "/vlasnistvo/{id}")
    public ResponseEntity getVlasnistvo(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(carService.fetchVlasnistvo(id));
    }
*/
    //Order
    @PostMapping("/addOrder")
    public ResponseEntity addOrder (@RequestBody OrderDto por) {

        User user = userService.findUser(por.getUser_id());

        System.out.println("User id " + por.getUser_id());

        Car car = carService.getCar(por.getCar_id());

        System.out.println("Car id " + por.getCar_id());

        OrderCar pore = new OrderCar();

        pore.setCar(car);
        pore.setUser(user);

        if (pore == null) {
            return (ResponseEntity) ResponseEntity.badRequest();
        }

        return ResponseEntity.ok(orderService.insertOrder(pore));
    }

    @DeleteMapping("/deleteOrder/{id}")//
    public boolean deleteOrder(@PathVariable("id") Integer id) {

        System.out.println(orderService.findOrderByCarID(id).getOrder_id());
        orderService.deleteById(orderService.findOrderByCarID(id).getOrder_id());
        return true;
    }

    @GetMapping(path = "/orderedCars/{id}")//
    public ResponseEntity getOrderedCars(@PathVariable int id) {
        return ResponseEntity.ok(orderService.fetchAllOrdered(id));
    }

    //Other
    @PutMapping(path = "/updateCar/{id}")//
    public ResponseEntity updateCar(@PathVariable int id, @RequestBody Car car) {
        return ResponseEntity.ok(carService.updateCar(id, car));
    }





    @GetMapping(path = "/car")//
    public ResponseEntity getCars() {
        return ResponseEntity.ok(carService.fetchCars());
    }

    @GetMapping(path = "/availableCars/{id}")
    public ResponseEntity getAvailableCars(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(carService.fetchAvailableCars(id));
    }




    @GetMapping(path = "/single_car/{id}")
    public ResponseEntity getCar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(carService.getCar(id));
    }

    @DeleteMapping("/deleteCar/{id}")//
    public boolean deleteById(@PathVariable("id") Integer id) {
        carService.deleteById(id);
        return true;
    }

}
