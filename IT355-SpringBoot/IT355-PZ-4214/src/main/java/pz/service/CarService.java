package pz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pz.entity.Car;
import pz.entity.User;
import pz.repository.CarRepository;
import pz.repository.OrderRepository;
import pz.repository.OwnedRepository;
import pz.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository car_repository;

    @Autowired
    UserRepository user_repository;

    @Autowired
    OrderRepository order_repository;

    @Autowired
    OwnedRepository owned_repository;

    public Car insertCar(Car car) {
        return car_repository.save(car);
    }

    public Car updateCar(int id, Car car) {
        car.setCar_id(id);
        return car_repository.save(car);
    }

    public Car getCar(int id) {
        Optional<Car> car = car_repository.findById(id);
        if (car.isPresent()) {
            return car.get();
        }
        return null;
    }

    public List<Car> fetchCars() {
        return car_repository.findAll();
    }

    public List<Car> fetchAvailableCars(Integer id) {
        List<Car> svi = car_repository.findAll();
        User user = user_repository.findById(id).get();
        List<Car> kupljena = order_repository.showOnlyCars(id);
        List<Car> vlasnikova = owned_repository.showOnlyOwnedCars(id);
        svi.removeAll(vlasnikova);
        svi.removeAll(kupljena);
        return svi;
    }

    public List<Car> fetchVlasnistvo(Integer id) {
        User user = user_repository.findById(id).get();
        List<Car> vlasnikova = owned_repository.showOnlyOwnedCars(id);
        return vlasnikova;
    }

    public void deleteById(int id) {
        car_repository.deleteById(id);
    }
}
