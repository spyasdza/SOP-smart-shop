package main;

import java.util.ArrayList;
import java.util.List;

public class PokemonProduct {
    private int ID;
    private String name;
    private String type;
    private double price;


    public PokemonProduct(int ID, String name, String type, double price) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 1){
            this.name = "Unknown Pokemon Name";
        }
        else{
            this.name = name;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type.length() < 1){
            this.type = "Typeless";
        }
        else{
            this.type = type;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            this.price = 1;
        }
        else{
            this.price = price;
        }
    }

}
