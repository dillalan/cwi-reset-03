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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Pet> ListarPets() {
        return petService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{nome}")
    public Pet buscarPetPeloNome(@PathVariable String nome) throws PetNaoEncontradoException {
        if (petService.findByNome(nome) == null){
            throw new PetNaoEncontradoException("Pet não encontrado com o nome "+nome);
        }
        return petService.findByNome(nome);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) throws PetDuplicadoException {
        return petService.savePet(pet);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Pet atualizarPet(@RequestBody Pet pet) throws PetNaoEncontradoException {
        return petService.atualizar(pet);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws PetNaoEncontradoException {
        petService.deletePet(petService.findByNome(nome));
    }

}
