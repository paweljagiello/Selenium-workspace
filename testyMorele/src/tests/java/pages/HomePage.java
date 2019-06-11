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
    By searchBox =By.name("search");
    By searchBoxCategories =By.xpath("//*[@id=\"header\"]/div[1]/div/div/div/div[2]/div/div[1]/form/div/div/div[1]/div/div[1]/button");
    By confirmButton =By.xpath("//*[@id=\"header\"]/div[1]/div/div/div/div[2]/div/div[1]/form/button");
    By pickupPoints = By.xpath("//*[@id=\"header\"]/div[1]/div/div/div/div[2]/div/div[2]/div/div[1]/a/span");
    By contact =By.xpath("/html/body/header/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/a/span");
    By wishList =By.xpath("//*[@id=\"header\"]/div[1]/div/div/div/div[2]/div/div[2]/div/div[3]");
    By accountDetails =By.xpath("//*[@id=\"header\"]/div[1]/div/div/div/div[2]/div/div[2]/div/div[4]/a");
    By cart =By.className("h-control-btn small-basket");
    By promoCode = By.className("promo-box-code-value");
    By copyPromoCodeButton = By.className("promo-box-code-button");
    By cartAmount =By.xpath("//*[@id=\"header\"]/div[1]/div/div/div/div[2]/div/div[2]/div/div[5]/a/span");

    public HomePage(WebDriver driver){
        this.driver = driver;
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
