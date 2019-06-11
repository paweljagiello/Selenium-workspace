import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
     void browserClose() {
        driver.close();
     }

    @Test
    public void OverloadQtyErrorMsgTEST() {
        //Zainicjowanie zmiennej i przypisanie jej treści oczekiwanego komunikatu
        String expectedErrorMsg = "Some of the products cannot be ordered in requested quantity.";

        //Przejście do zakładki MOBILE i dodanie do koszyka produktu.
        driver.findElement(By.linkText("MOBILE")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();

        //Zmiana ilości zamawianego produktu na 1000 oraz zatwierdzenie zmian
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button")).submit();

        //Pobranie treści błędu, który pojawił się po zmianie ilości oraz porównanie z oczekiwanym.
        String errorMsg = driver.findElement(By.className("error-msg")).getText();

       try {
           assertEquals(expectedErrorMsg, errorMsg);
           } catch (Exception e){
            e.printStackTrace();
             }

        driver.findElement(By.className("button2 btn-empty")).submit();
    }


}