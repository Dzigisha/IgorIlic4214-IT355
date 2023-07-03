package pz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pz.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
