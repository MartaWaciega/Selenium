package frstExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataListOneTest {
    static List<String> userName = Arrays.asList("Kasia", "Basia", "jola", "Ryszard", "Zenek");

    public static String getRandomName() {
        Random random = new Random();
        int userIntiger = random.nextInt(100);
        int userNum = userIntiger % userName.size();

        return userName.get(userNum);
    }
}
