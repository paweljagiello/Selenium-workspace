package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SearchEngineTEST {
    private WebDriver driver;
    private String baseURL ="https://www.morele.net/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test//Wyszukiwanie produktu i porównanie wyniku wyszukiwania.
    public void SearchTEST() {

        HomePage pg = new HomePage(driver);
        pg.SearchwithoutCat("Apple");

        String searchResult = driver.findElement(By.xpath("/html/body/main/div/div[3]/div[2]/div/div[1]/div/div[2]")).getText();
        try {
            assertEquals("Apple", searchResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }


}
