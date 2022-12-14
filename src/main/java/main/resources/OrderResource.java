package main.resources;

import java.time.Duration;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import main.factories.FakeOrderFactories;
import order.repositories.OrderRepository;
import order.usecases.placeOrder.PlaceOrderInput;
import order.usecases.placeOrder.PlaceOrderUseCase;

@Path("/order")
public class OrderResource {
    OrderRepository orderRepository;
    PlaceOrderUseCase placeOrderUseCase;

    @Inject
    public OrderResource(FakeOrderFactories orderFactories) {
        orderRepository = orderFactories.createOrderRepository();
        placeOrderUseCase = orderFactories.creatPlaceOrderUseCase();
    }

    @GET
    public Response list() {
        return Response.ok(orderRepository.listAll().await().atMost(Duration.ofMillis(300))).build();
    }

    @POST
    public Response placeOrder(PlaceOrderInput input) throws Exception {
        return Response.ok(placeOrderUseCase.execute(input)).build();
    }
}