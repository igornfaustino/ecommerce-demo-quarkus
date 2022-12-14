package order.usecases.placeOrder;

import java.util.UUID;

public class PlaceOrderOutput {
    public UUID orderId;
    public float total;

    public PlaceOrderOutput() {
    };

    public PlaceOrderOutput(UUID orderId, float total) {
        this.orderId = orderId;
        this.total = total;
    };
}
