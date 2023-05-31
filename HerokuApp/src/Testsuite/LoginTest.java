package Testsuite;

import baseFactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void test1() {
        String expectedUname = "tomsmith1";
        String expectedpwd = "SuperSecretPassword!";

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys(expectedUname);

        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
        pwd.sendKeys(expectedpwd);

        WebElement lgnbtn = driver.findElement(By.xpath("//i[text()=' Login']"));
        lgnbtn.click();

        //not working
//        WebElement text=driver.findElement(By.xpath("//div/div/h2/i[@class='icon-lock']"));
//        System.out.println(text.getText());

        //password errormessage
        WebElement uerror = driver.findElement(By.xpath("//div[contains(text(),' Your username is invalid')]"));
        System.out.println(uerror.getText());
        String actualunameerror = uerror.getText();
        String expectedunameerror = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals("verify username error", expectedunameerror, actualunameerror);


        //username errormessage
        WebElement perror = driver.findElement(By.xpath("//*[contains(text(),' Your password is invalid')]"));
        System.out.println(perror.getText());
        String actualpwderror = perror.getText();
        String expectedpwderror = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals("verify password error", expectedpwderror, actualpwderror);


    }

    public void teatdown() {
        closeBrowser();
    }
}
