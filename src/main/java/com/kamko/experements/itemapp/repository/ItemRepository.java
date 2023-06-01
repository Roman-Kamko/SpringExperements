package com.kamko.experements.itemapp.repository;

import com.kamko.experements.itemapp.model.Item;

import java.time.LocalDate;
import java.util.Collection;

public interface ItemRepository {
    Collection<Item> getAll();

    Item add(String name,
             String price,
             int amount,
             LocalDate manufactureDate,
             int expiration);

    Item remove(long id);

    Item find(long id);

    Item update(long id,
                String name,
                String price,
                int amount,
                LocalDate manufactureDate,
                int expiration);
}
