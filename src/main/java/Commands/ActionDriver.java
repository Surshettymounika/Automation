package Commands;

import Configurations.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionDriver {

    WebDriver driver;
    public ActionDriver()
    {
        driver = Base.driver;

    }

    public void navigateToApplication(String url)
    {
        driver.get(url);

    }
    public void type(By locator, String text)
    {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator)
    {
        driver.findElement(locator).click();
    }
}
