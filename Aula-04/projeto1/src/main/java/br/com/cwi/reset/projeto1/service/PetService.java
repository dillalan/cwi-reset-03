package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetDuplicadoException;
import br.com.cwi.reset.projeto1.exception.PetNaoEncontradoException;
import br.com.cwi.reset.projeto1.repository.PetsRepository;
import br.com.cwi.reset.projeto1.repository.PetsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetService {

    @Autowired
    private PetsRepository petsRepository;
    
    public Pet cadastrarPet(Pet pet) throws PetDuplicadoException {
        Pet petExistente = petsRepository.buscarPetPeloNome(pet.getNome());
        if (petExistente!=null){
            throw new PetDuplicadoException("Pet com o nome "+pet.getNome()+"já está cadastrado.");
        }
        return petsRepository.cadastrarPet(pet);
    }
    
    public List<Pet> listarPets(){
        return petsRepository.listarPets();
    }
    
    public Pet buscarPetPeloNome(String nome) throws PetNaoEncontradoException {
        Pet petExistente = petsRepository.buscarPetPeloNome(nome);
        if (petExistente == null){
            throw new PetNaoEncontradoException("Pet não com o nome "+nome+" não foi encontrado.");
        }
        return petsRepository.buscarPetPeloNome(nome);
    }
    
    public Pet atualizarPet(Pet pet) throws PetNaoEncontradoException {
        Pet petExistente = petsRepository.buscarPetPeloNome(pet.getNome());

        if (petExistente == null) {
            throw new PetNaoEncontradoException("Pet com o nome " + pet.getNome() + " não existe");
        }
        return petsRepository.atualizarPet(pet);
    }
    
    public void deletarPet(String nome) throws PetNaoEncontradoException {
        Pet petExistente = petsRepository.buscarPetPeloNome(nome);
        if (petExistente == null) {
            throw new PetNaoEncontradoException("Pet com o nome " + nome + " não existe");
        }
        petsRepository.deletarPet(nome);
    }
}
