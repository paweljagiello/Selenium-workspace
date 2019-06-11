package Functions;

import org.openqa.selenium.WebDriver;

public class GetDoubleFromStringPrice {

    public double StrToDouble(String t){
        t = t.replaceAll("zł","");
        t = t.replaceAll(" ","");
        t = t.replaceAll(",",".");
        double d = Double.parseDouble(t);
        return d;
    }
}
