package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetDuplicadoException;
import br.com.cwi.reset.projeto1.exception.PetNaoEncontradoException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    
//    public Pet cadastrarPet(Pet pet) throws PetDuplicadoException {
//        Pet petExistente = petRepository.buscarPetPeloNome(pet.getNome());
//        if (petExistente!=null){
//            throw new PetDuplicadoException("Pet com o nome "+pet.getNome()+"já está cadastrado.");
//        }
//        return petRepository.cadastrarPet(pet);
//    }
//
//    public List<Pet> listarPets(){
//        return petRepository.listarPets();
//    }
//
//    public Pet buscarPetPeloNome(String nome) throws PetNaoEncontradoException {
//        Pet petExistente = petRepository.buscarPetPeloNome(nome);
//        if (petExistente == null){
//            throw new PetNaoEncontradoException("Pet não com o nome "+nome+" não foi encontrado.");
//        }
//        return petRepository.buscarPetPeloNome(nome);
//    }
//
//    public Pet atualizarPet(Pet pet) throws PetNaoEncontradoException {
//        Pet petExistente = petRepository.buscarPetPeloNome(pet.getNome());
//
//        if (petExistente == null) {
//            throw new PetNaoEncontradoException("Pet com o nome " + pet.getNome() + " não existe");
//        }
//        return petRepository.atualizarPet(pet);
//    }
//
//    public void deletarPet(String nome) throws PetNaoEncontradoException {
//        Pet petExistente = petRepository.buscarPetPeloNome(nome);
//        if (petExistente == null) {
//            throw new PetNaoEncontradoException("Pet com o nome " + nome + " não existe");
//        }
//        petRepository.deletarPet(nome);
//    }

    public Pet findByNome(String nome){
        if (petRepository.findByNome(nome) != null){
            return petRepository.findByNome(nome);
        }
        return null;
    }

    public Pet savePet(Pet pet) throws PetDuplicadoException {
        if (findByNome(String.valueOf(pet.getNome()))==null){
            return petRepository.save(pet);
        }
        return null;
    }

    public Pet findByEspecieNome(String especieNome){
        return petRepository.findByEspecieNome(especieNome);
    }

    public void deletePet(Pet pet){
        petRepository.delete(pet);
    }


    public List<Pet> findAll() {
        return (List<Pet>) petRepository.findAll();
    }

    public Pet atualizar(Pet pet) throws PetNaoEncontradoException {
        Pet petJaCadastrado = petRepository.findByNome(pet.getNome());

        if (petJaCadastrado == null) {
            throw new PetNaoEncontradoException("Pet com o nome " + pet.getNome() + " não existe");
        }
        if (!petRepository.existsById(pet.getId())) {
            throw new PetNaoEncontradoException("Pet com o nome " + pet.getNome() + " não existe");
        }

        return petRepository.save(pet);
    }
}
