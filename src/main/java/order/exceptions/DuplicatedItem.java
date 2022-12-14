package order.exceptions;

public class DuplicatedItem extends Exception {
    public DuplicatedItem() {
        super("Duplicated item");
    }
}
