package pz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pz.entity.Car;
import pz.entity.OrderCar;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderCar, Integer> {

    @Query("SELECT o FROM OrderCar o WHERE o.car.car_id = :id")
    OrderCar findOrderByCarID(
            @Param("id") Integer id);

    @Query("SELECT o FROM OrderCar o WHERE o.user.user_id = :id")
    List<OrderCar> showOrderedCars(
            @Param("id") Integer id);

    @Query("SELECT o.car FROM OrderCar o WHERE o.user.user_id = :id")
    List<Car> showOnlyCars(
            @Param("id") Integer id);

}
