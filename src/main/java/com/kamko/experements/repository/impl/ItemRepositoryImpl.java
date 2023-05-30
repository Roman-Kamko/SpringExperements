package com.kamko.experements.repository.impl;

import com.kamko.experements.model.Item;
import com.kamko.experements.repository.ItemRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, Item> map = new HashMap<>();

    @Override
    public Collection<Item> getAll() {
        return Collections.unmodifiableCollection(map.values());
    }

    @Override
    public Item add(
            String name,
            String price,
            int amount,
            LocalDate manufactureDate,
            int expiration
    ) {
        Item item = new Item(
                name,
                price,
                amount,
                manufactureDate,
                expiration
        );
        map.put(item.getId(), item);
        return item;
    }

    @Override
    public Item remove(long id) {
        Item item = map.get(id);
        map.remove(id);
        return item;
    }

    @Override
    public Item find(long id) {
        return map.get(id);
    }

    @Override
    public Item update(long id,
                       String name,
                       String price,
                       int amount,
                       LocalDate manufactureDate,
                       int expiration) {
        Item item = new Item(name, price, amount, manufactureDate, expiration);
        map.put(id, item);
        return item;
    }
}
