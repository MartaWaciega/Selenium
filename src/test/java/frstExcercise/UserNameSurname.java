package frstExcercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class UserNameSurname {

    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }


    @Test
    public void testlogin() {
//        String[] userName = {"..Robert.", "#Zofia", "AaaaAA", "Thomssson", "Alex", "76Dbg65", "Adam"};   //STRING
//
//        Random random = new Random();           //Generator liczb pseudolosowych
//        int userIntiger = random.nextInt(50);           //losowanie liczby od 0-6
//        int userNumber = userIntiger % userName.length;         //reszta z dzielenia -oznacza ze z tablicy bedzie wylosowane imie 50 z dzielenia  -> 50 %6 -> 4 imie - "Thomsson"
//
//        WebElement firstName = driver.findElement(By.id("first-name"));
//        firstName.click();
//        firstName.sendKeys(userName[userNumber]);
//

        List<String> userNames = Arrays.asList("#Zofia", "AaaaAA", "Thomssson", "Alex", "76Dbg65", "Adam");      //--> lista imion przeniesiona do packege DataStringAndListTest
//        userNames.add("Olga");            ---> zamiast linijki 45 uzywamy wtedy 44
//        userNames.add("56dgdg65");
//        userNames.add("Thomssson");

        Random random = new Random();           //Generator liczb pseudolosowych
        int userIntiger = random.nextInt(50);           //losowanie liczby od 0-6
        int userNumber = userIntiger % userNames.size();

        WebElement firstNames = driver.findElement(By.id("first-name"));
        firstNames.click();
        firstNames.sendKeys(userNames.get(userNumber));
    }
        // imiona męskie w tablicy
        static String[] firstNamesMale = {"Jan", "Adam", "Stephan", "Joe", "Mickey", "Xawier"};

        public static String getRandomMaleName() {
            Random randomMn = new Random();
            int ManNameInteger = randomMn.nextInt(100);
            int randMaleNames = ManNameInteger % firstNamesMale.length;
            return firstNamesMale[randMaleNames];
        }


        // imiona żeńskie w tablicy:
        static String[] firstNameFemale = {"Joanna", "Agnes", "Sophie", "Yenefer", "Margot"};

        public static String getRandomFemaleName(){
            Random randomFn = new Random();
            int FamNameInteger = randomFn.nextInt(100);
            int randFemaleNames = FamNameInteger % firstNameFemale.length;
            return firstNameFemale[randFemaleNames];

        }


        // nazwiska w liście
        static List<String> surname = Arrays.asList
                ("Snow", "Lanister", "", "Wonka", "XYZ2");

        public static String getRandomSurname() {
            Random randomS = new Random();
            int surnameInteger = randomS.nextInt(100);
            int randSurname = surnameInteger % surname.size();
            return surname.get(randSurname);
        }
    @After
    public void tearDown() throws Exception {

        driver.quit();       // Zamknij przeglądarkę
    }
}