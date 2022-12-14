package order.usecases.placeOrder;

import java.util.Map;
import java.util.UUID;

public class PlaceOrderInput {
    public String cpf;
    public Map<UUID, Integer> ItemQuantity;

    public PlaceOrderInput() {
    }

    public PlaceOrderInput(String cpf, Map<UUID, Integer> ItemQuantity) {
        this.cpf = cpf;
        this.ItemQuantity = ItemQuantity;
    }
}
