package tests;

import Functions.GetDoubleFromStringPrice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductsListPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SortingTEST {
    private WebDriver driver;
    private String baseURL ="https://www.morele.net/komputery/komputery-pc/komputery-do-domu-i-biura-19/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test//Test Ma za zadanie sprawdzić czy filtr ZAKRESU CEN działa prawidłowo
    public void PriceRangeSortTEST() {

        ProductsListPage pl = new ProductsListPage(driver);
        pl.SetMinimumPrice("2000");
        pl.SetMaximumPrice("2500");
        pl.SortButton();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GetDoubleFromStringPrice std = new GetDoubleFromStringPrice();

        List<WebElement> prices = pl.GetPricesList();
        boolean isitsorted = false;

        for(WebElement product : prices) {

            double d = std.StrToDouble(product.getText());

            if(d>=2000.00&&d<=2500.00){
                isitsorted = true;
            }else{
                isitsorted=false;
                System.out.println(d);
            }

            assertEquals(true, isitsorted);
        }
        }


        @Test//Test Ma za zadanie sprawdzić czy sortowanie według ceny dziala prawidłowo.
        public void PriceSortTEST() {

            ProductsListPage pl = new ProductsListPage(driver);
            pl.SetPriceSorting();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<WebElement> prices = pl.GetPricesList();
            GetDoubleFromStringPrice std = new GetDoubleFromStringPrice();
            boolean isitsorted = false;
            double previousPrice = 999999.00;

            for(int i=0;i<prices.size();i++) {

                double d = std.StrToDouble(prices.get(i).getText());

                if(d<=previousPrice){
                    isitsorted = true;
                }else{ isitsorted=false;}
                previousPrice=d;
                assertEquals(true, isitsorted);
            }
        }


    @Test//Test Ma za zadanie sprawdzić czy sortowanie według ceny dziala prawidłowo.
    public void BrandSortTEST() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        ProductsListPage pl = new ProductsListPage(driver);
        js.executeScript("window.scrollBy(0,500)");
        String brandname= pl.BrandSort();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> names = pl.ProductNamesList();

        boolean isitsorted = false;

        for(int i=0;i<names.size();i++) {

            if(names.get(i).getText().indexOf(brandname)!=-1){
                isitsorted = true;
            }else{ isitsorted=false;
            System.out.println("Not sorted: "+names.get(i).getText());}

            assertEquals(true, isitsorted);
        }

    }

        @After//Zamknięcie przeglądarki
    public void browserClose(){
        driver.close();
    }

}



