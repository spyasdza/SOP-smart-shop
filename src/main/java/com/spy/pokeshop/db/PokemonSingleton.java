package com.spy.pokeshop.db;

import com.spy.pokeshop.model.Pokemon;

import java.io.*;
import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

public class PokemonSingleton {
    private static PokemonSingleton INSTANCE;
    private LinkedList<Pokemon> pokemonData = new LinkedList<>();

    private PokemonSingleton() {
    }

    public static PokemonSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PokemonSingleton();
        }

        return INSTANCE;
    }

    public LinkedList<Pokemon> showAllPokemon() {
        try {
            FileInputStream fi = new FileInputStream(new File("AllPokemonData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            pokemonData = (LinkedList<Pokemon>) oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pokemonData;
    }

    public LinkedList<Pokemon> showPokemonByName(String name) {
        LinkedList<Pokemon> pokemonByName = new LinkedList<>();
        try {
            FileInputStream fi = new FileInputStream(new File("AllPokemonData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            pokemonData = (LinkedList<Pokemon>) oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < pokemonData.size(); i++) {
            if (pokemonData.get(i).getName().equals(name)) {
                pokemonByName.add(pokemonData.get(i));
            }
        }
        return pokemonByName;
    }

    public Optional<Pokemon> showPokemonByUuid(UUID uuid) {
        try {
            FileInputStream fi = new FileInputStream(new File("AllPokemonData.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            pokemonData = (LinkedList<Pokemon>) oi.readObject();
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pokemonData.stream().filter(pokemon -> pokemon.getUuid().equals(uuid)).findFirst();
    }


    public void addPokemon(Pokemon pokemon) {
        UUID uuid = UUID.randomUUID();
        pokemon.setUuid(uuid);
        try {
            FileOutputStream fo = new FileOutputStream(new File("AllPokemonData.txt"));
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            pokemonData.add(pokemon);

            oo.writeObject(pokemonData);
            oo.close();
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buyPokemonById(UUID uuid) {
        try {
            FileOutputStream fo = new FileOutputStream(new File("AllPokemonData.txt"));
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            for (int i = 0; i < pokemonData.size(); i++) {
                if (pokemonData.get(i).getUuid().equals(uuid)) {
                    pokemonData.remove(i);
                    break;
                }
            }
            oo.writeObject(pokemonData);

            oo.close();
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
