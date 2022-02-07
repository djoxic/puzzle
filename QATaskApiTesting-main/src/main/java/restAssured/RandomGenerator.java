package restAssured;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public static String generateFirstName() {

        Faker generateName = new Faker();
        return generateName.name().firstName();
    }

    public static String generateLastName() {

        Faker generateName = new Faker();
        return generateName.name().lastName();
    }

    public static int generateRandomNumber(int number) {
        Random rnd = new Random();
        return rnd.nextInt(number);
    }

    public static int generateRandomNumber(int max, int min) {
        Random rnd = new Random();
        return rnd.nextInt(max-min) + min;
    }

    public static String randomItemFromList(List<String> list){
        Random rnd = new Random();
        int index = rnd.nextInt(list.size());
        return list.get(index);
    }
}
