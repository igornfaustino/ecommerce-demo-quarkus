package order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import item.Item;
import order.exceptions.DuplicatedItem;
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

    @Test
    void shouldThrowErrorIfItemIsDuplicated() throws Exception {
        Order order = new Order("99999999999", new Date());
        Item item = new Item(UUID.randomUUID(), "Guitarra", 500.00f);
        order.addItem(item, 1);

        assertThrows(DuplicatedItem.class, () -> {
            order.addItem(item, 2);
        });
    }

    @Test
    void shouldAddAnItem() throws Exception {
        Order order = new Order("99999999999", new Date());
        Item guitar = new Item(UUID.randomUUID(), "Guitarra", 500.00f);
        Item amp = new Item(UUID.randomUUID(), "Amplificador", 300.00f);

        order.addItem(guitar, 1);
        order.addItem(amp, 1);

        List<OrderItem> orderItem = order.getItems();
        assertEquals(2, orderItem.size());
    }

    @Test
    void shouldCalculateTotal() throws Exception {
        Order order = new Order("99999999999", new Date());
        Item guitar = new Item(UUID.randomUUID(), "Guitarra", 500.00f);
        Item amp = new Item(UUID.randomUUID(), "Amplificador", 300.00f);

        order.addItem(guitar, 1);
        order.addItem(amp, 1);

        assertEquals(800.00f, order.getTotal());
    }
}
