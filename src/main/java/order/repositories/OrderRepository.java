package order.repositories;

import io.smallrye.mutiny.Uni;
import order.entities.Order;

public interface OrderRepository {
    Uni<Order> save(Order order);
}
