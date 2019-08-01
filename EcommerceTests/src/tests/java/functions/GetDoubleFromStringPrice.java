package functions;

import org.openqa.selenium.WebDriver;

public class GetDoubleFromStringPrice {

    public double StrToDouble(String t){
        t = t.replace("$","");

        double d = Double.parseDouble(t);
        return d;
    }
}
