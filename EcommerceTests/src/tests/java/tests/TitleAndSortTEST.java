package tests;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.MobilePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Test ma na celu sprawdzić działanie sortowania produktów.

public class TitleAndSortTEST {
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
    public void titleAndSortVerification() {

        HomePage hp = new HomePage(driver);
        //Odnalezienie tytulu strony oraz porownanie z oczekiwanym wynikiem.
        assertEquals("THIS IS DEMO SITE FOR   ", hp.GetPageTitle());

        //Przejscie na podstrone "MOBILE"
        hp.GoMobile();

        MobilePage mp = new MobilePage(driver);
        //Ponowne zweryfikowanie tytulu strony. Tym razem oczekiwany wynik "MOBILE"
        assertEquals("MOBILE", hp.GetPageTitle());

        //Rozwiniecie(Select) meniu sortowania, oraz wybranie sortowania za pomoca "Name".
        mp.SelectSorting("Name");

        //Stworzenie !DWOCH! list oraz Odnalezienie za pomocą"findElemens" Wszystkich elementów spełniających dane warunki.
        List<String> actuallNames = new ArrayList<>();
        List<String> expectedNames = new ArrayList<>();
        List<WebElement> products = mp.GetProductsNames();

        //Przypisanie OBU listom wartości każdego elementu(product) spełniających podane wyżej warunki(products);
        for (WebElement product : products) {
            actuallNames.add(product.getText());
            expectedNames.add(product.getText());
        }
        //Sortowanie alfabetyczne jednej z list - oczekiwany wynik
        Collections.sort(expectedNames, String.CASE_INSENSITIVE_ORDER);

        //Sprawdzenie czy oczekiwany wynik jest równy widocznemu na stronie sortowaniu.
        assertEquals(actuallNames,expectedNames);
    }


    @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }
}
