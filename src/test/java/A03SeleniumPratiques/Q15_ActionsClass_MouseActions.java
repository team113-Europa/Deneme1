package A03SeleniumPratiques;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

import java.util.Set;

public class Q15_ActionsClass_MouseActions extends TestBaseMethod {
    @Test
    public void test01() throws InterruptedException {
//        1- Yeni bir class olusturalim: MouseActions1
//        2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Thread.sleep(3000);
//        3- Cizili alan uzerinde sag click yapin
        Actions action=new Actions(driver);
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        action.contextClick(ciziliAlan).perform();
        Thread.sleep(3000);
//        4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlert="You selected a context menu";
        String actualAlert=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert, actualAlert);
//        5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        String ilksayfaWHD=driver.getWindowHandle();
//        6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
//        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> ikiSayfaninWHDSeti=driver.getWindowHandles();
        String ikinciWHD="";
        for (String eachWHD:ikiSayfaninWHDSeti
             ) {
            if (!eachWHD.equals(ilksayfaWHD)){
                ikinciWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWHD);
        String expectedElementalSeleniumPage="Elemental Selenium";
        String actualElementalSeleniumPage=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualElementalSeleniumPage, expectedElementalSeleniumPage);
    }
}
