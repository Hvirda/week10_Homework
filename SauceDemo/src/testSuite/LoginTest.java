package testSuite;

import baseFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl="https://www.saucedemo.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void test1(){
        WebElement uname=driver.findElement(By.xpath("//input[@id='user-name']"));
        uname.sendKeys("standard_user");
        WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
        pwd.sendKeys("secret_sauce");
        WebElement btn=driver.findElement(By.xpath("//input[@id='login-button']"));
        btn.click();

        WebElement product=driver.findElement(By.xpath("//div/span[text()='Products']"));
        String actualProduct=product.getText();
        String expectedProduct="Products";
        Assert.assertEquals("verify product",expectedProduct,actualProduct);

       List<WebElement> item= driver.findElements(By.xpath("//div[@class='inventory_item']"));
        System.out.println(item.size());

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
