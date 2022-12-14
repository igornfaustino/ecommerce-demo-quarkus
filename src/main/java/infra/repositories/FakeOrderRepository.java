package infra.repositories;

import java.util.ArrayList;
import java.util.List;

import io.smallrye.mutiny.Uni;
import order.entities.Order;
import order.repositories.OrderRepository;

public class FakeOrderRepository implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    @Override
    public Uni<Order> save(Order order) {
        orders.add(order);
        return Uni.createFrom().item(order);
    }

    @Override
    public Uni<List<Order>> listAll() {
        return Uni.createFrom().item(orders);
    }

}
