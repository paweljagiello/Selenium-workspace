
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
    }

    @Test
    public void loginSucces(){
        String expectMess = "Welcome To Manager's Page of Guru99 Bank";
        driver.get("http://www.demo.guru99.com/V4");
        driver.findElement(By.name("uid")).sendKeys("mngr198221");
        driver.findElement(By.name("password")).sendKeys("UvutYdy");
        driver.findElement(By.name("btnLogin")).click();
        String text = driver.findElement(By.cssSelector("[behavior=alternate]")).getText();
        assertEquals(expectMess, text);
    }

    @After
    public void browserClose(){
        driver.close();
    }
}
