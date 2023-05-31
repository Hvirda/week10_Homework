package testSuites;

import browserFactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void test1()throws InterruptedException{
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement lgnbtn=driver.findElement(By.cssSelector("button[type='submit']"));
        lgnbtn.click();

        //verify deshboard text on another page
        WebElement t=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualText=t.getText();
        String expectedText="Dashboard";
        Assert.assertEquals("verify login text",actualText,expectedText);

    }
//    @After
//    public void tearout(){
//        closeBrowser();
//    }

}
