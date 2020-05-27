package frstExcercise;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;


public class SearchTest {

    private WebDriver driver;

    @Before
    public void setUp() { // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        driver = new FirefoxDriver();       //driver działa z różnymi przeglądarkami ChromeDriver()

        driver.manage().window().maximize();        // Zmaksymalizuj okno przeglądarki
        driver.get("http://www.google.com");         // Przejdź do Google
    }
    @Test
    public void testGoogleSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();

        // Wpisz informacje do wyszukania
        element.sendKeys("Testowanie Selenium WebDriver");

        // Prześlij formularz
        element.submit();
    }
    @After
    public void tearDown() throws Exception {

        driver.quit();       // Zamknij przeglądarkę
    }
}