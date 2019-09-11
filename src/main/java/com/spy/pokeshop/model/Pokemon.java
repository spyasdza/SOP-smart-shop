package com.spy.pokeshop.model;

import java.io.Serializable;
import java.util.UUID;

public class Pokemon implements Serializable {
    private UUID uuid;
    private String name;
    private double price;

    public Pokemon(UUID uuid, String name, double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
