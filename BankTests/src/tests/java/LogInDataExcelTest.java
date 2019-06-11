import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

//Poprawne logowanie, niepoprawny login i hasło, niepoprawny login, niepoprawne hasło
//Korzystanie z Apache POI w celu odczytu danych testowych z pliku Excela.
//Na koniec- wykonanie screen shota wyniku.
public class LogInDataExcelTest {
    private WebDriver driver;
    private String baseUrl = "http://www.demo.guru99.com/V4";

    @Before//Ustawienie przegladarki
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\ch\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void browserClose() {
        driver.close();
    }


    @Test//Testowanie Poprawnych danych logowania
    public void loginValidExcelDataTEST() throws Exception {

        //Stworzenie obiektu klasy File w celu otwarcia pliku excel.
        File src = new File("C:\\Users\\Wonski\\Downloads\\logindata.xlsx");

        //Stworzenie obiektu klasy FileInputStream aby odczytać plik ze źródła "src".
        FileInputStream fis = new FileInputStream(src);

        //Kolejne Stworzenie obiektu klasy, tym razem już konkretnie aby otworzyć plik excel
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        //Wybranie arkuszu o indeksie 0 (domyslny arkusz)
        XSSFSheet sheet1 = wb.getSheetAt(0);

        //Dwie zmiennie, aby przechować dane do logowanie - login i password pobrane z konkretnej kolumny i wiersza.
        String login = sheet1.getRow(0).getCell(0).getStringCellValue();
        String password = sheet1.getRow(0).getCell(1).getStringCellValue();


        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();

        //Weryfikacja wyswietlanego powiadomienia w panelu uzytkownika.
        String expectMess = "Manger Id : "+login;
        String text = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();

        assertEquals(expectMess, text);

        //Screenshot wyniku
        TakesScreenshot ts =(TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File("C:\\Users\\Wonski\\Pictures\\screenshot.png"));

    }

}