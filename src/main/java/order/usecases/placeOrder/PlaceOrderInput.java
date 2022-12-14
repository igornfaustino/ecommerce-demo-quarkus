package order.usecases.placeOrder;

import java.util.Map;
import java.util.UUID;

public class PlaceOrderInput {
    public String cpf;
    public Map<UUID, Integer> itemQuantity;

    public PlaceOrderInput() {
    }

    public PlaceOrderInput(String cpf, Map<UUID, Integer> itemQuantity) {
        this.cpf = cpf;
        this.itemQuantity = itemQuantity;
    }
}
