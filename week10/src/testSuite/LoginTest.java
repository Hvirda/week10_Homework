package testSuite;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://demo.nopcommerce.com/";



    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void test1(){
        WebElement link=driver.findElement(By.linkText("Log in"));
        link.click();
        WebElement text=driver.findElement(By.xpath("//div/h1"));
        String actualText=text.getText();
        String expextedText="Welcome, Please Sign In!";
        Assert.assertEquals("verify",expextedText,actualText);

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("virda.hiral@yahoo.co.in");
        WebElement pasword=driver.findElement(By.id("Password"));
        pasword.sendKeys("Hir@123");
        WebElement lgnbtn=driver.findElement(By.xpath("//form/div[3]/button"));
        lgnbtn.click();

        WebElement logout=driver.findElement(By.linkText("Log out"));
        String actualText1=logout.getText();
        String ExpectedText="Log out";
        Assert.assertEquals("verify logout",ExpectedText,actualText1);

        WebElement errormsg=driver.findElement(By.xpath("//div[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        String actualError=errormsg.getText();
        String expectedError="Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals("verify error massege",actualError,expectedError);
    }


    @After
    public void close(){
        tearDown();
    }
}
