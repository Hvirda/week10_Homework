package testSuite;

import browserFactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    WebDriver driver;
     WebElement computerMenu;
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void test2(){
        computerMenu=driver.findElement(By.xpath("//div/ul[2]/li/a[text()='Computers ']"));



    }
}
