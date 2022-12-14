package order;

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

    public UUID getIdItem() {
        return this.idItem;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    float getTotal() {
        return quantity * price;
    }
}
