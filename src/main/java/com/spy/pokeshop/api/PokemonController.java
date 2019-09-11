package com.spy.pokeshop.api;

import com.spy.pokeshop.db.PokemonSingleton;
import com.spy.pokeshop.model.Pokemon;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/")
@RestController
public class PokemonController {
    private PokemonSingleton pokemonData = PokemonSingleton.getInstance();

    @GetMapping("/")
    String home() {
        return "Welcome to <b>Pokemon Shop!</b><br/><br/>" +
                "To see all Pokemon: <b>'/show'</b><br/>" +
                "To add a Pokemon: <b>'/add'</b><br/>" +
                "To see Pokemon by id: <b>'/show/uuid={uuid}'</b><br/>" +
                "To see Pokemon by name: <b>'/show/name={name}'</b><br/>" +
                "To buy a Pokemon: <b>'/{uuid}'</b><br/>";
    }

    @PostMapping(path = "add")
    public void addPokemon(@RequestBody Pokemon pokemon){
        pokemonData.addPokemon(pokemon);
    }

    @GetMapping(path = "show")
    public List<Pokemon> showAllPokemon(){
        return pokemonData.showAllPokemon();
    }

    @GetMapping(path = "show/uuid={uuid}")
    public Optional<Pokemon> showPokemonByUuid(@PathVariable("uuid") UUID uuid){
        return pokemonData.showPokemonByUuid(uuid);
    }

    @GetMapping(path = "show/name={name}")
    public List<Pokemon> showPokemonByName(@PathVariable("name") String name){
        return pokemonData.showPokemonByName(name);
    }

    @DeleteMapping(path = "{uuid}")
    public void buyPokemonById(@PathVariable("uuid") UUID uuid){
        pokemonData.buyPokemonById(uuid);
    }
}
