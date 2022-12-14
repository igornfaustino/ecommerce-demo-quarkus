package order;

import java.util.Date;
import java.util.UUID;

public class OrderItem {
    UUID idItem;
    int quantity;
    float price;

    public OrderItem(UUID idItem, int quantity, float price) {
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
    }

    float getTotal() {
        return quantity * price;
    }
}
