package A03SeleniumPratiques;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Q19_ActionsClass_KeyboardActions extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
        //1.	https://www.facebook.com adresine gidelim
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(3000);
        //2.	Yeni hesap olustur butonuna basalim
        //cookies kismina allow diyelim
        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //3.	Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement nameElement=driver.findElement(By.xpath("//input[@name='firstname']"));
        nameElement.sendKeys("Burhan");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Semiz")
                .sendKeys(Keys.TAB)
                .sendKeys("0668793754")
                .sendKeys(Keys.TAB)
                .sendKeys("Pl.19842012*abc")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Apr")
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("1984")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        try {
            WebElement cookies = driver.findElement(By.xpath("(//*[@aria-label='Allow all cookies'])[2]"));
            cookies.click();
        } catch (NoSuchElementException e) {
            // Öğe locate edilemedi, işleme devam ediyoruz.
        }
        //4.	Kaydol tusuna basalim

    }




}
