package dk.kea.spring_mvc.service;

import dk.kea.spring_mvc.model.Animal;
import dk.kea.spring_mvc.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> readAll(){
        List<Animal> animals = new ArrayList<>();
        for (Animal animal:animalRepository.readAll()){
            animals.add(animal);
        }

        return animals;
    }
}
