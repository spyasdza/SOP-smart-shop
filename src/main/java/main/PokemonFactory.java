package main;

import java.util.ArrayList;

public class PokemonFactory {
    ArrayList<PokemonProduct> PokemonProductAll = new ArrayList<PokemonProduct>();

    public PokemonProduct addNewPokemon(int ID, String name, String type, double price){
        PokemonProduct pokemon = new PokemonProduct(ID, name, type, price);
        PokemonProductAll.add(pokemon);
        return pokemon;
    }

    public ArrayList<PokemonProduct> ShowAllPokemon(){
        return PokemonProductAll;
    }

    public ArrayList<PokemonProduct> ShowByName(String name){
        ArrayList<PokemonProduct> PokemonNameAll = new ArrayList<PokemonProduct>();

        for(int i=0; i<PokemonProductAll.size();i++){
            //System.out.println("This is loop Name " + PokemonProductAll.get(i).getName());
            //System.out.println("This is Input Name " + name);
            if(PokemonProductAll.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                PokemonNameAll.add(PokemonProductAll.get(i));
            }
        }
        return PokemonNameAll;
    }

    public void BuyId(int id){
        for(int i=0; i<PokemonProductAll.size();i++){
            if(PokemonProductAll.get(i).getID() == id){
                PokemonProductAll.remove(i);
                break;
            }
        }
    }

    public PokemonProduct ShowById(int id){
        for(int i=0; i<PokemonProductAll.size();i++){
            if(PokemonProductAll.get(i).getID() == id){
                return PokemonProductAll.get(i);
            }
        }
        return null;
    }
}
