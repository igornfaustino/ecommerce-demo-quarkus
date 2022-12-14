package order;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OrderItemTest {

    @Test
    void shouldCalculateTotat() {
        OrderItem orderItem = new OrderItem(UUID.randomUUID(), 3, 10.5f);

        float total = orderItem.getTotal();

        Assertions.assertEquals(31.5f, total);
    }
}
