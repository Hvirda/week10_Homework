package Testsuite;

import baseFactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl="http://the-internet.herokuapp.com/login";
    @Before
    public void setup(){
        openBrowser(baseurl);
    }
    @Test
    public void test1(){
        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");
        WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
        pwd.sendKeys("SuperSecretPassword!");
        WebElement lgnbtn=driver.findElement(By.xpath("//i[text()=' Login']"));
        lgnbtn.click();

        WebElement text=driver.findElement(By.xpath("//h2[i]"));







    }
}
