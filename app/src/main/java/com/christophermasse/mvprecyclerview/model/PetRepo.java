package com.christophermasse.mvprecyclerview.model;

import com.christophermasse.mvprecyclerview.R;
import com.christophermasse.mvprecyclerview.model.entity.Cat;
import com.christophermasse.mvprecyclerview.model.entity.Dog;
import com.christophermasse.mvprecyclerview.model.entity.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Singleton that will server as a repository for fetching a randomly generated list of pets
 */
public class PetRepo {

    private static PetRepo sInstance;

    private List<Pet> petList;

    private static final int INITIAL_LIST_SIZE = 100;

    private static List<String> dogNames = Arrays.asList( "Max", "Fido", "Bella", "Bailey", "Sam", "Rocky", "Oliver",
            "Daisy", "Molly", "Merry", "Zoe", "Piper", "Ruby", "Spot", "Holly", "Riley", "Ginger", "Lucy", "Duke",
            "Tucker", "Murphy", "Lucky", "Winston", "Zoe", "Jake");

    private static List<String> catNames = Arrays.asList("Luna", "Nala", "George", "Max", "Milo", "Charlie", "Abby",
            "Willow", "Cleo", "Oliva", "Kiki", "Callie", "Pepper", "Smokey", "Leonard", "Jack", "Oscar", "Gracie",
            "Sophie", "Oreo", "Felix", "Biscuit", "Buttercup", "Moon", "Penny", "Sebastian");

    private static List<String> dogBreeds = Arrays.asList("Beagle", "Golden Retriever", "Dalmatian", "German Shepherd",
            "Boxer", "Bulldog", "Poodle", "Greyhound", "Husky", "Pug", "Yorkshire Terrier", "Australian Shepherd",
            "Pointer", "Rottweiler", "Alaskan Malamute");

    private static List<String> catBreeds = Arrays.asList("British Shorthair", "Ragdoll", "Persian", "Sphynx",
            "Burmese", "Exotic Shorthair", "Siamese", "Bengal", "Abyssinian", "Himalayan", "Ragamuffin", "Tonkinese",
            "Russian Blue", "Siberian", "Nebelung");

    private static List<Integer> colors = Arrays.asList(
            R.color.DarkOrange,
            R.color.Coral,
            R.color.OrangeRed,
            R.color.Crimson,
            R.color.HotPink,
            R.color.MediumSlateBlue,
            R.color.MediumTurquoise,
            R.color.MidnightBlue,
            R.color.RoyalBlue,
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
            initPetList(INITIAL_LIST_SIZE);
        }
        return petList;
    }

    private void initPetList(int numPets){
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

    private Dog generateDog(){
        Dog dog = new Dog();
        dog.setBreed(dogBreeds.get(randomInt(0, dogBreeds.size() - 1)));
        dog.setName(dogNames.get(randomInt(0, dogNames.size() -1)));
        dog.setAge(randomInt(1, Dog.MAX_AGE));
        dog.setToyColor(colors.get(randomInt(0, colors.size() -1)));
        return dog;
    }

    private Cat generateCat(){
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
