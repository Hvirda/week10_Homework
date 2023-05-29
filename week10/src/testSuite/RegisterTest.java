package testSuite;

import browserFactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {

    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void test1(){
      WebElement register=driver.findElement(By.cssSelector("a.ico-register"));
      register.click();

        WebElement actualRegister1=driver.findElement(By.xpath("//h1[text()='Register']")); //get actual text
        String actualRegister=actualRegister1.getText();
        String expectedRegister="Register";
        Assert.assertEquals("verify register",actualRegister,expectedRegister); //verify two result

        WebElement gender=driver.findElement(By.xpath("//input[@value='F']"));  //radiobutton field
        gender.click();

        WebElement fname=driver.findElement(By.xpath("//input[@id='FirstName']")); //lastname field
        fname.sendKeys("abc");


        WebElement lname=driver.findElement(By.xpath("//input[@id='LastName']"));  //lastname field
        lname.sendKeys("efg");

        WebElement days=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));  //select day
        Select day=new Select(days);
        day.selectByVisibleText("15");

        WebElement months=driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));  //select day
        Select month=new Select(months);
        month.selectByVisibleText("August");

        WebElement years=driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));  //select day
        Select year=new Select(years);
        year.selectByVisibleText("1990");


        WebElement email=driver.findElement(By.id("Email"));       //email
        email.sendKeys("virda.hiral@yahoo.co.in");
        WebElement pasword=driver.findElement(By.id("Password"));   //password
        pasword.sendKeys("Hir@123");
        WebElement cpasword=driver.findElement(By.id("ConfirmPassword"));    //conform password
        cpasword.sendKeys("Hir@123");

        WebElement registerbtton=driver.findElement(By.xpath("//button[@id='register-button']"));
        registerbtton.click();

        WebElement s=driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String actualregText=s.getText();
        String expectedregText="Your registration completed";
        Assert.assertEquals("verify register complete",actualregText,expectedregText);

    }

}
