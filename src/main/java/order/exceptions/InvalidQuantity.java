package order.exceptions;

public class InvalidQuantity extends Exception {
    public InvalidQuantity() {
        super("Quantity must be positive");
    }
}
