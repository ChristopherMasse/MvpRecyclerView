package com.christophermasse.mvprecyclerview.model;

import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.model.entity.Cat;
import com.christophermasse.mvprecyclerview.model.entity.Dog;
import com.christophermasse.mvprecyclerview.model.entity.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PetRepo {

    private static PetRepo sInstance;

    private List<Pet> petList;
    private static List<String> dogNames = Arrays.asList( "Max", "Fido", "Bella", "Bailey", "Sam", "Rocky", "Oliver", "Daisy", "Molly", "Merry",
            "Zoe", "Piper", "Ruby", "Spot");

    private static List<String> catNames = Arrays.asList("Luna", "Nala", "George", "Max", "Milo", "Charlie", "Abby", "Willow", "Cleo", "Oliva",
    "Kiki", "Callie", "Pepper", "Smokey", "Leonard");

    private static List<String> dogBreeds = Arrays.asList("Beagle", "Golden Retriever", "Dalmatian", "German Shepherd");

    private static List<String> catBreeds = Arrays.asList("British Shorthair", "Ragdoll", "Persian", "Sphynx", "Burmese", "Exotic Shorthair", "Siamese");

    private static List<Integer> colors = Arrays.asList(
            R.color.DarkOrange,
            R.color.Coral,
            R.color.OrangeRed,
            R.color.Crimson,
            R.color.MediumSlateBlue,
            R.color.MediumTurquoise,
            R.color.OliveDrab,
            R.color.SaddleBrown,
            R.color.SteelBlue,
            R.color.DarkSlateGray,
            R.color.ForestGreen,
            R.color.DodgerBlue,
            R.color.Indigo,
            R.color.MediumTurquoise,
            R.color.Gold
    );

    public static PetRepo getInstance() {
        if (sInstance == null){
            sInstance = new PetRepo();
        }
        return sInstance;
    }

    public List<Pet> getPetList(){
        if(petList  == null){
            initPetList(75);
        }
        return petList;
    }

    public void initPetList(int numPets){
        petList = new ArrayList<>();
        for (int i = 0; i < numPets; i++){
            int rand = randomInt(0, 1);
            if (rand == 0){
                petList.add(generateCat());
            } else {
                petList.add(generateDog());
            }
        }
    }

    public Dog generateDog(){
        Dog dog = new Dog();
        dog.setBreed(dogBreeds.get(randomInt(0, dogBreeds.size() - 1)));
        dog.setName(dogNames.get(randomInt(0, dogNames.size() -1)));
        dog.setAge(randomInt(1, Dog.MAX_AGE));
        dog.setToyColor(colors.get(randomInt(0, colors.size() -1)));
        return dog;
    }

    public Cat generateCat(){
        Cat cat = new Cat();
        cat.setBreed(catBreeds.get(randomInt(0, catBreeds.size() - 1)));
        cat.setName(catNames.get(randomInt(0, catNames.size() - 1)));
        cat.setAge(randomInt(1, Cat.MAX_AGE));
        cat.setToyColor(colors.get(randomInt(0, colors.size() -1)));
        return cat;
    }

    private int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
