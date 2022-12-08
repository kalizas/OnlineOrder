package kg.itacademy.OnlineOrder.repository;

import kg.itacademy.OnlineOrder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
