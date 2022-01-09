package UI;

import Commands.ActionDriver;
import Configurations.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class LoginTestCase1  extends Base {

    @Test(priority = 1)
    public void validateLogin() throws InterruptedException
    {
        ActionDriver aDriver = new ActionDriver();
        aDriver.type(WebElementDetails.txtUserName, "standarduser");
        sleep(1000);
        aDriver.type(WebElementDetails.txtPassword, "secret_sauce");
        sleep(1000);
        aDriver.click(WebElementDetails.btnLogin);
        sleep(2000);
        System.out.println("Invalid Username or Password");
        //aDriver.type(WebElementDetails.txtUserName, "");

    }

    @Test(priority = 2)
    public void loginTestCase1() throws Exception {

        WebElement l = driver.findElement(By.id("password"));
        l.sendKeys("Selenium");
        String s = Keys.chord(Keys.CONTROL, "a");
        l.sendKeys(s);
        l.sendKeys(Keys.DELETE);
        WebElement U = driver.findElement(By.name("user-name"));
        U.clear();
        ActionDriver aDriver = new ActionDriver();
        aDriver.type(WebElementDetails.txtUserName, "standard_user");
        sleep(1000);
        aDriver.type(WebElementDetails.txtPassword, "secret_sauce");
        sleep(1000);
        aDriver.click(WebElementDetails.btnLogin);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
        sleep(2000);
    }

    @Test(priority = 3)
        public void addItem() throws InterruptedException
       {
           ((JavascriptExecutor) driver).executeScript("scroll(0,450)");
          sleep(3000);
         driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
         sleep(2000);
         boolean isDisplayed = driver.findElement(By.name("remove-sauce-labs-bolt-t-shirt")).isDisplayed();
         if (isDisplayed)
         {
            System.out.println("Item Added to cart");
         }else
            System.out.println("Item is not added to cart");
         sleep(2000);

       }

       @Test(priority = 4)
       public void checkoutItem() throws InterruptedException
       {
           ((JavascriptExecutor) driver).executeScript("scroll(0,-450)");
           sleep(4000);
           driver.findElement(By.className("shopping_cart_link")).click();
           sleep(4000);
           driver.findElement(By.id("checkout")).click();
           sleep (2000);
           String url= driver.getCurrentUrl();
           Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-one.html");
           System.out.println("Item checkout has been done");
       }

        @Test(priority = 5)
        public void addingDetails() throws InterruptedException
        {
          driver.findElement(By.id("first-name")).sendKeys("Surshetty");
          driver.findElement(By.name("lastName")).sendKeys("Mounika");
          driver.findElement(By.name("postalCode")).sendKeys("500055");
          driver.findElement(By.id("continue")).click();
          sleep(2000);
          String url= driver.getCurrentUrl();
          Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-two.html");
          System.out.println("Personal Details Added Successfully");
          sleep(2000);

        }

        @Test(priority = 6)
        public void paymentSummary() throws InterruptedException
        {
            ((JavascriptExecutor) driver).executeScript("scroll(0,450)");
            sleep(2000);
            driver.findElement(By.id("finish")).click();
            String url= driver.getCurrentUrl();
            Assert.assertEquals(url,"https://www.saucedemo.com/checkout-complete.html");
            sleep(1000);
            ((JavascriptExecutor) driver).executeScript("scroll(0,450)");
            driver.findElement(By.id("back-to-products")).click();
            sleep(2000);
        }

        @Test(priority = 7)
        public void performLogout() throws InterruptedException
        {
            driver.findElement(By.id("react-burger-menu-btn")).click();
            sleep(1000);
            driver.findElement(By.id("logout_sidebar_link")).click();
            String url= driver.getCurrentUrl();
            Assert.assertEquals(url, "https://www.saucedemo.com/");
            sleep(2000);
            System.out.println("Logout Successful");

        }
}



