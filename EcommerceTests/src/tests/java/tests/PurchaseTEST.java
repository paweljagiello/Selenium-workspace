package tests;


import com.google.common.base.Functions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import functions.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;



public class PurchaseTEST {
    private WebDriver driver;
    private String baseURL = "http://live.guru99.com";

    String email = "asd112558@wp.pl";
    String password = "qwerty123";
    String country = "United States";
    String state ="Alaska";
    String zipcode="23341";
    String adress="ABC";
    String city ="New York";
    String telephone="3412341234";

    @Before//Ustawienie przeglądarki
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get(baseURL);
    }


    @Test
    public void PurchaseTEST() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.GoLogin();
        LogInPage lp = new LogInPage(driver);
        lp.LogIn(email,password);

        AccountPage ap = new AccountPage(driver);
        ap.GoWishList();
        ap.AddToCart();
        CartPage cp = new CartPage(driver);
        cp.EstimateDataFill(country,state,zipcode);
        cp.estimateButton();
        cp.ConfirmShippingPrice();
        Thread.sleep(1000);
        cp.GoUpdateTotalCost();

        GetDoubleFromStringPrice gd = new GetDoubleFromStringPrice();
        String pp = cp.GetProductPrice();
        String sp = cp.GetEstShippingCost();
        double productPrice = gd.StrToDouble(pp);
        double shippingCosts = gd.StrToDouble(sp);
        double expectedGrandCost = productPrice+shippingCosts;
        double actuallGrandCost = gd.StrToDouble(cp.GetGrandTotalPrice());
        assertEquals(expectedGrandCost,actuallGrandCost, 0.01);
        cp.CheckoutProceed();

        cp.CheckoutDataFill(adress,city,state,zipcode,country,telephone);
        cp.GoShippingContinue();
        cp.ChooseMoneyPayment();
        cp.GoPaymentContinue();
        cp.PlaceOrder();

        String orderID = cp.GetOrderID();
        int expectedIdLength =9;
        int actuallIdLength =orderID.length();
        assertEquals(expectedIdLength,actuallIdLength);





    }




 /*   @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }*/
}