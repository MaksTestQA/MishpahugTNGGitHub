package tests;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase {

    @BeforeMethod
    public void loginToApp() {

        waitUntilElementClicable(By.id("idsignin"),TIME);
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
      //  sleep();
    }

    @Test
    public void profileTitleTest() throws InterruptedException {

        waitUntilElementClicable(By.id("profile"),TIME);
        driver.findElement(By.id("profile")).click();
      //  sleep();

        waitUntilElementTextIsLoaded(By.id("titleprofile"),"My Profile: "+ USERNAME, TIME);
      //  waitUntilElementIsVisible(By.id("titleprofile"),TIME);
        WebElement titleProfile = driver.findElement(By.id("titleprofile"));
        System.out.println("Title profile verification: " + titleProfile.getText().contains(USERNAME));

        Assert.assertEquals(titleProfile.getText(),"My Profile: "+ USERNAME);
    }
}
