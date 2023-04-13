package A03SeleniumPratiques;

import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods2;
import utilities.TestBaseMethod;

public class Q38_JSExecutors extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
//amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        // sell linkine JS executor kullanarak click yapin
        WebElement sellLink= driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", sellLink);


        // amazon sayfasindayken bu window'un window handle degerini alip kaydetmeliyiz
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve gittigimizi test edin

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");
        ReusableMethods2.bekle(2);
        WebElement contactLink=driver.findElement(By.xpath("//*[@id=\"menu-item-3925\"]/a"));
        JavascriptExecutor jse2=(JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].click();", contactLink);


    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        //contact i JS ile click leyelim
        ReusableMethods2.bekle(2);
        WebElement contactLink=driver.findElement(By.xpath("//*[@id=\"menu-item-3925\"]/a"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", contactLink);

    }
}
