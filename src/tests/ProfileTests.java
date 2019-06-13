package tests;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProfileTests extends TestBase{

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
    public void profileTitleTest() {

        waitUntilElementClicable(By.id("profile"),TIME);
        WebElement profileButton = driver.findElement(By.id("profile"));
        profileButton.click();
        //sleep();

        waitUntilElementTextIsLoaded(By.id("titleprofile"),"My Profile: " + USERNAME, TIME);
        WebElement titleProfile = driver.findElement(By.id("titleprofile"));

        Assert.assertEquals(titleProfile.getText(),"My Profile: " + USERNAME);
    }



    @Test
    public void userProfileGuest() throws InterruptedException {

        //-------------------change user role to Guest------

        waitUntilElementClicable(By.id("profile"),TIME);
        driver.findElement(By.id("profile")).click();
        sleep();
        //waitUntilElementClicable(By.cssSelector("#idbtneditprofile"),TIME);

        driver.findElement(By.id("idbtneditprofile")).click();
        //sleep();

        waitUntilElementClicable(By.id("typeuser1inprofile"),TIME);
        driver.findElement(By.id("typeuser1inprofile")).click();
        //sleep();

        waitUntilElementClicable(By.id("idbtnsaveprofile"),TIME);
        driver.findElement(By.id("idbtnsaveprofile")).click();
        //sleep();
        //----------------user rights verification: '+' has to be unavailable ----------

        waitUntilElementClicable(By.id("ihome"),TIME);
        driver.findElement(By.id("ihome")).click();
        sleep();

        System.out.println("Guest + is  hidden: " + !driver.findElement(By.id("idcontainerbtnaddevent")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("idcontainerbtnaddevent")).isDisplayed());
    }

    @Test
    public void userProfileFamily() throws InterruptedException {
        //-------------------change user role to Family------

        waitUntilElementClicable(By.id("profile"),TIME);
        driver.findElement(By.id("profile")).click();
        sleep();

       // waitUntilElementClicable(By.cssSelector("#idbtneditprofile"),TIME);
        driver.findElement(By.id("idbtneditprofile")).click();
        //sleep();

        //waitUntilElementClicable(By.id("typeuser2inprofile"),TIME);
        driver.findElement(By.id("typeuser2inprofile")).click();
        //sleep();

        waitUntilElementClicable(By.id("idbtnsaveprofile"),TIME);
        driver.findElement(By.id("idbtnsaveprofile")).click();
        //sleep();

        //----------------user rights verification: '+' has to be available ----------

        waitUntilElementClicable(By.id("ihome"),TIME);
        driver.findElement(By.id("ihome")).click();
        //sleep();
        waitUntilElementIsVisible(By.id("idcontainerbtnaddevent"),TIME);
        System.out.println("Family + is  displayed: " + driver.findElement(By.id("idcontainerbtnaddevent")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("idcontainerbtnaddevent")).isDisplayed());
    }

    @Test
    public void userProfileGuestAndFamily() throws InterruptedException {
        //-------------------change user role to Guest And Family------

        waitUntilElementClicable(By.id("profile"),TIME);
        driver.findElement(By.id("profile")).click();
        sleep();

     //   waitUntilElementClicable(By.cssSelector("#idbtneditprofile"),TIME);
        driver.findElement(By.id("idbtneditprofile")).click();
       // sleep();

        waitUntilElementClicable(By.id("typeuser3inprofile"),TIME);
        driver.findElement(By.id("typeuser3inprofile")).click();
        //sleep();

        waitUntilElementClicable(By.id("idbtnsaveprofile"),TIME);
        driver.findElement(By.id("idbtnsaveprofile")).click();
        //sleep();

        //----------------user rights verification: '+' has to be available ----------

        waitUntilElementClicable(By.id("ihome"),TIME);
        driver.findElement(By.id("ihome")).click();
        //sleep();

        waitUntilElementIsVisible(By.id("idcontainerbtnaddevent"),TIME);
        System.out.println("Family And Guest + is  displayed: " + driver.findElement(By.id("idcontainerbtnaddevent")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("idcontainerbtnaddevent")).isDisplayed());

    }
}
