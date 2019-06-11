import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
//Poprawne logowanie, niepoprawny login i hasło, niepoprawny login, niepoprawne hasło
public class BankLogInTests {
        private WebDriver driver;
        private String baseUrl = "http://www.demo.guru99.com/V4";

        @Before//Ustawienie przegladarki
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","C:\\drivers\\ch\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

            driver.get(baseUrl);
        }

        @After
        public void browserClose(){
        driver.close();
    }


        @Test//Testowanie Poprawnych danych logowania
        public void loginValidData(){

            String expectMess = "Welcome To Manager's Page of Guru99 Bank";

            driver.findElement(By.name("uid")).sendKeys("mngr198221");
            driver.findElement(By.name("password")).sendKeys("UvutYdy");
            driver.findElement(By.name("btnLogin")).click();

            String text = driver.findElement(By.cssSelector("[behavior=alternate]")).getText();

            assertEquals(expectMess, text);
        }

         @Test//Testowanie Niepoprawnych danych logowania
          public void loginInvalidIdandPass(){

            String expectMess = "User or Password is not valid";

            driver.findElement(By.name("uid")).sendKeys("xyw12345");
            driver.findElement(By.name("password")).sendKeys("xxxxxxx");
            driver.findElement(By.name("btnLogin")).click();

            String text = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            assertEquals(expectMess, text);

          }

          @Test//Testowanie Niepoprawnego ID i poprawnego hasla
          public void loginInvalidId(){
            String expectMess = "User or Password is not valid";

            driver.findElement(By.name("uid")).sendKeys("xyw12345");
            driver.findElement(By.name("password")).sendKeys("UvutYdy");
            driver.findElement(By.name("btnLogin")).click();

            String text = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            assertEquals(expectMess, text);

          }

          @Test//Testowanie Niepoprawnego hasla i poprawnego ID
          public void loginInvalidPassword(){
            String expectMess = "User or Password is not valid";

            driver.findElement(By.name("uid")).sendKeys("mngr198221");
            driver.findElement(By.name("password")).sendKeys("xxxxxxx");
            driver.findElement(By.name("btnLogin")).click();

            String text = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            assertEquals(expectMess, text);

            }


}