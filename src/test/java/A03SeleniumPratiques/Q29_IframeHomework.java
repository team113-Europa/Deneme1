package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class Q29_IframeHomework extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
       //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebElement iframeElement01= driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(iframeElement01);
       //2. “Our Products” butonuna basin
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
       //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//img[@id='camera-img']")).click();
       //4. Popup mesajini yazdirin
        Thread.sleep(3000);
        WebElement popUpMessage=driver.findElement(By.xpath("//h4[@class='modal-title']"));
        System.out.println("PopUp Mesaji : " +popUpMessage.getText());
       //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
       //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
       //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
    }
}
