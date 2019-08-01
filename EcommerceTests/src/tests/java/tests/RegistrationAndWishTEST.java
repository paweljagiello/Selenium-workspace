package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LogInPage;
import pages.MobilePage;
import pages.RegisterPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/*     Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.
Test Steps:
1. Go to http://live.guru99.com/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to TV menu
7. Add product in your wish list - use product - LG LCD
8. Click SHARE WISHLIST
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully.

*/

public class RegistrationAndWishTEST {
    private WebDriver driver;
    private String baseURL = "http://live.guru99.com";
    String name = "Adam";
    String lastName ="Nowak";
    String email = "asd112558@wp.pl";
    String password = "qwerty123";

    String shareEmail ="qwerty22@wp.pl";

    @Before//Ustawienie przeglądarki
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get(baseURL);
    }

    @Test
    public void RegisterTEST() {

        HomePage hp = new HomePage(driver);
        hp.GoRegisterAccount();

        RegisterPage rp = new RegisterPage(driver);
        rp.Register(name,lastName,email,password);
        rp.Confirm();

        String actualMess = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/div[2]/p[1]/strong")).getText();
        String expectedMess ="Hello, "+name+" "+lastName+"!";
        assertEquals(actualMess,expectedMess);
    }

    @Test
    public void WishListTEST() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.GoLogin();
        LogInPage lp = new LogInPage(driver);
        lp.LogIn(email,password);

        hp.GoMobile();
        MobilePage mp = new MobilePage(driver);
        mp.IphoneWishAdd();

        driver.findElement(By.name("save_and_share")).click();
        driver.findElement(By.name("emails")).sendKeys(shareEmail);
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();

        String actualMess = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
        String expectedMess = "Your Wishlist has been shared.";

        assertEquals(actualMess,expectedMess);


    }


   @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }
}