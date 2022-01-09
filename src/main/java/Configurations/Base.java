package Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class Base {

    public  static WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest parentTest;
    //public static ExtentTest childTest;

    @BeforeTest
    public void report()
    {
        htmlReporter = new ExtentHtmlReporter("Reports//MyResult.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void method(Method method)
    {
        parentTest = extent.createTest(method.getName());
    }

    @BeforeClass
    public void LaunchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.saucedemo.com");
    }

    @AfterClass
    public void CloseApplication()
    {
        driver.quit();
        extent.flush();
    }


}
