package order.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import item.entities.Item;
import order.exceptions.DuplicatedItem;
import order.exceptions.InvalidQuantity;

public class Order {
    UUID id;
    String cpf;
    Date issuDate;
    List<OrderItem> items = new ArrayList<>();

    public Order(String cpf, Date issuDate) {
        this.id = UUID.randomUUID();
        this.cpf = cpf;
        this.issuDate = issuDate;
    }

    public UUID getId() {
        return id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getIssuDate() {
        return this.issuDate;
    }

    public void setIssuDate(Date issuDate) {
        this.issuDate = issuDate;
    }

    public List<OrderItem> getItems() {
        return this.items;
    }

    public void addItem(Item item, int quantity) throws InvalidQuantity, DuplicatedItem {
        if (quantity <= 0)
            throw new InvalidQuantity();
        if (isItemAlreadyOnOrder(item))
            throw new DuplicatedItem();
        OrderItem orderItem = new OrderItem(item.getId(), quantity, item.getPrice());
        items.add(orderItem);
    }

    Boolean isItemAlreadyOnOrder(Item item) {
        return items.stream().filter((orderItem) -> {
            return orderItem.idItem.equals(item.getId());
        }).findFirst().isPresent();
    }

    public float getTotal() {
        float total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
}
