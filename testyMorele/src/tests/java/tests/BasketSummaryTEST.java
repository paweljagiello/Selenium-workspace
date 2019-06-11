package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasketPage;
import pages.ProductPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BasketSummaryTEST {

    private WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test//Zakup produktu, wybranie ilosci i porownanie ceny z ceną koszyku
    public void BasketSumTEST() throws IOException {

        double sum = 0.0;

        ProductPage pp = new ProductPage(driver);

        driver.get("https://www.morele.net/sluchawki-panasonic-rp-hje125e-k-573877/");
        pp.QuantityChoose("3");

        sum = sum+pp.GetProductPriceDouble();

        pp.AddToBasket();
        pp.ConfirmBuyGoToBasket();

        BasketPage bp = new BasketPage(driver);

        assertEquals(bp.GetWholeBasketAmount(),sum,0.01);
    }



        @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }
}



