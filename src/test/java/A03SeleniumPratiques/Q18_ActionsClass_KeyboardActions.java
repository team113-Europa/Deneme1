package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Q18_ActionsClass_KeyboardActions extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
//        1- Bir Class olusturalim KeyboardActions1
//        2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
//        3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusuElementi= driver.findElement(By.id("twotabsearchtextbox"));
        Actions action=new Actions(driver);
        action.click(aramaKutusuElementi)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(3000);
//        4- aramanin gerceklestigini test edin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());
    }
}
