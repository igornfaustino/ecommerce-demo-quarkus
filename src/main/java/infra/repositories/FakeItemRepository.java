package infra.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.smallrye.mutiny.Uni;
import item.entities.Item;
import item.repositories.ItemRepository;

public class FakeItemRepository implements ItemRepository {
    List<Item> items = new ArrayList<>();

    public FakeItemRepository() {
        items.add(new Item(UUID.fromString("fb747805-4386-4607-aded-9cdb4ea5ddb0"), "Guitar", 500));
        items.add(new Item(UUID.fromString("e7586da4-7ba2-11ed-a1eb-0242ac120002"), "Amp", 300));
    }

    @Override
    public Uni<Optional<Item>> getItemById(UUID id) {
        return Uni.createFrom().item(items.stream()
                .filter((item) -> item.getId().equals(id))
                .findFirst());
    }

}
