package com.kamko.experements.model;

import com.kamko.experements.repository.ItemRepository;
import com.kamko.experements.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;
public class Item {
    private static long counter;
    private long id;
    private String name;
    private BigDecimal price;
    private int amount;
    private LocalDate manufactureDate;
    private int expiration;

    public Item(String name,
                String price,
                int amount,
                LocalDate manufactureDate,
                int expiration) {
        this.name = name;
        setPrice(price);
        setAmount(amount);
        this.manufactureDate = manufactureDate;
        setExpiration(expiration);
        id = ++counter;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    public void setPrice(String price) {
        BigDecimal result = new BigDecimal(price);
        checkNumByZero(result.intValue());
        this.price = result;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        checkNumByZero(amount);
        this.amount = amount;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        checkNumByZero(expiration);
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && amount == item.amount && expiration == item.expiration && Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(manufactureDate, item.manufactureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, amount, manufactureDate, expiration);
    }

    @Override
    public String toString() {
        return String.format(
                "ID %d НАИМЕНОВАНИЕ %s ЦЕНА %,.2f КОЛ-ВО %d ДАТА_ПРОИЗВОДСТВА %tF СРОК_ГОДНОСТИ %d",
                id, name, getPrice(), amount, manufactureDate, expiration
        );
    }

    private void checkNumByZero(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
