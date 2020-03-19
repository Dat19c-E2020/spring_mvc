package dk.kea.spring_mvc.repository;

import dk.kea.spring_mvc.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {

    //collection for handling test data
    private List<Animal> animals = new ArrayList<>();

    public AnimalRepository(){
        //fill in test data
        this.animals.add(new Animal(1, "AbeNisseHval", "Husdyr"));
        this.animals.add(new Animal(2, "MotorStruds", "Havdyr"));
        this.animals.add(new Animal(3, "Kungfu Panda", "Kinesisk Panda"));
        this.animals.add(new Animal(4, "Snurre Snup", "Hare"));
    }

    public List<Animal> readAll(){
        return animals;
    }
}
