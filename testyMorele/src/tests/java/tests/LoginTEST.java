package tests;

import Functions.ReadExcelLoginData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTEST {

    private WebDriver driver;
    private String expectedTitle = "Sklep komputerowy Morele.net";
    private String titleContinous =" - Sklep komputerowy Morele.net";
    private String expectedErrorLoginMsg = "Dane logowania nie są poprawne. Zalogowanie nie powiodło się.";


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test//Prawidlowe dane logowania.
    public void ValidDataLoginTEST() throws IOException {

        LoginPage lp = new LoginPage(driver);
        ReadExcelLoginData excel = new ReadExcelLoginData();
        lp.TypeUsername(excel.GetStringCellValue(1,1));
        lp.TypePassword(excel.GetStringCellValue(1,2));
        lp.SubmitLogin();
        assertEquals(expectedTitle,driver.getTitle()); }


    @Test//Nierawidlowe dane logowania.
    public void InvalidLoginDataTEST() throws IOException {

        LoginPage lp = new LoginPage(driver);
        ReadExcelLoginData excel = new ReadExcelLoginData();
        lp.TypeUsername(excel.GetStringCellValue(2,1));
        lp.TypePassword(excel.GetStringCellValue(2,2));
        lp.SubmitLogin();
        assertEquals(expectedErrorLoginMsg,lp.GetLoginErrorMsg());    }


    @Test//Prawidlowy login, nieprawidlowe haslo.
    public void ValidMailInvalidPassTEST() throws IOException {

        LoginPage lp = new LoginPage(driver);
        ReadExcelLoginData excel = new ReadExcelLoginData();
        lp.TypeUsername(excel.GetStringCellValue(3,1));
        lp.TypePassword(excel.GetStringCellValue(3,2));
        lp.SubmitLogin();
        assertEquals(expectedErrorLoginMsg,lp.GetLoginErrorMsg());    }


    @Test//Nieprawidlowy login, prawidlowe haslo.
    public void InvalidMailValidPassTEST() throws IOException {

        LoginPage lp = new LoginPage(driver);
        ReadExcelLoginData excel = new ReadExcelLoginData();
        lp.TypeUsername(excel.GetStringCellValue(4,1));
        lp.TypePassword(excel.GetStringCellValue(4,2));
        lp.SubmitLogin();
        assertEquals(expectedErrorLoginMsg,lp.GetLoginErrorMsg()); }


        @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }

    }



