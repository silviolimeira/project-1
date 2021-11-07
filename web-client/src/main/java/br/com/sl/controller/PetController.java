package br.com.sl.controller;

import br.com.sl.model.Pet;
import br.com.sl.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("/pet")
    public String getPet(Model theModel)
    {

        Pet pet = petService.getPet("1");

        System.out.println(">>> Pet: " + pet);

        theModel.addAttribute("pet", pet);

        return "helloworld";

    }

}
