package com.kamko.experements.repository.impl;

import com.kamko.experements.exceptions.IllegalIdException;
import com.kamko.experements.exceptions.IllegalParametersException;
import com.kamko.experements.exceptions.ItemException;
import com.kamko.experements.model.Item;
import com.kamko.experements.repository.ItemRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Component
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, Item> map = new HashMap<>();

    @Override
    public Collection<Item> getAll() {
        return Collections.unmodifiableCollection(map.values());
    }

    @Override
    public Item add(String name, String price, int amount, LocalDate manufactureDate, int expiration) {
        try {
            validateParam(amount);
            validateParam(expiration);
            validatePrice(price);
        } catch (IllegalParametersException e) {
            throw new ItemException(e + " указан отрицательный параметр");
        }

        Item item = new Item(name, price, amount, manufactureDate, expiration);
        map.put(item.getId(), item);

        return item;
    }

    @Override
    public Item remove(long id) {
        try {
            validateId(id);
        } catch (IllegalIdException e) {
            throw new ItemException(e + " указан не существующий ID");
        }

        Item item = map.get(id);
        map.remove(id);

        return item;
    }

    @Override
    public Item find(long id) {
        try {
            validateId(id);
        } catch (IllegalIdException e) {
            throw new ItemException(e + " указан не существующий ID");
        }

        return map.get(id);
    }

    @Override
    public Item update(long id, String name, String price, int amount, LocalDate manufactureDate, int expiration) {
        try {
            validateId(id);
        } catch (IllegalIdException e) {
            throw new ItemException(e + " указан не существующий ID");
        }

        try {
            validateParam(amount);
            validateParam(expiration);
            validatePrice(price);
        } catch (IllegalParametersException e) {
            throw new ItemException(e + " указан отрицательный параметр");
        }

        Item item = new Item(name, price, amount, manufactureDate, expiration);
        map.put(id, item);

        return item;
    }

    private void validateParam(int num) throws IllegalParametersException {
        if (num < 0) {
            throw new IllegalParametersException();
        }
    }

    private void validatePrice(String price) throws IllegalParametersException {
        if (Long.parseLong(price) < 0) {
            throw new IllegalParametersException();
        }
    }

    private void validateId(long id) throws IllegalIdException {
        if (id < 0 || !map.containsKey(id)) {
            throw new IllegalIdException();
        }
    }
}
