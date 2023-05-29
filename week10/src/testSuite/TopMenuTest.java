package testSuite;

import browserFactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TopMenuTest extends BaseTest {
    WebDriver driver;
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void test2(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        WebElement computerMenu=driver.findElement(By.xpath("//a[contains(@href,/computers)]"));
        computerMenu.click();


    }
}
