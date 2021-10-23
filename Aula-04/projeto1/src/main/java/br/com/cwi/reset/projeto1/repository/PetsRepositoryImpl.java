package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetsRepositoryImpl implements PetsRepository{
    private static List<Pet> petRepository = new ArrayList<>();

    public Pet cadastrarPet(Pet pet){
        petRepository.add(pet);
        return pet;
    }

    public List<Pet> listarPets(){
        return petRepository;
    }


    public Pet buscarPetPeloNome(String nome) {
        for (Pet pet:
             petRepository) {
            if (pet.getNome().equalsIgnoreCase(nome)){
                return pet;
            }
        }
        return null;
    }

    public Pet atualizarPet(Pet pet){
        Pet petExistente = buscarPetPeloNome(pet.getNome());
        if (petExistente!=null){
            petRepository.remove(petExistente);
            petRepository.add(pet);
            return pet;
        } else {
            return null;
        }

    }

    public void deletarPet(String nome) {
        Pet petExistente = buscarPetPeloNome(nome);
        petRepository.remove(petExistente);
    }
}
