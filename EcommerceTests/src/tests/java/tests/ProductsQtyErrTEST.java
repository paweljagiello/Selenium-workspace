package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MobilePage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class ProductsQtyErrTEST {
    private WebDriver driver;
    private String baseURL = "http://live.guru99.com";
// Test ma na celu sprawdzenie czy cena w liście wyboru urządzenia zgadza się z ceną po przejściu w "szczegóły".

    @Before//Ustawienie przeglądarki
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }
    @After//Zamknięcie przeglądarki
    public void browserClose() {
        driver.close();
    }

    @Test
    public void OverloadQtyErrorMsgTEST() {
        //Zainicjowanie zmiennej i przypisanie jej treści oczekiwanego komunikatu
        String expectedErrorMsg = "Some of the products cannot be ordered in requested quantity.";
        HomePage hp = new HomePage(driver);
        //Przejście do zakładki MOBILE i dodanie do koszyka produktu.
        hp.GoMobile();
        MobilePage mp = new MobilePage(driver);
        mp.AddRandomToBasket();
        //Zmiana ilości zamawianego produktu na 1000 oraz zatwierdzenie zmian
        ProductPage pg = new ProductPage(driver);
        pg.ChangeQty("1000");
        pg.AddToCart();

        //Pobranie treści błędu, który pojawił się po zmianie ilości oraz porównanie z oczekiwanym.
        try {
            assertEquals(expectedErrorMsg, pg.GetErrorMsg());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
