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
// Test ma na celu sprawdzenie czy cena w liście wyboru urządzenia zgadza się z ceną po przejściu w "szczegóły".

public class ListAndDetailsPriceVerificationTEST {
    private WebDriver driver;
    private String baseURL = "http://live.guru99.com";


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
    public void ListAndProductPagePricesTES() {
        HomePage hp = new HomePage(driver);
        // Zwykłe porównanie dwóch wartości
        hp.GoMobile();
        MobilePage mp =new MobilePage(driver);
        String listPrice = mp.GetProductPrice();
        mp.GoProductPage();
        ProductPage pp=new ProductPage(driver);

        try {
            assertEquals(listPrice, pp.GetProductPrice());
        } catch (Exception e){
            e.printStackTrace();
        }

    }


}