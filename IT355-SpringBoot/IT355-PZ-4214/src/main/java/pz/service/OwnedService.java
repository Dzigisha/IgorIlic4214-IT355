package pz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pz.entity.OwnedCar;
import pz.repository.OwnedRepository;

import java.util.List;
import java.util.Optional;

@Service()
public class OwnedService {

    @Autowired
    OwnedRepository ownedRepository;

    public OwnedCar insertOwned(OwnedCar por) {
        return ownedRepository.save(por);
    }

    public OwnedCar findOrder(int id) {

        Optional<OwnedCar> order = ownedRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    public OwnedCar findOwnedByCarID(int id) {

        Optional<OwnedCar> order = Optional.ofNullable(ownedRepository.findOwnedCarCarByID(id));
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    public void deleteById(int id) {
        ownedRepository.deleteById(id);
    }

    public List<OwnedCar> fetchAllOwned(int user_id) {
        return ownedRepository.showOwnedCars(user_id);
    }
}

