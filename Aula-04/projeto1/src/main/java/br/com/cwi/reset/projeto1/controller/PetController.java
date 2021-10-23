package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetDuplicadoException;
import br.com.cwi.reset.projeto1.exception.PetNaoEncontradoException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")

public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getPet() {
        return petService.listarPets();
    }

    @GetMapping("/{nome}")
    public Pet buscarPetPeloNome(@PathVariable String nome) throws PetNaoEncontradoException {
        return petService.buscarPetPeloNome(nome);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) throws PetDuplicadoException {
        return petService.cadastrarPet(pet);
    }

    @PutMapping
    public Pet atualizarPet(@RequestBody Pet pet) throws PetNaoEncontradoException {
        return petService.atualizarPet(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws PetNaoEncontradoException {
        petService.deletarPet(nome);
    }

}
