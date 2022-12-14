package main.resources;

import java.time.Duration;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import main.factories.FakeOrderFactories;
import order.repositories.OrderRepository;

@Path("/order")
public class OrderResource {
    OrderRepository orderRepository;

    @Inject
    public OrderResource(FakeOrderFactories orderFactories) {
        orderRepository = orderFactories.createOrderRepository();
    }

    @GET
    public Response list() {
        return Response.ok(orderRepository.listAll().await().atMost(Duration.ofMillis(300))).build();
    }
}
