package testSuite;

import baseFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://courses.ultimateqa.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void test1() {
        WebElement signIn = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        signIn.click();

        //verify title
        WebElement text = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualText = text.getText();
        System.out.println(actualText);
        String expectedText = "Welcome Back!";
        Assert.assertEquals("verify title", expectedText, actualText);

        //username
        WebElement uname = driver.findElement(By.xpath("//input[@id='user[email]']"));
        uname.sendKeys("abcd.com");

        //password
        WebElement pwd = driver.findElement(By.xpath("//input[@id='user[password]']"));
        pwd.sendKeys("");

        WebElement signinbtn = driver.findElement(By.xpath("//div/button[@class='button button-primary g-recaptcha']"));
        signinbtn.click();

        //get username error message
        WebElement uerror = driver.findElement(By.xpath("//form/div[1]/p[@class='form__error-msg']"));
        System.out.println(uerror.getText());
        String usernameerror = uerror.getText();
        String expected = "Please enter a valid email address";
        Assert.assertEquals("verify email error message", expected, usernameerror);

        //get password error message
        WebElement perror = driver.findElement(By.xpath("//form/div[2]/p[@class='form__error-msg']"));
        System.out.println(perror.getText());
        String actualerror = perror.getText();
        String expectedperror = "This field cannot be blank";
        Assert.assertEquals("verify password error message", expectedperror, actualerror);

        //get invalid user or password messege
        WebElement up = driver.findElement(By.xpath("//div/ul/li[@class='form-error__list-item']"));
        System.out.println(up.getText());
        String actualup = up.getText();
        String expectedup = "";
    }
    @After
    public void tearout(){
        closeBrowser();
    }
}
