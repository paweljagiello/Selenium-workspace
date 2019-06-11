package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//Wszystkie lokatory i metody strony Product Page.
public class WishListPage {

    WebDriver driver;
    By deleteWishlistButton =By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[5]/a[1]/i");
    List<WebElement> WishlistList = driver.findElements(By.className("sl-nb-name"));
    By sortDatefromNewest = (By) driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[5]/div/a[2]"));
    List<WebElement> DatesList  = driver.findElements(By.className("table-col mUser-col-date"));

    public WishListPage(WebDriver driver){
            this.driver = driver;
        }

    public void DeleteWishList(int nrListyOdGory){
        driver.findElement(By.xpath("/html/body/div[3]/section/section/div/div[2]/div[1]/div[2]/div[2]/div["+(nrListyOdGory+1)+"]/div[5]/a[1]/i")).click();
        }

    public void SortByDate(){
            driver.findElement(sortDatefromNewest).click();
        }

}


