package tests;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileAndFamilyInfoTest extends TestBase {

    @BeforeMethod
    public void loginToApp()  {

        waitUntilElementClicable(By.id("idsignin"), TIME);
        driver.findElement(By.id("idsignin")).click();

        waitUntilElementClicable(By.id("logininput"),TIME);
        WebElement loginField = driver.findElement(By.id("logininput"));
        loginField.click();
        loginField.sendKeys(USERNAME);

        waitUntilElementClicable(By.id("passwordinput"),TIME);
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        passwordField.click();
        passwordField.sendKeys(USERPASSWORD);

        waitUntilElementClicable(By.id("signinrequest"),TIME);
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        //sleep();
    }

    @Test
    public void dataComparisonFromUserProfileAndFamilyProfile() {


        waitUntilElementClicable(By.id("profile"),TIME);
        driver.findElement(By.id("profile")).click();
       // sleep();

        waitUntilElementIsVisible(By.id("statusinmishpahuginprofile"),TIME);
        if (driver.findElement(By.id("statusinmishpahuginprofile")).getText().equals("Guest")){
            waitUntilElementClicable(By.id("idbtneditprofile"),TIME);
            driver.findElement(By.id("idbtneditprofile")).click();
            //sleep();

            waitUntilElementClicable(By.id("typeuser2inprofile"),TIME);
            driver.findElement(By.id("typeuser2inprofile")).click();
            //sleep();

            waitUntilElementClicable(By.id("idbtnsaveprofile"),TIME);
            driver.findElement(By.id("idbtnsaveprofile")).click();
           // sleep();
        }

        //------- Profile fields values saving ----------------------------

        waitUntilElementIsVisible(By.xpath("//span[@id='fieldobjconfession']"),TIME);
        waitUntilElementIsVisible(By.xpath("//div[contains(text(),'Languages:')]/../span"),TIME);
        waitUntilElementIsVisible(By.xpath("//span[@id='fieldobjfoodPreferences']"),TIME);

        String confessionProfile = driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();
        String languagesProfile = driver.findElement(By.xpath("//div[contains(text(),'Languages:')]/../span")).getText();
        String foodProfile = driver.findElement(By.xpath("//span[@id='fieldobjfoodPreferences']")).getText();

        //-------Family fields values verification ------------------------

        waitUntilElementClicable(By.id("family"),TIME);
        driver.findElement(By.id("family")).click();
        //sleep();

        waitUntilElementIsVisible(By.cssSelector("#fieldobjconfession"),TIME);
        waitUntilElementIsVisible(By.cssSelector("span[id='fieldobjlanguages']"),TIME);
        waitUntilElementIsVisible(By.cssSelector("#fieldobjfoodPreferences"),TIME);
        System.out.println("Confession verification: "
                + driver.findElement(By.cssSelector("#fieldobjconfession")).getText().equals(confessionProfile));
        System.out.println("Languages verification: "
                + driver.findElement(By.cssSelector("span[id='fieldobjlanguages']")).getText().equals(languagesProfile));
        System.out.println("Food verification: "
                + driver.findElement(By.cssSelector("#fieldobjfoodPreferences")).getText().equals(foodProfile));

        boolean confession = (driver.findElement(By.cssSelector("#fieldobjconfession")).getText()).equals(confessionProfile);
        boolean language = driver.findElement(By.cssSelector("span[id='fieldobjlanguages']")).getText().equals(languagesProfile);
        boolean foods = driver.findElement(By.cssSelector("#fieldobjfoodPreferences")).getText().equals(foodProfile);

        Assert.assertTrue(confession && language && foods);

    }
}
