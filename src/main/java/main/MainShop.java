package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class MainShop {
    private PokemonFactory pokemonFactory = new PokemonFactory();
    private PokemonProduct pikachu1 = pokemonFactory.addNewPokemon(1,"Pikachu","Electric",30);
    private PokemonProduct raichu2 = pokemonFactory.addNewPokemon(2,"Raichu","Electric",20);
    private PokemonProduct pikachu3 = pokemonFactory.addNewPokemon(3,"Pikachu","Electric",30);
    private PokemonProduct togepi4 = pokemonFactory.addNewPokemon(4,"Togepi","Fairy",50);
    private PokemonProduct magicarp5 = pokemonFactory.addNewPokemon(5,"Magikarp","Water",10);
    private PokemonProduct mewtwo6 = pokemonFactory.addNewPokemon(6,"Mewtwo","Psychic",999);

    public static void main(String[] args) {
        SpringApplication.run(MainShop.class, args);
    }
    @RequestMapping("/")
    String home() {
        return "Welcome to <b>Pokemon Shop!</b><br/><br/>" +
                "To see all Pokemon <b>'/view/all'</b><br/>" +
                "To see Pokemon by name: <b>'/view/Name={name}'</b><br/>" +
                "To see Pokemon by id: <b>'/view/Id={id}'</b><br/>" +
                "To buy a Pokemon: <b>'/view/Id={id}/buy'</b><br/>";
    }

    @RequestMapping("/view/all")
    ArrayList<PokemonProduct> viewAllProduct(){
        return pokemonFactory.ShowAllPokemon();
    }

    @RequestMapping(value = "/view/Name={name}", method = RequestMethod.GET)
    ArrayList<PokemonProduct> viewName(@PathVariable String name){
        return pokemonFactory.ShowByName(name);
    }

    @RequestMapping(value = "/view/Id={id}", method = RequestMethod.GET)
    PokemonProduct viewId(@PathVariable int id){
        return pokemonFactory.ShowById(id);
    }

    @RequestMapping(value = "/view/Id={id}/buy", method = RequestMethod.GET)
    String buyId(@PathVariable int id){
        pokemonFactory.BuyId(id);
        return "Purchase completed!";
    }

}