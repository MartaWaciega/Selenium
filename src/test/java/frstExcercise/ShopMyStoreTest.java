package frstExcercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class ShopMyStoreTest {
    private WebDriver driver;           //na bazie klasy Webdrive stworzono driver o polu prywatnym

    @Before         //oznaczenie do metody
    public void setUp() {      // zmienna setUp -jako ustaw testy

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();       //driver działa z różnymi przeglądarkami ChromeDriver()

        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();        // Zmaksymalizuj okno przeglądarki
        driver.get("http://prod-kurs.coderslab.pl/index.php");         // Przejdź do Google
    }

    @Test
    public void testSearchBox() throws InterruptedException {     // Znajdź element wprowadzania tekstu na podstawie jego nazwy

        String[] products = {"white", "mug", "cushion", "notebook", "graphics"};      //Tablica produktów
        Random random = new Random();    //losowanie obiegtów przez klase Random


        for (int i = 0; i < 3; i++) {               //Wyszukaj,wyczysc,wyslij,kliknij *3
            int randomInteger = random.nextInt(4); //zmienna productNum losuje jednen z 4 produktów (white jako 0))
            int productNum = randomInteger % products.length;  //uzywamy jesli bound np.100 - wtedy mozemy do tablicy String dopisywac 100 pozycji


            WebElement wyszukiwarka = driver.findElement(By.name("s"));
            wyszukiwarka.clear();
            wyszukiwarka.sendKeys(products[productNum]);    //wysłanie napisu z tablicy Stringów
            wyszukiwarka.submit();


//        System.out.println(products[productNum]);
            System.out.println("Wylosowano produkt " + productNum );
          Thread.sleep(2000);   //zatrzymaj watek na 2000 milisekund
        }
    }
        @After
    public void tearDown() throws Exception {
        driver.quit();       // Zamknij przeglądarkę

    }
}