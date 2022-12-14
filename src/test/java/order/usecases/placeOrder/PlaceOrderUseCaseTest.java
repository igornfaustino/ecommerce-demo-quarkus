package order.usecases.placeOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import infra.repositories.FakeItemRepository;
import infra.repositories.FakeOrderRepository;
import io.quarkus.test.junit.QuarkusTest;
import order.entities.Order;
import order.repositories.OrderRepository;

@QuarkusTest
public class PlaceOrderUseCaseTest {
    PlaceOrderUseCase useCase;
    OrderRepository orderRepository;

    @BeforeEach
    void setup() {
        orderRepository = new FakeOrderRepository();
        useCase = new PlaceOrderUseCase(new FakeItemRepository(), orderRepository);
    }

    @Test
    void shouldPlaceAnOrder() throws Exception {
        Map<UUID, Integer> itemQuantity = new HashMap<>();
        itemQuantity.put(UUID.fromString("fb747805-4386-4607-aded-9cdb4ea5ddb0"), 2);
        itemQuantity.put(UUID.fromString("e7586da4-7ba2-11ed-a1eb-0242ac120002"), 1);
        PlaceOrderInput input = new PlaceOrderInput("99999999999", itemQuantity);

        PlaceOrderOutput output = useCase.execute(input);

        assertEquals(1300.00f, output.total);
        List<Order> orders = orderRepository.listAll().await().atMost(Duration.ofMillis(500));
        assertEquals(1, orders.size());
    }
}
