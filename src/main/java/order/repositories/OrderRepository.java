package order.repositories;

import java.util.List;

import io.smallrye.mutiny.Uni;
import order.entities.Order;

public interface OrderRepository {
    Uni<Order> save(Order order);

    Uni<List<Order>> listAll();
}
