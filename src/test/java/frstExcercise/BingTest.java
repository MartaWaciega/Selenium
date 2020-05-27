package frstExcercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class BingTest {

    private WebDriver driver;

    @Before
    public void setUp() { // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://www.bing.com");         // Przejdź do Bing
    }
    @Test
    public void testBing() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Mistrzostwa świata w piłce nożnej 2018");
        element.submit();           // Prześlij formularz
    }
    @After
    public void tearDown() throws Exception {

        driver.quit();       // Zamknij przeglądarkę
    }
}