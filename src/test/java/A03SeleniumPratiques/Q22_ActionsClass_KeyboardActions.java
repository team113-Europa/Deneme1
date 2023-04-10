package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

public class Q22_ActionsClass_KeyboardActions extends TestBaseMethod {
    @Test
    public void test01(){
//        1.	Bir Class olusturalim KeyboardActions2
//        2.	https://html.com/tags/iframe/ sayfasina gidelim
        driver.navigate().to("https://html.com/tags/iframe/");
//        3.	video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods2.bekle(2);
//        4.	videoyu izlemek icin Play tusuna basin
        //Burada iframe e gecis yapacagiz
        WebElement iframe= driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
        driver.switchTo().frame(iframe);
        WebElement videoButton=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        videoButton.click();
//        5.	videoyu calistirdiginizi test edin
        Assert.assertTrue(videoButton.isEnabled());
        //6. videoyu durdur. ve durduruldugunu test et ve testin sonucunu yazdir
        ReusableMethods2.bekle(2);
        WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Pause (k)']"));
        pauseButton.click();
        Assert.assertTrue(pauseButton.isEnabled());
        System.out.println(pauseButton.isEnabled());

    }
}
