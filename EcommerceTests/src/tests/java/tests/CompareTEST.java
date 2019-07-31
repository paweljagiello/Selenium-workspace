package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MobilePage;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

// Test ma na celu sprawdzić działanie sortowania produktów.

public class CompareTEST {
    private WebDriver driver;
    private String baseURL = "http://live.guru99.com";


    @Before//Ustawienie przeglądarki
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get(baseURL);
    }

    @Test
    public void ComparitionVerification() {

        HomePage hp = new HomePage(driver);
        hp.goMobile();

        //Po przejściu do zakładki "Mobile" dodaję do porównania 2 produkty i zatwierdzam porównanie.
        MobilePage mp = new MobilePage(driver);
        mp.XperiaCompare();
        mp.IphoneCompare();
        mp.CompareSubmit();

        //Przejście na pop-up'a, który pojawił się po kliknięciu "Compare" Najpierw utworzenie zmiennej przechowującej ID początkowego okna.
        //Utworzenie zestawu przechowującego ID wszystkich okien.
        String mobilePage = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();

        //Stworzenie iteratora, który pomoże przejrzeć zestaw w poszukiwaniu
        //ID okna różnego od ID mobilePage.
        Iterator iterator = windows.iterator();
        String currentWindowId;

        while(iterator.hasNext()) {
            currentWindowId = iterator.next().toString();

            //Jeśli ID jest inne niż ID początkowego okna, przechodzimy za pomocą switchTo() na to okno.
            if (!currentWindowId.equals(mobilePage)) {
                driver.switchTo().window(currentWindowId);

                //Tworzymy Liste przechowującą elementy ze strony klasy product-name
                List<WebElement> products = driver.findElements(By.className("product-name"));

                //Tworzymy dwie listy przechowujące nazwy produktów porównanych oraz oczekiwane nazwy produktów.
                List<String> actualNames = new ArrayList<>();
                List<String> expectedNames = new ArrayList<>();
                expectedNames.add("SONY XPERIA");
                expectedNames.add("IPHONE");

                //Przypisujemy liście actualnames tytuły ze strony.
                for (WebElement w : products) {
                    actualNames.add(w.getText());
                }

                //Porównanie wyników
                assertEquals(actualNames, expectedNames);

            }


        }}
    @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }
}