
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Test ma na celu sprawdzić działanie sortowania produktów.

public class TitlesAndSortEcommerceTest {
    private WebDriver driver;
    private String baseURL = "http://live.guru99.com";


    @Before//Ustawienie przeglądarki
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get(baseURL);
    }

    @Test
    public void titleAndSortVerification() {

        //Odnalezienie tytulu strony oraz porownanie z oczekiwanym wynikiem.
        String homeTitle = driver.findElement(By.className("page-title")).getText();
        assertEquals("THIS IS DEMO SITE FOR   ", homeTitle);

        //Przejscie na podstrone "MOBILE"
        driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[3]/nav/ol/li[1]/a")).click();

        //Ponowne zweryfikowanie tytulu strony. Tym razem oczekiwany wynik "MOBILE"
        String mobileTitle = driver.findElement(By.className("page-title")).getText();
        assertEquals("MOBILE", mobileTitle);

        //Rozwiniecie(Select) meniu sortowania, oraz wybranie sortowania za pomoca "Name".
        Select chooseSort = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
        chooseSort.selectByVisibleText("Name");

        //Stworzenie !DWOCH! list oraz Odnalezienie za pomocą"findElemens" Wszystkich elementów spełniających dane warunki.
        List<String> actuallNames = new ArrayList<>();
        List<String> expectedNames = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.cssSelector("ul.products-grid h2.product-name"));

        //Przypisanie OBU listom wartości każdego elementu(product) spełniających podane wyżej warunki(products);
        for (WebElement product : products) {
            actuallNames.add(product.getText());
            expectedNames.add(product.getText());
            }
        //Sortowanie alfabetyczne jednej z list - oczekiwany wynik
        Collections.sort(expectedNames, String.CASE_INSENSITIVE_ORDER);

        //Sprawdzenie czy oczekiwany wynik jest równy widocznemu na stronie sortowaniu.
        assertEquals(actuallNames,expectedNames);
    }


         @After//Zamknięcie przeglądarki
         public void browserClose(){
            driver.close();
         }
}
