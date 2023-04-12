package A03SeleniumPratiques;

import com.beust.ah.A;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

import java.util.ArrayList;
import java.util.List;

public class Q30_WindowHandleHomework extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        //Actions actions=new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        List<String> windowHandle=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(1));
        //5."username" ve "password" kutularina deger yazdirin
        WebElement usernameElement=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        usernameElement.sendKeys("Burhan");
        WebElement passwordElement=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordElement.sendKeys("semiz123");
        Thread.sleep(4000);
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedText="validation failed";
        String actualText=driver.switchTo().alert().getText();
        Assert.assertTrue(actualText.contains(expectedText));
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(windowHandle.get(0));
        //10.Ilk sayfaya donuldugunu test edin
        String expectedUrl="http://webdriveruniversity.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test PASSED : " + " ExpectedURL " +expectedUrl+ " == "+" ActualURL " +actualUrl);
        }else {
            System.out.println("Test FAILED : " + " ExpectedURL " +expectedUrl+" != "+" ActualURL " +actualUrl);
        }

    }

}
