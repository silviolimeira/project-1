package br.com.sl.service;

import br.com.sl.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PetService {

    @Autowired
    private WebClient webClient;

    public Pet getPet(String id) {

        Mono<Pet> monoPet = this.webClient
                .method(HttpMethod.GET)
                .uri("/pet/{id}", id)
                .retrieve()
                .bodyToMono(Pet.class);

//        monoPet.subscribe(p -> {
//            System.out.println(">>> Pet: " + p);
//        });

        Pet pet = monoPet.block();

        return pet;
    }

}
