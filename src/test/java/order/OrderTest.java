package order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import item.Item;
import order.exceptions.InvalidQuantity;

@QuarkusTest
public class OrderTest {

    @Test
    void shouldThrowErrorIfQuantityIsNegative() {
        Order order = new Order("99999999999", new Date());

        Item item = new Item(UUID.randomUUID(), "Guitarra", 500.00f);
        Exception exception = assertThrows(InvalidQuantity.class, () -> {
            order.addItem(item, 0);
        });

        assertEquals("Quantity must be positive", exception.getMessage());
    }
}
