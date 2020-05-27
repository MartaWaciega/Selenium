package frstExcercise;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class MyFirstTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html"); //przejdz do strony...
    }

    private void superWriter(WebElement powtorzenie, String text) {  //--> Dzieki tej metodzie nie trzeba powtarzac w kazdym przykladzie:click, clear, sendKey
        powtorzenie.click();
        powtorzenie.clear();
        powtorzenie.sendKeys(text);
    }

    @Test
    public void testSearchBoxPositive() {

        String DATE_FORMATER = "yyyyMMdd";
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATER);
        String formatDateTime = localDateTime.format((formatter));


        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("Karol");
//        WebElement firstName = driver.findElement(By.id("first-name"));
//        superWriter(firstName, "Karol");

        WebElement surname = driver.findElement(By.id("last-name"));
        surname.clear();
        surname.sendKeys("Kowalski");
//        WebElement lastName = driver.findElement(By.id("last-name"));
//        superWriter(lastName, "Kowalski");

// tutaj genederList.get(0) - pobierze element pierwszy Male
// tutaj genederList.get(1) - pobierze element drugi Female
// tutaj genederList.get(2) - pobierze element trzeci In Between
        List<WebElement> genderList = driver.findElements(By.name("gender"));
        WebElement maleGender = genderList.get(2);
        maleGender.click();

        // genderList.get(0).click(); //pobbierze element 1 działa jak tablica to samo co powyzsze 2 linnie


        // CSSSELECTOR--> List<Webelement> gender = driver.findElement(By.cssSelector(".radio-inline"));
        // for (WebElement radioButton: gender){
        // if(radioButton.getText().equals("Male")){
        // radioButton.click();


        WebElement birth = driver.findElement(By.id("dob"));
        birth.clear();
        birth.sendKeys("05/22/2020");

        WebElement adress = driver.findElement(By.id("address"));
        adress.clear(); // Wyczyść teskst zapisany w elemencie
        adress.sendKeys("Polna 41");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("karol.kowalski@mailinator.com");
//        superWriter("mail" + formatDateTime +"@test.com");

        WebElement password = driver.findElement(By.id("password"));
        password.clear(); // Wyczyść teskst zapisany w elemencie
        password.sendKeys("Pass123");

        WebElement company = driver.findElement(By.id("company"));
        company.clear(); // Wyczyść teskst zapisany w elemencie
        company.sendKeys("Coders Lab");

        Select roleDropDown = new Select(driver.findElement(By.id("role"))); //Obiekt typu Select (dla LISTYROZWIJALNEJ), konstuktor od Selectu przyjmuje gotowy webelement -driver.findElement(By.id(" ")));
        roleDropDown.selectByVisibleText("QA"); //metoda selectByVisibleText - szuka w dropdownie tego co przekazujemy w Stringu, tu "QA


        Select JobExpectation = new Select(driver.findElement(By.id("expectation")));  //-->selecty
        JobExpectation.selectByVisibleText("High salary");

//        WebElement development = driver.findElement(By.xpath("//label[text()='Read books']")); //CHECKBOX!!
//        development.click();

        List<WebElement> waysOfDevelopment = driver.findElements(By.xpath("//input[@type='checkbox']"));
        waysOfDevelopment.get(0).click();       // --->klika w checkboxie 1
        waysOfDevelopment.get(2).click();       // --->POBIERA Z cHECKBOXU 3
        waysOfDevelopment.get(4).click();       //-->POBIERA Z CHECBOXU 6
        //.get(0) -> Read Books
        //.get(1) -> Take Online Courses

        WebElement comment = driver.findElement(By.id("comment"));
        comment.clear();
        comment.sendKeys("To jest mój pierwszy automat testow");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement submitMsg = driver.findElement(By.id("submit-msg")); //sprawdzenie czy test zadziałał, czy wyswietlil sie Submitet - robi się asercje!!
        String text = submitMsg.getText(); //pobieramy text z Webelementu getText
        Assert.assertEquals("Successfully submitted!", text);//asercja czy pobrany tekst jest rowny temu ktory uzyskalismy AssertEqual - przyjmuje 2 parametry 1(expected)-oczekiwany, drugi(actual) aktualny
    }

    @After
    public void tearDown() {
// driver.quit(); // Zamknij przeglądarkę
    }
}



// //ALT + ENTER - przypisanie do zmiennej

//  Tablica Stringów
//  String[] napisy = new String [0];
//  napisy = Arrays.copyOf(napisy,napisy.lengh+1);   -->Zwiększenie Tablicy o 1
//  napisy[0] = "Powrót Jedi";
////
////    List<String> napisy = new ArrayList<>();   --> lista działą podobnie do Tablicy
////    napisy.add("Powrot Jedi");
////    napisy.add("Zemasta Sithów");   -->dodanie kolejnego napisu
////    napisy.get(0);          -->zwróci powrót Jedi
////    napisy.get(1);          -->zwróci powrót Zemste Sithów
////    napisy.indexOf("Powrót Jedi")