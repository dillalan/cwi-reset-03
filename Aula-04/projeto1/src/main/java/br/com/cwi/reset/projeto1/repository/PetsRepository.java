package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetsRepository {
    public List<Pet> listarPets();
    public Pet cadastrarPet(Pet pet);
    public Pet buscarPetPeloNome(String nome) ;
    public Pet atualizarPet(Pet pet);
    public void deletarPet(String nome);

}
