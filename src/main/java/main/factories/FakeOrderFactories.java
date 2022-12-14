package main.factories;

import javax.enterprise.context.ApplicationScoped;

import infra.repositories.FakeItemRepository;
import infra.repositories.FakeOrderRepository;
import order.repositories.OrderRepository;
import order.usecases.placeOrder.PlaceOrderUseCase;

@ApplicationScoped
public class FakeOrderFactories {
    OrderRepository orderRepository;

    public OrderRepository createOrderRepository() {
        if (orderRepository == null)
            orderRepository = new FakeOrderRepository();
        return orderRepository;
    }

    public PlaceOrderUseCase creatPlaceOrderUseCase() {
        return new PlaceOrderUseCase(new FakeItemRepository(), createOrderRepository());
    }
}
