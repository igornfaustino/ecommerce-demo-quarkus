package item.repositories;

import java.util.Optional;
import java.util.UUID;

import io.smallrye.mutiny.Uni;
import item.entities.Item;

public interface ItemRepository {
    Uni<Optional<Item>> getItemById(UUID id);
}
