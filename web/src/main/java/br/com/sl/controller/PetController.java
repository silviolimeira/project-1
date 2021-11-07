package br.com.sl.controller;

import br.com.sl.model.Pet;
import org.json.JSONObject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {

    //@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable String id) throws InterruptedException {

        Pet pet = new Pet(id, "Rex");

        JSONObject jsonObject = new JSONObject(pet);

        Thread.sleep(3000);

        return ResponseEntity.ok(pet);

    }

}

