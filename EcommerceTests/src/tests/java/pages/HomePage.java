package pages;

import Functions.GetDoubleFromStringPrice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

//Wszystkie lokatory i metody strony HomePage.
public class HomePage {

    WebDriver driver;
    By mobile =By.xpath("/html/body/div[1]/div/header/div/div[3]/nav/ol/li[1]/a");
    By tv =By.xpath("/html/body/div[1]/div/header/div/div[3]/nav/ol/li[2]/a");
    By account =By.xpath("/html/body/div[1]/div/header/div/div[2]/div/a/span[2]");
    By cart = By.xpath("/html/body/div[1]/div/header/div/div[2]/div/div/a/span[2]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goMobile (){
        driver.findElement()
    }
    public void SearchwithCat(String text, String cat){
        Select categoryDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div/div[2]/div/div[1]/form/div/div/div[1]/div/div[1]/select")));

        driver.findElement(searchBox).sendKeys(text);
        categoryDropdown.selectByVisibleText(cat);
        driver.findElement(confirmButton).submit();
    }

    public void SearchwithoutCat(String text){

        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(confirmButton).submit();
    }


    public void GoPickupPoints(){
        driver.findElement(pickupPoints).click();
    }

    public void GoContact(){
        driver.findElement(contact).click();
    }

    public void GoWishList(){
        driver.findElement(wishList).click();
    }

    public void GoAccountDetails(){
        driver.findElement(accountDetails).click();
    }

    public void GoCart(){
        driver.findElement(cart).click();
    }

    public void CopyPromoCode(){
        driver.findElement(copyPromoCodeButton).click();
    }

    public double GetCartAmount(){
        GetDoubleFromStringPrice gd =new GetDoubleFromStringPrice();

        return gd.StrToDouble(driver.findElement(cartAmount).getText());
    }

    public void ChooseCategory(WebElement category){
        category.click();
    }

}
