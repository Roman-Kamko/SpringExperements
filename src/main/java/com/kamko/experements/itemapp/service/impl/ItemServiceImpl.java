package com.kamko.experements.itemapp.service.impl;

import com.kamko.experements.itemapp.model.Item;
import com.kamko.experements.itemapp.repository.ItemRepository;
import com.kamko.experements.itemapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Item> getAll() {
        return repository.getAll();
    }

    @Override
    public Item add(
            String name,
            String price,
            int amount,
            LocalDate manufactureDate,
            int expiration) {
        return repository.add(
                name,
                price,
                amount,
                manufactureDate,
                expiration);
    }

    @Override
    public Item remove(long id) {
        return repository.remove(id);
    }

    @Override
    public Item find(long id) {
        return repository.find(id);
    }

    @Override
    public Item update(long id,
                       String name,
                       String price,
                       int amount,
                       LocalDate manufactureDate,
                       int expiration) {
        return repository.update(id, name, price, amount, manufactureDate, expiration);
    }

    // метод для более наглядного вывода в консоль
    @Override
    public void printAll() {
        for (Item item : repository.getAll()) {
            System.out.println(item);
        }
    }
}
