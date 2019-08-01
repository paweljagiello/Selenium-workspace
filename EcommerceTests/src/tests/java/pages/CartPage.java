package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    WebDriver driver;
    By productPrice = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[3]/span/span");
    By countrySelect1 = By.id("country");
    By stateSelect1 = By.id("region_id");
    By zipcode1 = By.id("postcode");
    By confirmshippingPrice = By.xpath("//*[@id=\"s_method_flatrate_flatrate\"]");
    By estimate = By.xpath("//*[@id=\"shipping-zip-form\"]/div/button/span/span");
    By estimateShippingCosts =By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label/span");
    By updateTotalCost = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/form[2]/div/button/span/span");
    By grandTotal =By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span");
    By checkout=  By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[1]/ul/li/button/span/span");
    By adress= By.id("billing:street1");
    By city= By.id("billing:city");
    By stateSelect2= By.id("billing:region_id");
    By zipcode2= By.id("billing:postcode");
    By countrySelect2= By.id("billing:country_id");
    By telephone= By.id("billing:telephone");
    By adressContinue= By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span");
    By shippingContinue = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span");
    By moneyOrder = By.xpath("//*[@id=\"dt_method_checkmo\"]/label");
    By paymentContinue = By.xpath("//*[@id=\"payment-buttons-container\"]/button");
    By placeOrder =By.xpath("//*[@id=\"review-buttons-container\"]/button");
    By orderID=By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

   public void CheckoutProceed(){
        driver.findElement(checkout).click();
   }
   public String GetProductPrice(){
       return driver.findElement(productPrice).getText();
   }
   public void ConfirmShippingPrice(){
        driver.findElement(confirmshippingPrice).click();
   }
   public void estimateButton(){
        driver.findElement(estimate).click();
   }

   public void EstimateDataFill(String country, String state, String zip){

       Select c = new Select(driver.findElement(countrySelect1));
       c.selectByVisibleText(country);
       Select s = new Select(driver.findElement(stateSelect1));
       s.selectByVisibleText(state);

       driver.findElement(zipcode1).sendKeys(zip);

   }
   public void CheckoutDataFill(String adressInfo, String cityName, String state, String zipCodeInfo, String country, String telephoneNumber){
        driver.findElement(adress).sendKeys(adressInfo);
        driver.findElement(city).sendKeys(cityName);
        Select s = new Select(driver.findElement(stateSelect2));
        s.selectByVisibleText(state);
        driver.findElement(zipcode2).sendKeys(zipCodeInfo);
        Select c = new Select(driver.findElement(countrySelect2));
        c.selectByVisibleText(country);
        driver.findElement(telephone).sendKeys(telephoneNumber);

        driver.findElement(adressContinue).click();
   }
   public String GetEstShippingCost(){
        return driver.findElement(estimateShippingCosts).getText();
    }
    public String GetGrandTotalPrice(){
        return driver.findElement(grandTotal).getText();
    }

   public void GoUpdateTotalCost(){
        driver.findElement(updateTotalCost).click();
   }
   public void GoShippingContinue(){
        driver.findElement(shippingContinue).click();
   }
   public void ChooseMoneyPayment(){
        driver.findElement(moneyOrder).click();
   }
   public void GoPaymentContinue(){
        driver.findElement(paymentContinue).click();
   }
   public void PlaceOrder(){
        driver.findElement(placeOrder).click();
   }

   public String GetOrderID(){
        return driver.findElement(orderID).getText();
   }


}
