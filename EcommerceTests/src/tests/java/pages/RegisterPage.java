package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    By typeName = By.id("firstname");
    By typeLastName = By.id("lastname");
    By typeEmail = By.id("email_address");
    By typePassword = By.id("password");
    By typePasswordConfirm = By.id("confirmation");
    By confrimButton = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/form/div[2]/button");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

   public void Register(String name, String lastName, String email, String password){
        driver.findElement(typeName).sendKeys(name);
        driver.findElement(typeLastName).sendKeys(lastName);
        driver.findElement(typeEmail).sendKeys(email);
        driver.findElement(typePassword).sendKeys(password);
        driver.findElement(typePasswordConfirm).sendKeys(password);
   }

   public void Confirm(){
        driver.findElement(confrimButton).click();
   }

}
