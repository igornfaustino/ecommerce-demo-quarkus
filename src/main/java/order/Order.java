package order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import item.Item;
import order.exceptions.InvalidQuantity;

public class Order {
    String cpf;
    Date issuDate;
    List<OrderItem> items = new ArrayList<>();

    public Order(String cpf, Date issuDate) {
        this.cpf = cpf;
        this.issuDate = issuDate;
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

    public void addItem(Item item, int quantity) throws Exception {
        if (quantity <= 0)
            throw new InvalidQuantity();

    }
}
