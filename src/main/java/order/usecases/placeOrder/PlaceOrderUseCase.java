package order.usecases.placeOrder;

import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import item.entities.Item;
import item.repositories.ItemRepository;
import order.entities.Order;
import order.repositories.OrderRepository;

public class PlaceOrderUseCase {
    ItemRepository itemRepository;
    OrderRepository orderRepository;

    public PlaceOrderUseCase(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public PlaceOrderOutput execute(PlaceOrderInput input) throws Exception {
        Order order = new Order(input.cpf, new Date());
        for (Map.Entry<UUID, Integer> itemQuantity : input.itemQuantity.entrySet()) {
            Optional<Item> item = itemRepository.getItemById(itemQuantity.getKey()).await()
                    .atMost(Duration.ofMillis(500));
            if (item.isEmpty())
                throw new Exception("Item not found");
            order.addItem(item.get(), itemQuantity.getValue());
        }
        orderRepository.save(order);
        return new PlaceOrderOutput(order.getId(), order.getTotal());
    }
}
