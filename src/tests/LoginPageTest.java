package tests;
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{




    @Test
    public void LoginPositive() throws InterruptedException {

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
        //sleep();

        waitUntilElementAttributeContainsText(By.id("profile"),"title","My Profile: "+USERNAME,TIME);
        WebElement profileButton = driver.findElement(By.id("profile"));

        System.out.println("title of profileButton: "
                +profileButton.getAttribute("title"));



        Assert.assertTrue(profileButton.getAttribute("title").contains(USERNAME));
    }

    @Test
    public void loginNegative() throws InterruptedException {

        String wrongPassword = USERPASSWORD+"u";


        //--------Login window openning----------------

        waitUntilElementClicable(By.id("idsignin"),TIME);
        driver.findElement(By.id("idsignin")).click();
        //sleep();

        //------- Not correct login/password entering--------------------

        waitUntilElementClicable(By.id("logininput"),TIME);
        WebElement loginField = driver.findElement(By.id("logininput"));
        loginField.click();
        loginField.sendKeys(USERNAME);

        waitUntilElementClicable(By.id("passwordinput"),TIME);
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        passwordField.click();
        passwordField.sendKeys(wrongPassword);

        waitUntilElementClicable(By.id("signinrequest"),TIME);
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        //sleep();

        //------Receive wrong authorization message and close login window ------

        waitUntilElementIsVisible(By.id("wrongloginorpassword"),TIME);
        WebElement wrongAuthText = driver.findElement(By.id("wrongloginorpassword"));
        System.out.println("Wrong Authorization text: " + wrongAuthText.getText().contains("Wrong Authorization!"));

        waitUntilElementClicable(By.id("closedsignin"),TIME);
        WebElement closeLogin = driver.findElement(By.id("closedsignin"));
        closeLogin.click();
        //sleep();

        //------- Home window (not authorized) verification -----------

        waitUntilElementIsVisible(By.xpath("//span[contains(text(),'Home')]"),TIME);
        WebElement homeIcon = driver.findElements(By.className("navi-item")).get(0);

        waitUntilElementIsVisible(By.xpath("//span[contains(text(),'Login')]"),TIME);
        WebElement loginIcon = driver.findElements(By.className("navi-item")).get(1);

        waitUntilElementIsVisible(By.xpath("//span[contains(text(),'Registration')]"),TIME);
        WebElement registrationIcon = driver.findElements(By.className("navi-item")).get(2);

        WebElement homeAuthIcon = driver.findElement(By.id("ihome"));
        WebElement profileIcon = driver.findElement(By.id("profile"));


        System.out.println("Home icon is displayed: " + homeIcon.isDisplayed());
        System.out.println("Login icon is displayed: " + loginIcon.isDisplayed());
        System.out.println("Registration icon is displayed: " + registrationIcon.isDisplayed());
        System.out.println("Home auth icon isn't displayed: " + !homeAuthIcon.isDisplayed());
        System.out.println("Profile icon isn't displayed: " + !profileIcon.isDisplayed());

        //Assert.assertTrue(homeIcon.isDisplayed() && loginIcon.isDisplayed() && registrationIcon.isDisplayed() && !homeAuthIcon.isDisplayed() && !profileIcon.isDisplayed());

          int counter = 0;
          if(homeIcon.isDisplayed()) counter++;
          if(loginIcon.isDisplayed()) counter++;
          if(registrationIcon.isDisplayed()) counter++;
          if(!homeAuthIcon.isDisplayed()) counter++;
          if(!profileIcon.isDisplayed()) counter++;

            Assert.assertTrue(counter == 5);


    }




}
