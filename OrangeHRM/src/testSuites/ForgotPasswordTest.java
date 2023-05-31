package testSuites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends LoginTest {
    @Before
    @Override
    public void setup() {
        super.setup();
    }
    @Test
    public void test2(){
        WebElement forgorPassword=driver.findElement(By.xpath("//p[text()='Forgot your password? ']"));
        forgorPassword.click();
        WebElement resetpsw=driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        String resetpassword=resetpsw.getText();
        String expectedText="Reset Password";
        Assert.assertEquals("verify forgorpassword",resetpassword,expectedText);

    }
    @After
   public void closeBroser(){
        super.closeBrowser();
    }
}
