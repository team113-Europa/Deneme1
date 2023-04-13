package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

public class deneme extends TestBaseMethod {
    @Test
    public void test01() {
        driver.get("https://html.com/tags/iframe/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement codeExample = driver.findElement(By.xpath("//span[@id='Code_Example']"));

        js.executeScript("arguments[0].scrollIntoView();", codeExample);

        ReusableMethods2.bekle(5);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        WebElement videoButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        videoButton.click();

        ReusableMethods2.bekle(5);


        WebElement video = driver.findElement(By.xpath("//div[@style='display: none;']"));
        Assert.assertTrue(video.isEnabled());

        driver.findElement(By.xpath("//div[@style='display: none;']"));
    }
}
