package baseFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String url){
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }
    public void closeBrowser(){
        driver.quit();
    }

}
