import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
// Test ma na celu sprawdzenie czy cena w liście wyboru urządzenia zgadza się z ceną po przejściu w "szczegóły".

public class ListAndDetailsCostsVerificationTEST {
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
    public void titleAndSortVerification() {

        // Zwykłe porównanie dwóch wartości - (?były problemy ze wskazaniem niektórych elementów za pomocą xpatha?)
        driver.findElement(By.linkText("MOBILE")).click();
        String listPrice = driver.findElement(By.id("product-price-1")).getText();
        driver.findElement(By.id("product-collection-image-1")).click();
        String detailsPrice = driver.findElement(By.id("product-price-1")).getText();

        try {
            assertEquals(listPrice, detailsPrice);
        } catch (Exception e){
            e.printStackTrace();
        }

    }


}