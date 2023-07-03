package pz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pz.entity.Car;
import pz.entity.OwnedCar;

import java.util.List;

@Repository
public interface OwnedRepository extends JpaRepository<OwnedCar, Integer> {

    @Query("SELECT ow FROM OwnedCar ow WHERE ow.car.car_id = :id")
    OwnedCar findOwnedCarCarByID(
            @Param("id") Integer id);

    @Query("SELECT ow FROM OwnedCar ow WHERE ow.user.user_id = :id")
    List<OwnedCar> showOwnedCars(
            @Param("id") Integer id);

    @Query("SELECT ow.car FROM OwnedCar ow WHERE ow.user.user_id = :id")
    List<Car> showOnlyOwnedCars(
            @Param("id") Integer id);

}
