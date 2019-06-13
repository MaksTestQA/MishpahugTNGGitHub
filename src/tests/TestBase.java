package tests;
//
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.function.Function;

public class TestBase {

    WebDriver driver;

    public static final String URL = "https://mishpahug.co.il/";
    public static final String USERNAME = "maks";
    public static final String USERPASSWORD = "vfrcbv87";
    public static final int TIME = 30;

    @BeforeMethod
    public void startApp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        //sleep();

        waitUntilElementClicable(By.id("closedIntro"),TIME);
        driver.findElement(By.id("closedIntro")).click();
        //sleep();
    }

    @AfterMethod()
    public void stopDriver(){
        driver.close();
    }

    public static void sleep() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void waitUntilElementClicable(By locator , int time ){
        try {
            new WebDriverWait(driver , time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void waitUntilElementIsVisible(By locator, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            e.printStackTrace();
           System.out.println(e.getMessage());
        }
    }

    public void waitUntilElementAttributeContainsText(By locator,String attribute,String value, int time){
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.attributeContains(locator , attribute, value));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public void waitUntilElementTextIsLoaded(By locator,String value, int time){
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}











