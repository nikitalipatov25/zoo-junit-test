import animals.Animals;
import animals.Bear;
import animals.Tiger;
import animals.Wolf;
import static junit.framework.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import service.AnimalCreator;
import service.ZooService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ZooTest {

    @Test
    public void saveAnimals() throws IOException {

        ArrayList<String> stringsAnimals = new ArrayList<>();

        stringsAnimals.add("Wolf, Bob1, 4, true, gray, Eurasia");
        stringsAnimals.add("Tiger, Ivan1, 4, true, yellow, Eurasia");
        stringsAnimals.add("Bear, John1, 4, true, black, North America");
        stringsAnimals.add("Bear, John1, 4, true, black, North America");

        ArrayList<Animals> animals = new ArrayList<>();

//        animals.add(new Wolf("Bob1", 4, true, "gray", "Eurasia"));
//        animals.add(new Tiger("Ivan1", 4, true, "yellow", "Eurasia"));
//        animals.add(new Bear("John1", 4, true, "black", "North America"));

        AnimalCreator.create(stringsAnimals, animals);

        assertEquals(animals, AnimalCreator.create(stringsAnimals, animals));

    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void callAnimal() {

        ArrayList<Animals> animals = new ArrayList<>();

        animals.add(new Wolf("Bob", 4, true, "gray", "Eurasia"));
        animals.add(new Tiger("Ivan", 4, true, "yellow", "Eurasia"));
        animals.add(new Bear("John", 4, true, "black", "North America"));

        systemInMock.provideLines("Bob");
        Scanner scanner = new Scanner(System.in);
        ZooService.callAnimal(animals);

    }

    @Test
    public void deleteAnimal() throws IOException {

        ArrayList<Animals> animals = new ArrayList<>();

        animals.add(new Wolf("Bob", 4, true, "gray", "Eurasia"));
        animals.add(new Tiger("Ivan", 4, true, "yellow", "Eurasia"));
        animals.add(new Bear("John", 4, true, "black", "North America"));

        systemInMock.provideLines("Bob");
        Scanner scanner = new Scanner(System.in);
        ZooService.deleteAnimal(animals);

    }

    @Test
    public void compareAnimals() {

        ArrayList<Animals> animals = new ArrayList<>();

        animals.add(new Wolf("Bob", 4, true, "gray", "Eurasia"));
        animals.add(new Tiger("Ivan", 4, true, "yellow", "Eurasia"));
        animals.add(new Bear("John", 4, true, "black", "North America"));

        systemInMock.provideLines("Bob", "Ivan");
        Scanner scanner = new Scanner(System.in);
        ZooService.equalAnimals(animals);

    }
}
