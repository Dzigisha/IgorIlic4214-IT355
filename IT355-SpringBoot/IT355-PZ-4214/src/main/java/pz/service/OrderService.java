package pz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pz.entity.OrderCar;
import pz.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service()
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderCar insertOrder(OrderCar por) {
        return orderRepository.save(por);
    }

    public OrderCar findOrder(int id) {

        Optional<OrderCar> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

    public OrderCar findOrderByCarID(int id) {

        Optional<OrderCar> order = Optional.ofNullable(orderRepository.findOrderByCarID(id));
        if (order.isPresent()) {
            return order.get();
        }
        return null;
    }

public void deleteById(int id) {
    orderRepository.deleteById(id);
}

    public List<OrderCar> fetchAllOrdered(int user_id) {
        return orderRepository.showOrderedCars(user_id);
    }
}
