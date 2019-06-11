package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductsListPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePageNavTEST {

    private WebDriver driver;
    private String baseURL ="https://www.morele.net/";
    private String titleContinous =" - Sklep komputerowy Morele.net";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }


    @Test//Przekierowanie na podstrone z punktami odbioru.
    public void PickupPointNavTEST(){
        HomePage hp = new HomePage(driver);
        hp.GoPickupPoints();
        assertEquals(driver.getTitle(), "Netpunkty"+titleContinous);
    }

    @Test//Przekierowanie na podstrone z danymi kontaktowymi.
    public void ContactDetailsNavTEST(){
        HomePage hp = new HomePage(driver);
        hp.GoContact();
        assertEquals(driver.getTitle(), "Biuro Obsługi Klienta"+titleContinous);
    }

    //__________DO POPRAWKI
    @Test//Przekierowanie na podstrone z Listami Zakupowymi.
    public void WishListNavTEST(){
        HomePage hp = new HomePage(driver);
        hp.GoWishList();
        assertEquals("https://www.morele.net/login", driver.getCurrentUrl());
    }

    //__________DO POPRAWKI
    @Test//Przekierowanie na podstrone Profilu użytkownika.
    public void MyAccountNavTEST(){
        HomePage hp = new HomePage(driver);
        hp.GoAccountDetails();
        assertEquals("https://www.morele.net/login", driver.getCurrentUrl());
    }


        @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }

    }



